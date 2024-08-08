package calisma2

fun main() {
    /*
       Yazılan bir kelimeyi önce 16'lık tabana, sonra 2'lik tabana dönüştürme.
       İlk olarak bunların ASCII değerini bulmamız lazım. ASCII değeri, bilgisayarın bu harf
       karakterlerini işlemesi için gerekli ve her bir harfin bir ASCII değeri var ve ASCII değeri decimaldir.
    */
    val kelime: String? = readLine()
    val asciidegerler = kelime?.map { it.toInt() } // Kelimenin içindeki her karakterin ASCII değerini alır

    // Her bir ASCII değerini hexadecimal formatına döndürdükten sonra, bu değerleri aralarına boşluk koyarak birleştirir
    val hexdeger = asciidegerler?.joinToString(separator = " ") { decimalToHex(it) }

    // Hexadecimal değerleri alıp, her birini binary formatına döndürür ve aralarına boşluk koyar
    val binarydeger = asciidegerler?.joinToString(separator = " ") { decimalToBinary(it) }

    println("Hexadecimal değeri: $hexdeger")
    println("Binary değeri: $binarydeger")
}

fun decimalToHex(decimal: Int): String {
    if (decimal == 0) return "0"
    var sayi = decimal
    val hexKarakterleri = "0123456789ABCDEF"
    var hexKelime = ""

    while (sayi > 0) {
        val kalan = sayi % 16
        hexKelime = hexKarakterleri[kalan] + hexKelime
        sayi /= 16
    }
    return hexKelime
}

fun decimalToBinary(decimal: Int): String {
    if (decimal == 0) return "0000"
    var sayi = decimal
    var binaryKelime = ""

    while (sayi > 0) {
        val kalan = sayi % 2
        binaryKelime = kalan.toString() + binaryKelime
        sayi /= 2
    }

    // Binary kelimenin uzunluğunu 4 haneli yapar
    while (binaryKelime.length < 4) {
        binaryKelime = "0" + binaryKelime
    }

    return binaryKelime
}
