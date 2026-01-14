fun main() {
    var typeOfCard = "Мир"
    val tax = calculateTax("Mastercard", 100000, 0, 0, 0, 0, 0, 0)
    println(tax)
}

fun calculateTax(typeOfCard: String, pay: Int, dayPay1: Int, monthPay1: Int, dayPay2: Int, monthPay2: Int, dayPay3: Int, monthPay3: Int) = when(typeOfCard) {
    "Mastercard" -> calculateForMastercard(pay, dayPay1, monthPay1)
    "Visa" -> calculateForVisa(pay, dayPay2, monthPay2)
    "Мир" -> calculateForMir(pay, dayPay3, monthPay3)
    else -> 0
}

fun calculateForMastercard(pay: Int, dayPay1: Int, monthPay1: Int): Int {
    if (dayPay1 + pay <= 150000 && monthPay1 + pay <= 600000) {
        val total = if (pay + monthPay1 < 75000) 0 else ((pay - 75000) * 0.006 + 20)
        return total.toInt()
    } else {
        println("Операция не выполнена, лимит по карте превышен!")
    }
    return 0
}

fun calculateForVisa(pay: Int, dayPay2: Int, monthPay2: Int): Int {
    if (dayPay2 + pay <= 150000 && monthPay2 + pay <= 600000) {
        val total = if (pay * 0.0075 > 35) (pay * 0.0075) else 35
        return total.toInt()
    } else {
        println("Операция не выполнена, лимит по карте превышен!")
    }
    return 0
}

fun calculateForMir(pay: Int, dayPay3: Int, monthPay3: Int): Int {
    if (dayPay3 + pay <= 150000 && monthPay3 + pay <= 600000) {
        return 0
    } else {
        println("Операция не выполнена, лимит по карте превышен!")
    }
    return 0
}

