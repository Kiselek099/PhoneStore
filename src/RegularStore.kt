class RegularStore(city: String) : Store(city) {
    override fun offerRepair(): Boolean {
        println("В этом магазине ремонт недоступен.")
        return false
    }
}