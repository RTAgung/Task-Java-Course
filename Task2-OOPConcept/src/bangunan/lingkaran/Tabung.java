package bangunan.lingkaran;

public class Tabung extends Lingkaran{
    private int tinggi;

    public Tabung(int diameter, int tinggi) {
        super(diameter);
        this.tinggi = tinggi;
    }

    public Tabung() {
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    private double luasSelimut(){
        return 2*PHI*getJarijari()*tinggi;
    }

    private double luasPermukaan(){
        return 2*luas() + luasSelimut();
    }

    private double volume(){
        return luas()*tinggi;
    }

    @Override
    public double luas() {
        return (PHI * getDiameter() * getDiameter()) / 4;
    }

    @Override
    public void show() {
        System.out.println("Tabung");
        System.out.println("Volume : " + volume());
        System.out.println("Luas Permukaan : " + luasPermukaan());
        System.out.println("");
    }
}
