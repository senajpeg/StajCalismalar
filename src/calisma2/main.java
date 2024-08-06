package calisma2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

       /*
       Yazılan bir keilmeyi önce 16 lık tabana,sonra 2 lik tabana dönüştürme.
       ilk olarak bunların  ASCII değerini bulmamız lazım. ASCII değeri,bilgisyarın bu harf
       karakterlerini işlemesi için gerekli ve her bir harfın bir ASCII değeri var.ve ascıı değeri decimaldir.
        */
        Scanner scan = new Scanner(System.in);
        System.out.println("Kelime gir: ");
        String kelime=scan.nextLine();

        // burada kelimenin her karakterinin ASCII değerini alıyoruz dönüştürüyoruz.
        String hexdeger= " ";
        for(char i : kelime.toCharArray())
        {
            int asciiDeger=(int) i;
            hexdeger=hexdeger+decimalToHex(asciiDeger);

        }
        System.out.println("kelimenin hexadecimal karşılığı: "+hexdeger);
        String binarydeger=hexToBinary(hexdeger);
        System.out.println("kelimenin binary karşılığı: "+binarydeger);
    }

    public static String decimalToHex(int dc){
        String hexdeger =" ";
        while(dc>0)
        {
            int kalan = dc %16;
            hexdeger= convertToHex(kalan ) +hexdeger;
            dc=dc/16;
        }
        while (hexdeger.length() < 2)
        {
            hexdeger = "0" + hexdeger;
        }
        return hexdeger.isEmpty() ? "00" : hexdeger;
    }
    public static char convertToHex(int a) {
        if (a >= 0 && a <= 9) { //burada 0-9 arasındakiler için önce askiiye ordan karakter karşılığına çeviriyoruz
            return (char) (a + '0');
        } else if (a >= 10 && a <= 15) { // 10-15 arası için
            return (char) (a - 10 + 'A');
        }
        return '?';  }
    public static String hexToBinary(String hexdeger){
        StringBuilder binaryString = new StringBuilder();

        for (char hexChar : hexdeger.toCharArray()) {
            binaryString.append(hexCharToBinary(hexChar));
        }

        return binaryString.toString();
    }
    public static String hexCharToBinary(char hexChar){
        // Hexadecimal karakterini integer değerine dönüştür
        int decimaldeger = hexChar >= '0' && hexChar <= '9' ? hexChar - '0' : (hexChar - 'A' + 10);

        // Decimal değeri 4-bit binary formata dönüştür
        String binaryValue = Integer.toBinaryString(decimaldeger);
        return String.format("%4s", binaryValue).replace(' ', '0');

    }
    }

