abstract class Store(val city: String) {
    val phones = mutableMapOf<String, Int>()
    val sales = mutableMapOf<String, Int>()
    open fun buyPhone(model: String) {
        if (phones.containsKey(model)) {
            val price = phones[model]!!
            sales[model] = sales.getOrDefault(model, 0) + 1
            println("Вы купили $model за $price руб.")
        } else {
            println("Такой модели нет в наличии.")
        }
    }
    abstract fun offerRepair(): Boolean
    fun showStatistics() {
        println("Статистика продаж:")
        sales.forEach { (model, count) ->
            println("- $model: $count шт.")
        }
        val totalRevenue = sales.map { (model, count) -> phones[model]!! * count }.sum()
        println("Общая сумма покупок: $totalRevenue руб.")
    }
}