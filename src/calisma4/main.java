package calisma4;

import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        //doğru ifadeye daha çok yaklaşmamız için terim sayısını çok tutmamız lazım
        //tan(45)=1 dir. ters fonksiyonunu aldığımızda arctan(1)=45 derece olur. bunu radyan
        //cinsinden gösterirsek arctan(1)=pi/4 olur. Yani pi=4.arctan(1) olur.
        //biz de piyi Gregory-Leibniz Serisi ile hesaplayıp daha sonra bir dairenin alanını
        //hesaplayan kodu yazıcaz.
        //bu seride her bir terim (-1)^n/2*n+1 ile bulunur.

        int terimsayisi=1000000;
        double pi=piHesapla(terimsayisi);
        double alanSonuc=DaireAlanhesapla(pi);
        System.out.println("Dairenin alanı: "+alanSonuc);

    }

    public static double piHesapla(int terimsayisi) {
           double toplam=0.0;
           for(int i=0;i<terimsayisi;i++){
               double isaretSayi;
               if(i%2==0){
                   isaretSayi=1.0;
               }
               else{
                   isaretSayi=-1.0;
               }
               double terim=isaretSayi/(2*i+1);
               toplam += terim;
           }
           return 4 * toplam;

    }
    public static double DaireAlanhesapla(double pi){
        Scanner scan=new Scanner(System.in);
        System.out.println("Yarıçapı gir: ");
       double yaricap=scan.nextInt();
       return pi*yaricap*yaricap;

    }
}
