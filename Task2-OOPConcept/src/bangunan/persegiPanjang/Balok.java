package bangunan.persegiPanjang;

public class Balok extends PersegiPanjang{
    private int tinggi;

    public Balok(int panjang, int lebar, int tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    public Balok() {
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    private int luasPermukaan(){
        return 2*luas() + 2*getPanjang()*tinggi + 2*getLebar()*tinggi;
    }

    private int volume(){
        return luas()*tinggi;
    }

    @Override
    public int luas(){
        return super.luas();
    }

    @Override
    public void show() {
        System.out.println("Balok");
        System.out.println("Luas Permukaan\t: " + luasPermukaan());
        System.out.println("Volume \t\t\t: " + volume());
        System.out.println("");
    }
}
