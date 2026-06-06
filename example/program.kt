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
    fun main() {
        println("Тестирование компилятора DemoLang ")

        // 1. Цикл 'for' перебирает диапазон чисел от 1 до 10
        for (i in 1..10) {

            // 2. Оператор 'if' проверяет, является ли число нечетным
            if (i % 2 != 0) {
                println("\nНайдено нечетное число: $i")

                // Переменные для цикла while
                var count = 1
                var product = 1

                print("  Вычисляем произведение чисел от 1 до $i с помощью цикла while: ")

                // 3. Цикл 'while' выполняется, пока count меньше или равен текущему нечетному числу i
                while (count <= i) {
                    product *= count
                    count++ // Увеличение счетчика (инкремент)
                }

                println(product)
            }
        }
    }
}