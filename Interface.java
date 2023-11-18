
public interface Interface {

    void Musteri(Musteri musteri2);

    void musteriGiris(String musteriNo, String musteriSifre);

    void paracek(double miktar, Musteri musteri);

    void parayatir(double miktar, Musteri musteri);

    void paraTransferi(Musteri musteri, Musteri musteri1);

    void musteriYazdir(Musteri musteri, Musteri musteri1, Musteri musteri2);
}
