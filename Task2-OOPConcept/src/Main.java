import bangunan.lingkaran.*;
import bangunan.persegiPanjang.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char ulang, pilih;

        do {
            System.out.println("Kalkulator Bangunan \n");
            System.out.print("Panjang : ");
            int panjang = sycanner.nextInt(); // diameter
            System.out.print("Lebar   : ");
            int lebar = scanner.nextInt();
            System.out.print("Tinggi  : ");
            int tinggi = scanner.nextInt();
            System.out.print("Menggunakan Overloading (y/n) ? ");
            pilih = scanner.next().charAt(0);

            if (pilih == 'y' || pilih == 'Y'){
                PersegiPanjang persegiPanjang = new PersegiPanjang();
                persegiPanjang.setPanjang(panjang);
                persegiPanjang.setLebar(lebar);

                Balok balok = new Balok();
                balok.setPanjang(panjang);
                balok.setLebar(lebar);
                balok.setTinggi(tinggi);

                LimasPersegiPanjang limasPersegiPanjang = new LimasPersegiPanjang();
                limasPersegiPanjang.setPanjang(panjang);
                limasPersegiPanjang.setLebar(lebar);
                limasPersegiPanjang.setTinggi(tinggi);

                Lingkaran lingkaran = new Lingkaran();
                lingkaran.setDiameter(panjang);

                Bola bola = new Bola();
                bola.setDiameter(panjang);

                Tabung tabung = new Tabung();
                tabung.setDiameter(panjang);
                tabung.setTinggi(tinggi);

                Kerucut kerucut = new Kerucut();
                kerucut.setDiameter(panjang);
                kerucut.setTinggi(tinggi);

                persegiPanjang.show();
                balok.show();
                limasPersegiPanjang.show();
                lingkaran.show();
                bola.show();
                tabung.show();
                kerucut.show();
            }else {
                PersegiPanjang persegiPanjang = new PersegiPanjang(panjang, lebar);
                PersegiPanjang balok = new Balok(panjang, lebar, tinggi);
                PersegiPanjang limasPersegiPanjang = new LimasPersegiPanjang(panjang, lebar, tinggi);
                Lingkaran lingkaran = new Lingkaran(panjang);
                Lingkaran bola = new Bola(panjang);
                Lingkaran tabung = new Tabung(panjang, tinggi);
                Lingkaran kerucut = new Kerucut(panjang,tinggi);

                persegiPanjang.show();
                balok.show();
                limasPersegiPanjang.show();
                lingkaran.show();
                bola.show();
                tabung.show();
                kerucut.show();
            }
            System.out.print("Kembali (y/n) ? ");
            ulang = scanner.next().charAt(0);
            System.out.println("\n\n");
        }while(ulang == 'Y' || ulang == 'y');


    }
}
