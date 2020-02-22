package bangunan.lingkaran;

public class Lingkaran {
    public static final double PHI = 3.14;
    private static int diameter;

    public Lingkaran(int diameter) {
        this.diameter = diameter;
    }

    public Lingkaran() {
    }

    public double getJarijari() {
        return (double)getDiameter()/2;
    }

    public static int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        Lingkaran.diameter = diameter;
    }

    public double luas() {
        return (PHI * diameter * diameter) / 4;
    }

    public void show() {
        System.out.println("\nLingkaran");
        System.out.println("Luas : " + luas());
        System.out.println("");
    }
}