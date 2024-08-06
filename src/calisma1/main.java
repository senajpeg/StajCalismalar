package calisma1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("0-100 arasında İlk sayıyı gir :");
        int a1=scan.nextInt();
        System.out.println("0-100 arasında İkinci sayıyı gir :");
        int a2= scan.nextInt();
        if(a1 < 0 || a1>100  || a2<0 || a2>100){
            System.out.println("Girdiğiniz sayılar 0-100 arasında olmalıdır!");
        }
        int carpim=a1*a2;
        if(carpim<100){
            System.out.println("Çarpım " +carpim + "dir ve 100'den küçüktür");
        }
        else{
            System.out.println("Çarpım " + carpim +"dir ve 100'den büyüktür.");
        }

    }
}
