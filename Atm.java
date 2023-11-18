
import java.util.Scanner;

public class Atm implements Interface {

    Musteri musteri;
    Musteri musteri1;
    Musteri musteri2;
    Scanner scanner = new Scanner(System.in);

    public Atm(Musteri musteri, Musteri musteri1, Musteri musteri2) {
        this.musteri = musteri;
        this.musteri1 = musteri1;
        this.musteri2 = musteri2;
    }

    public void musteriGiris(String musteriSifre, String musteriNo) {
        if (musteri.getMusteriNo().equals(musteriNo) && musteri.getMusteriSifre().equals(musteriSifre) || musteri1.getMusteriNo().equals(musteriNo) && musteri1.getMusteriSifre().equals(musteriSifre)) {
            System.out.println("Kullanici Girisi Basarili...\n"
                    + "Yapmak Istediginiz Islemi Seciniz:\n"
                    + "1:Para Yatir\n"
                    + "2:Para Cek\n"
                    + "3:Cikis Yap\n"
                    + "4:Musterinin Bilgilerini Yazdir\n"
                    + "5:Para Transferi Yap ");
            int var = scanner.nextInt();
            if (var == 1) {
                System.out.println("Yatirmak Istediginiz Miktari Giriniz...");
                int var1 = scanner.nextInt();
                parayatir(var1, musteri);
            } else if (var == 2) {
                System.out.println("Cekmek Istediginiz Miktari Giriniz...");
                int var1 = scanner.nextInt();
                paracek(var1, musteri);
            } else if (var == 3) {
                System.out.println("Cikis Yapiliyor...");
            } else if (var == 4) {
                musteriYazdir(musteri, musteri1, musteri2);
            } else if (var == 5) {
                paraTransferi(musteri, musteri1);
            }
        } else {
            System.out.println("Kullanici Girisi Basarisiz...");
        }
    }

    public void Musteri(Musteri musteri2) {

        System.out.println("Musterimiz Olmak Ister Misiniz...\n"
                + "Olmak Istiyorsaniz : Evet Giriniz...\n"
                + "Istemiyorsaniz : Hayir Giriniz...");
        String kontrol1 = scanner.nextLine();
        if (kontrol1.equals("Evet")) {
            if (musteri2.getAd().isEmpty() || !musteri2.getAd().matches("[a-zA-Z]+")) {
                System.out.println("Girdiginiz Isim Isim Kurallarina Uygun Degildir...");
            } else {
                if (musteri2.getSoyAd().isEmpty() || !musteri2.getSoyAd().matches("[a-zA-Z]+")) {
                    System.out.println("Girdiginiz Soyisim Soyisim Kurallarina Uygun Degildir...");
                } else {
                    if (musteri2.getTcKimlik().isEmpty() || musteri2.getTcKimlik().matches("[a-zA-Z]+")) {
                        System.out.println("Girdiginiz Tc Kimlik Tc Kimlik Kurallarina Uygun Degildir...");
                    } else {
                        if (musteri2.getYas() < 18) {
                            System.out.println("18 Yasindan Kucuk Bireyler Banka Sistemimize Kayit Olamaz...");
                        } else {
                            System.out.println("Musteri Olusturuldu...");
                            System.out.println("Artik Musterimizsiniz...\n"
                                    + "Yapmak Istedginiz Islemi Seciniz:\n"
                                    + "1:Para Yatir\n"
                                    + "2:Para Cek\n"
                                    + "3:Cikis Yap\n"
                                    + "4:Musterinin Bilgilerini Yazdir\n"
                                    + "5:Para Transferi Yap");
                            int var = scanner.nextInt();
                            if (var == 1) {
                                System.out.println("Yatirmak Istediginiz Miktari Giriniz...");
                                int var1 = scanner.nextInt();
                                parayatir(var1, musteri);
                            } else if (var == 2) {
                                System.out.println("Cekmek Istediginiz Miktari Giriniz...");
                                int var1 = scanner.nextInt();
                                paracek(var1, musteri);
                            } else if (var == 3) {
                                System.out.println("Cikis Yapiliyor...");
                            } else if (var == 4) {
                                Musteri(musteri);
                            } else if (var == 5) {
                                paraTransferi(musteri, musteri1);
                            }
                        }
                    }
                }
            }

        } else if (kontrol1.equals("Hayir")) {
            System.out.println("Musteri Olmak Istemediniz...\n"
                    + "Cikis Yapiliyor...");
        }
    }
    
    public void paraTransferi(Musteri musteri, Musteri musteri1) {
        System.out.println("Para Transferi Icin Para Cekilecek Olan Hesabi Giriniz...\n"
                + "Sistemde Var Olan Hesaplar :\n"
                + "1: Eren\n"
                + "2: Ahmet");
        int hesap = scanner.nextInt();
        if (hesap == 1) {
            System.out.println("Cekmek Istediginiz Miktari Giriniz...");
            double miktar = scanner.nextDouble();
            if (musteri.getBakiye() < miktar) {
                System.out.println("Yetersiz Bakiye...");
            } else {
                musteri.setBakiye(musteri.getBakiye() - miktar);
                musteri1.setBakiye(musteri1.getBakiye() + miktar);
                System.out.println("Para Cekilen Hesapda Kalan Para Miktari: " + musteri.getBakiye());
                System.out.println("Para Gonderilen Hesapdaki Guncel Miktar" + musteri1.getBakiye());
            }
        } else if (hesap == 2) {
            System.out.println("Cekmek Istediginiz Miktari Giriniz...");
            double miktar = scanner.nextDouble();
            if (musteri1.getBakiye() < miktar) {
                System.out.println("Yetersiz Bakiye...");
            } else {
                musteri1.setBakiye(musteri1.getBakiye() - miktar);
                musteri.setBakiye(musteri.getBakiye() + miktar);
                System.out.println("Para Cekilen Hesapda Kalan Para Miktari: " + musteri1.getBakiye());
                System.out.println("Para Gonderilen Hesapdaki Guncel Miktar" + musteri.getBakiye());
            }
        }

    }

    public void paracek(double miktar, Musteri musteri) {
        System.out.println("Hangi Hesapdan Para Cekmek Istiyorsunuz ?\n"
                + "1: musteri\n"
                + "2: musteri1\n"
                + "3: musteri2");
        int hesap = scanner.nextInt();
        if (hesap == 1) {
            if (musteri.getBakiye() < miktar) {
                System.out.println("Yetersiz Bakiye...");
            } else {
                musteri.setBakiye(musteri.getBakiye() - miktar);
                System.out.println("Guncel Bakiyeniz :" + musteri.getBakiye());
            }
        } else if (hesap == 2) {
            if (musteri1.getBakiye() < miktar) {
                System.out.println("Yetersiz Bakiye...");
            } else {
                musteri1.setBakiye(musteri1.getBakiye() - miktar);
                System.out.println("Guncel Bakiyeniz :" + musteri1.getBakiye());
            }
        } else if (hesap == 3) {
            if (musteri2.getBakiye() < miktar) {
                System.out.println("Yetersiz Bakiye...");
            } else {
                musteri2.setBakiye(musteri2.getBakiye() - miktar);
                System.out.println("Guncel Bakiyeniz :" + musteri2.getBakiye());
            }
        }
    }

    public void parayatir(double miktar, Musteri musteri) {
        System.out.println("Hangi Hesaba Para Yatirmak Istiyorsunuz ?\n"
                + "1: musteri\n"
                + "2: musteri1\n"
                + "3: musteri2");
        int hesap = scanner.nextInt();
        if (hesap == 1) {
            musteri.setBakiye(musteri.getBakiye() + miktar);
            System.out.println("Guncel Bakiyeniz :" + musteri.getBakiye());
        } else if (hesap == 2) {
            musteri1.setBakiye(musteri1.getBakiye() + miktar);
            System.out.println("Guncel Bakiyeniz :" + musteri1.getBakiye());
        } else if (hesap == 3) {
            musteri2.setBakiye(musteri2.getBakiye() + miktar);
            System.out.println("Guncel Bakiyeniz :" + musteri2.getBakiye());
        }

    }

    public void musteriYazdir(Musteri musteri, Musteri musteri1, Musteri musteri2) {
        System.out.println("Hangi Musteriyi Yazdirmak Istiyorsunuz ?\n"
                + "1: musteri\n"
                + "2: musteri1\n"
                + "3: musteri2");
        int var = scanner.nextInt();
        if (var == 1) {
            System.out.println("Musterinin Adi:" + musteri.getAd());
            System.out.println("Musterinin SoyAdi:" + musteri.getSoyAd());
            System.out.println("Musterinin Tcsi:" + musteri.getTcKimlik());
            System.out.println("Musterinin Yasi:" + musteri.getYas());
            System.out.println("Musterinin Numarasi:" + musteri.getMusteriNo());
            System.out.println("Musterinin Sifresi:" + musteri.getMusteriSifre());
            System.out.println("Musterinin Bakiyesi:" + musteri.getBakiye());
        } else if (var == 2) {
            System.out.println("Musterinin Adi:" + musteri1.getAd());
            System.out.println("Musterinin SoyAdi:" + musteri1.getSoyAd());
            System.out.println("Musterinin Tcsi:" + musteri1.getTcKimlik());
            System.out.println("Musterinin Yasi:" + musteri1.getYas());
            System.out.println("Musterinin Numarasi:" + musteri1.getMusteriNo());
            System.out.println("Musterinin Sifresi:" + musteri1.getMusteriSifre());
            System.out.println("Musterinin Bakiyesi:" + musteri1.getBakiye());
        } else if (var == 3) {
            System.out.println("Musterinin Adi:" + musteri2.getAd());
            System.out.println("Musterinin SoyAdi:" + musteri2.getSoyAd());
            System.out.println("Musterinin Tcsi:" + musteri2.getTcKimlik());
            System.out.println("Musterinin Yasi:" + musteri2.getYas());
            System.out.println("Musterinin Numarasi:" + musteri2.getMusteriNo());
            System.out.println("Musterinin Sifresi:" + musteri2.getMusteriSifre());
            System.out.println("Musterinin Bakiyesi:" + musteri2.getBakiye());
        }
    }

}
