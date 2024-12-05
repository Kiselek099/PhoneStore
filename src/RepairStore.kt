class RepairStore(city: String) : Store(city) {
    private var repairOffered = false

    override fun offerRepair(): Boolean {
        if (!repairOffered) {
            println("У вас сломан телефон? Хотите починить его? (да/нет)")
            val response = readLine()?.lowercase()
            repairOffered = true
            if (response == "да") {
                println("Ваш телефон отремонтирован!")
                return true
            } else {
                println("Ремонт не требуется.")
            }
        } else {
            println("Ремонт уже предлагался.")
        }
        return false
    }
}