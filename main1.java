
import java.util.Scanner;

public class main1 {

    public static void main(String[] args) {
        Musteri musteri = new Musteri("123", "Eren", "Aksu", 10, "12345", "123", 1000);
        Musteri musteri1 = new Musteri("123", "Ahmet", "Ahemt", 10, "12345667", "12", 10);
        Musteri musteri2 = new Musteri("1234", "Mahmut", "Mahmut", 20, "12347", "1234", 10);
        Scanner scanner = new Scanner(System.in);
        Atm atm = new Atm(musteri, musteri1,musteri2);

        System.out.println("Banka Sistemine Hosgeldiniz...\n"
                + "Musterimiz Misiniz ?\n"
                + "Musteri iseyseniz : Evet Giriniz...\n"
                + "Degilseniz : Hayir Giriniz...\n");
        String kontrol = scanner.nextLine();
        if (kontrol.equals("Evet")) {
            System.out.println("Lutfen Musteri Numaranizi Giriniz...");
            String musteriNo = scanner.nextLine();
            if (musteri.getMusteriNo().equals(musteriNo) || musteri1.getMusteriNo().equals(musteriNo)) {
                System.out.println("Musteri Sifrenizi Giriniz...");
                String musteriSifre = scanner.nextLine();
                if (musteri.getMusteriSifre().equals(musteriSifre) || musteri1.getMusteriSifre().equals(musteriSifre)) {
                    atm.musteriGiris(musteriSifre, musteriNo);
                }
            }
        } else if (kontrol.equals("Hayir")) {
            atm.Musteri(musteri2);
        }
    }
}
