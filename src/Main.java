import java.util.Scanner;

/*Java ile mesafeye ve şartlara göre uçak bileti fiyatı hesaplayan programı yapın. Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgilerini alın. Mesafe başına ücret 0,10 TL / km olarak alın. İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki indirimleri uygulayın ;

Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır. Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
İpucu
Normal Tutar = Mesafe * 0.10 = 1500 * 0.10 = 150 TL
Yaş İndirimi = Normal Tutar * Yaş İndirim Oranı = 150 * 0.10= 15 TL
İndirimli Tutar = Normal Tutar – Yaş İndirimi = 150 – 15 = 135 TL
Gidiş Dönüş Bilet İndirimi = İndirimli Tutar * 0.20 = 135 * 0.20 = 27 TL
Toplam Tutar = (135-27)* 2 = 216 TL */


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mesafeyi KM cinsinden giriniz: ");
        int mesafe = scanner.nextInt(); //kullanıcıdan mesafeyi alıyoruz

        System.out.print("Yaşınızı giriniz: ");
        int yas = scanner.nextInt(); //kullanıcıdan yas değerini alıyoruz

        System.out.print("Yolculuk tipini giriniz (1 => Tek Yön, 2 => Gidiş-Dönüş): ");
        int yolculukTipi = scanner.nextInt(); //yolculuk tipini alıyoruz

        double biletFiyati = mesafe * 0.10; // soruda verilen mesafe başına ücret değeri 0.10 TL

        if (mesafe > 0 && yas > 0 && (yolculukTipi == 1 || yolculukTipi == 2)) {
            if (yas < 12) {
                biletFiyati *= 0.5; // 12 yasından kucukse %50 indirim
            } else if (yas >= 12 && yas <= 24) {
                biletFiyati *= 0.9; // 12 ve 24 aralığında ise %10 indirim
            } else if (yas > 65) {
                biletFiyati *= 0.7; // 65 yasından büyükse %30 indirim
            }

            if (yolculukTipi == 2) {
                biletFiyati *= 0.8;// gidis donus bileti için %20 indirim
                biletFiyati *= 2; //iki bilet için 2 ile carpiyoruz
            }
            /*Tekrar toplama islemi gerçekleştirmek yerine direk tutar hesaplamanın
            kodu kısa tutacağını düsünüyorum
             */

            System.out.println("Toplam bilet fiyatı: " + biletFiyati + " TL");
        } else {
            System.out.println("Hatalı Veri Girdiniz!"); //eğer 1 veya 2 disinda deger girilir ise hatali islem
        }
    }
}
