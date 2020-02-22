package bangunan.persegiPanjang;

public class PersegiPanjang {
    private static int panjang;
    private static int lebar;

    public PersegiPanjang(int panjang, int lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public PersegiPanjang() {
    }

    public int getPanjang() {
        return panjang;
    }

    public void setPanjang(int panjang) {
        this.panjang = panjang;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public int luas() {
        return panjang * lebar;
    }

    public void show() {
        System.out.println("\nPersegi Panjang");
        System.out.println("Luas : " + luas());
        System.out.println("");
    }
}