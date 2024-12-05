import kotlin.system.exitProcess

fun main() {
    val stores = listOf(
        RepairStore("Москва").apply {
            phones["iPhone 13"] = 80000
            phones["Samsung Galaxy S21"] = 70000
        },
        RegularStore("Санкт-Петербург").apply {
            phones["iPhone 13"] = 75000
            phones["Samsung Galaxy S21"] = 68000
        }
    )

    while (true) {
        println("\nДобро пожаловать в сеть магазинов по продаже телефонов!")
        println("Выберите город:")
        stores.forEachIndexed { index, store -> println("${index + 1}. ${store.city}") }
        println("0. Выход")

        when (val cityChoice = readLine()?.toIntOrNull()) {
            0 -> exitProcess(0)
            in 1..stores.size -> {
                val selectedStore = stores[cityChoice!! - 1]
                handleStore(selectedStore)
            }
            else -> println("Неверный выбор. Попробуйте снова.")
        }
    }
}

fun handleStore(store: Store) {
    while (true) {
        println("\nВы находитесь в магазине города ${store.city}.")
        println("Доступные действия:")
        println("1. Купить телефон")
        println("2. Показать статистику")
        println("3. Ремонт телефона")
        println("0. Вернуться в главное меню")

        when (val action = readLine()?.toIntOrNull()) {
            0 -> return
            1 -> {
                println("Доступные модели:")
                store.phones.forEach { (model, price) ->
                    println("- $model: $price руб.")
                }
                println("Введите название модели для покупки:")
                val model = readLine()
                if (model != null) store.buyPhone(model)
                else println("Некорректный ввод.")
            }
            2 -> store.showStatistics()
            3 -> store.offerRepair()
            else -> println("Неверный выбор. Попробуйте снова.")
        }
    }
}
