package bangunan.lingkaran;

public class Bola extends Lingkaran{
    public Bola(int diameter) {
        super(diameter);
    }

    public Bola() {
    }

    private double luasPermukaan(){
        return luas()*4;
    }

    private double volume(){
        return (luas()*getJarijari()*4)/3;
    }

    @Override
    public double luas() {
        return (PHI * getDiameter() * getDiameter()) / 4;
    }

    @Override
    public void show() {
        System.out.println("Bola");
        System.out.println("Volume : " + volume());
        System.out.println("Luas Permukaan : " + luasPermukaan());
        System.out.println("");
    }
}
