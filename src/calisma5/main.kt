package calisma5

import java.io.File

/* Bu kod, 1000 satırlık bir .txt dosyasında kullanıcının girdiği
kelimeyi arar ve o kelimenin bulunduğu satır numarasını ve satırın içeriğini ekrana yazdırır
 */


fun main() {
    val dosya = File("C:/Users/90507/OneDrive/Masaüstü/fenerbahce.txt")

    // Eğer dosya mevcut değilse oluştur
    if (!dosya.exists()) {
        println("Dosya bulunamadı, oluşturuluyor..")
        if (dosya.createNewFile()) {
            println("Dosya başarıyla oluşturuldu.")
            dosya.writeText(metin)
        } else {
            println("Dosya oluşturulamadı.")
            return
        }
    }
    // Dosya içeriğini oku
    val mevcutIcerik = dosya.readText()

    // Metni belirli bir uzunlukta satırlara ayır
    val satirUzunlugu = 80
    val satirlar = mevcutIcerik.chunked(satirUzunlugu)

    // Güncellenmiş içeriği dosyaya yaz
    dosya.writeText(satirlar.joinToString("\n"))

    while (true) {
        println("Aramak istediğiniz kelimeyi girin (çıkmak için 'çıkış' yazın): ")
        val anahtarKelime = readLine()?.trim()?.lowercase() ?: continue

        if (anahtarKelime == "çıkış") break

        var kelimeBulundu = false
        var satirSayaci = 1

        dosya.forEachLine { satir ->
            val kucukHarfliSatir = satir.lowercase()
            if (kucukHarfliSatir.contains(anahtarKelime)) {
                println("Kelimeniz $satirSayaci. satırda bulundu")
                println("Satır: $satir")
                kelimeBulundu = true
            }
            satirSayaci++
        }

        if (!kelimeBulundu) {
            println("Aradığınız kelime dosyada bulunamadı.")
        }
    }
    println("Program kapanıyor...")
}

fun kucukyap(metin: String): String
{
    return metin.lowercase()
}