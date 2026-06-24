fun main() {
//    fun drawSnowflake(size: Int) {
//        val n = size * 2 + 1
//        val center = size
//        for (y in 0..n - 1) {
//            for (x in 0..n - 1) {
//                if (x == center) { print("*"); continue }
//                if (y == center) { print("*"); continue }
//                if (x == y) { print("*"); continue }
//
//                val sum = x + y
//                val target = center * 2
//                if (sum == target) { print("*"); continue }
//
//                print(" ")
//            }
//            println_empty()
//        }
//    }

    fun drawSnowflake(size: Int) {
        val n = size * 2 + 1
        val center = size
        for (y in 0..n - 1) {
            for (x in 0..n - 1) {
                if (x == center || y == center || x == y || x + y == center * 2) {
                    print("*")
                } else {
                    print(" ")
                }
            }
            println_empty()
        }
    }
    drawSnowflake(8)
}