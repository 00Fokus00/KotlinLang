fun main() {
    println("--- Тестирование компилятора DemoLang ---")
    println_empty()

    val maxLimit = 100
    val randomNumber = rnd(maxLimit)

    print("Случайное число от 0 до 99: ")
    println(convert_int(randomNumber))

    val value = -64.0
    val absoluteValue = abs_float(value)
    val root = sqrt(absoluteValue)

    print("Абсолютное значение: ")
    println(convert_float(absoluteValue))

    print("Квадратный корень: ")
    println(convert_float(root))

    if (randomNumber > 50) {
        println("Результат: Число больше 50!")
    } else {
        println("Результат: Число меньше или равно 50!")
    }

    fun compute(a: Int, b: Int): Int {
            var h = 2;
            h = 3;
        }

    println("----------------------------------------")
}