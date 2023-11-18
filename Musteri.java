
import java.util.Scanner;

public class Musteri {

    private String tcKimlik;
    private String ad;
    private String soyAd;
    private int yas;
    private String musteriNo;
    private String musteriSifre;
    private double bakiye;

    Scanner scanner = new Scanner(System.in);

    public Musteri(String tcKimlik, String ad, String soyAd, int yas, String musteriNo, String musteriSifre, double bakiye) {
        this.tcKimlik = tcKimlik;
        this.ad = ad;
        this.soyAd = soyAd;
        this.yas = yas;
        this.musteriNo = musteriNo;
        this.musteriSifre = musteriSifre;
        this.bakiye = bakiye;
    }

    public Musteri() {

    }

    public String getTcKimlik() {
        return tcKimlik;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyAd() {
        return soyAd;
    }

    public int getYas() {
        return yas;
    }

    public String getMusteriNo() {
        return musteriNo;
    }

    public String getMusteriSifre() {
        return musteriSifre;
    }

    public double getBakiye() {
        return bakiye;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

}
