package bangunan.persegiPanjang;

public class LimasPersegiPanjang extends PersegiPanjang {
    private int tinggi;

    public LimasPersegiPanjang(int panjang, int lebar, int tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    public LimasPersegiPanjang() {
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    private double tinggiPanjang(){
        return Math.sqrt(Math.pow(0.5*getLebar(),2) + Math.pow(tinggi,2));
    }

    private double tinggiLebar(){
        return Math.sqrt(Math.pow(0.5*getPanjang(),2) + Math.pow(tinggi,2));
    }

    private double luasPermukaan(){
        return luas() +  getLebar()*tinggiLebar() + getPanjang()*tinggiPanjang();
    }

    private double volume(){
        return (luas()*tinggi)/3;
    }

    @Override
    public int luas() {
        return super.luas();
    }

    @Override
    public void show() {
        System.out.println("Limas Persegi Panjang");
        System.out.println("Luas Permukaan\t: " + luasPermukaan());
        System.out.println("Volume \t\t\t: " + volume());
        System.out.println("");
    }
}
