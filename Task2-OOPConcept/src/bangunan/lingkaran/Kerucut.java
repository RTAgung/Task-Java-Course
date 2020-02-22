package bangunan.lingkaran;

public class Kerucut extends Lingkaran {
    private int tinggi;

    public Kerucut(int diameter, int tinggi) {
        super(diameter);
        this.tinggi = tinggi;
    }

    public Kerucut() {
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    private double selimut() {
        return Math.sqrt(getJarijari() * getJarijari() + tinggi * tinggi);
    }

    private double luasPermukaan() {
        return luas() + (PHI * getJarijari() * selimut());
    }

    private double volume() {
        return (luas() * tinggi)/3;
    }

    @Override
    public double luas() {
        return (PHI * getDiameter() * getDiameter()) / 4;
    }

    @Override
    public void show() {
        System.out.println("Kerucut");
        System.out.println("Volume : " + volume());
        System.out.println("Luas Permukaan : " + luasPermukaan());
        System.out.println("");
    }
}
