package calisma3;

public class main {
    /*
    F(2,3) kuvvet alanını C: (0,0) dan (1,1) arasında yaptığı işi line integral ile bulduran kod
      doğrusal yol olacak . C : x=t,y=t; t:0-1 arasında olacak.*/
    public static void main(String[] args) {
        double a = 0.0;  // başlangıç noktası
        double b = 1.0;  // bitiş noktası
        int n = 1000;    // dilim sayısı
        double result = 0.0;
        double delta = (b - a) / n; // her bir yolun uzunluğu

        for (int i = 0; i < n; i++) {
            double t1 = a + i * delta;
            double t2 = a + (i + 1) * delta;
            double midT = (t1 + t2) / 2.0;

            double x = midT; //her bir aralığın orta noktası
            double y = midT;

            // Kuvvet vektör bileşenleri Fx ve Fy
            double Fx = 2.0;
            double Fy = 3.0;

            // Diferansiyel uzunluk dx ve dy
            double dx = delta;  // x = t olduğu için dx = dt
            double dy = delta;  // y = t olduğu için dy = dt

            // Diferansiyel iş dW = Fx*dx + Fy*dy
            double dW = Fx * dx + Fy * dy;

            result += dW;
        }

        System.out.println("Yapılan iş: " + result);
    }
    }

