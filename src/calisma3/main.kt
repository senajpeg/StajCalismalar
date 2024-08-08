fun KuvvetHesapla(x: Double, y: Double): Pair<Double, Double> {
    val fx = x - y
    val fy = x - y
    return Pair(fx, fy)
}

fun lineIntegral(x0: Double, y0: Double, x1: Double, y1: Double, n: Int): Double {
    val dx = (x1 - x0) / n
    val dy = (y1 - y0) / n
    var x = x0
    var y = y0
    var iş = 0.0

    for (i in 0 until n) {
        val (fx, fy) = KuvvetHesapla(x, y)
        iş += fx * dx + fy * dy
        x += dx
        y += dy
    }

    return iş
}

fun main() {
    val x0 = 0.0
    val y0 = 0.0
    val x1 = 2.0
    val y1 = 5.0
    val n = 1000 //adım

    val iş = lineIntegral(x0, y0, x1, y1, n)
    println("Hesaplanan iş: $iş")
}
