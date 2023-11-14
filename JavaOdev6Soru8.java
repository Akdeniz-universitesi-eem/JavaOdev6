
import java.util.Random;
import java.util.Scanner;




class Main {
public static void main(String[] args) {
  Random random = new Random();
   Scanner scanner = new Scanner(System.in);
        String[] cityNames = {"ANKARA", "KONYA", "ANTALYA", "ISTANBUL", "ERZINCAN", "ESKISEHIR", "IZMIR", "VAN", "EDIRNE", "CANAKKALE"};
        int randomNumber = random.nextInt(10) ;
         String secilenSehir = cityNames[randomNumber].toUpperCase(); // Şehir isimlerini büyük harfle sakla
         char[] tahmin = new char[secilenSehir.length()];
        for (int i = 0; i < secilenSehir.length(); i++) {
            tahmin[i] = '_';
    }
     // Oyun başlangıcı
        System.out.println("Adam Asmaca Oyununa Hoş Geldiniz!");

        // Oyun süresi başlangıcı
        long baslangicZamani = System.currentTimeMillis();

        int puan = 100; // Başlangıçta maksimum puan

        while (true) {
          
            System.out.println("Tahmin: " + new String(tahmin));
            System.out.println("Puan: " + puan);

            // Denenicek harfi giriniz
            System.out.print("Bir harf girin: ");
          
            char girilenHarf = scanner.next().toUpperCase().charAt(0); // Girilen harfi buyuk harfe cevirir

            // Harfin doğruluğunu kontrol et
            boolean harfDogru = false;
            for (int i = 0; i < secilenSehir.length(); i++) {
                if (secilenSehir.charAt(i) == girilenHarf) {
                    tahmin[i] = girilenHarf;
                    harfDogru = true;
                }
            }

            // Hatalı tahmin durumu
            if (harfDogru==false) {
                puan -= 10;
                System.out.println("Yanlış tahmin! 10 puan ceza.");
            }

            // Kazanma durumu
            if (new String(tahmin).equals(secilenSehir)) {
                System.out.println("Tebrikler! Doğru tahmin: " + secilenSehir);
                break;
            }

            // Süre kontrolü
            long gecenSure = (System.currentTimeMillis() - baslangicZamani);
            if (gecenSure > 10000) {//Milisaniye cinsinden hesaplanir
                System.out.println("Üzgünüm, süre doldu. Doğru cevap: " + secilenSehir);
                break;
            }
        }

        // Puanlama
        if (puan < 0) {
            puan = 0; // Minimum puan sınırı
        }
        System.out.println("Oyun bitti! Toplam puan: " + puan);

        scanner.close();
    }
    
    


}

