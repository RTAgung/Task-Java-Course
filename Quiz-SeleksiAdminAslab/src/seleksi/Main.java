package seleksi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char back = 'n';
        do {
            System.out.println("MENU FORM PENDAFTARAN");
            System.out.println("1. Asisten Laboratorium");
            System.out.println("2. Admin Laboratorium");
            System.out.print("Pilih Jenis IForm : ");
            int pilih = 0;
            try {
                pilih = scanner.nextInt();
            } catch (Exception e){
                System.out.println("Input Harus Bilangan Bulat");
            }

            int banyak;
            String nama, nim;
            double tesSatu, tesDua, tesTiga, tesEmpat;

            switch (pilih){
                case 1:
                    System.out.println("\nFORM PENDAFTARAN ASISTEN LABORATORIUM");
                    System.out.print("Berapa banyak data yang akan di inputkan? ");
                    banyak = scanner.nextInt();
                    Form[] formAslab = new Form[banyak];
                    for (int i = 0; i < banyak; i++){
                        System.out.print("Input NIM : "); nim = scanner.next();
                        scanner = new Scanner(System.in);
                        System.out.print("Input Nama : "); nama = scanner.nextLine();
                        try {
                            System.out.print("Input Nilai Tes Tulis : "); tesSatu = scanner.nextDouble();
                            if (tesSatu < 0)
                                throw new Exception();
                            System.out.print("Input Nilai Tes Coding : "); tesDua = scanner.nextDouble();
                            if (tesDua < 0)
                                throw new Exception();
                            System.out.print("Input Nilai Tes Wawancara : "); tesTiga = scanner.nextDouble();
                            if (tesTiga < 0)
                                throw new Exception();
                            System.out.print("Input Nilai Tes Microteaching : "); tesEmpat = scanner.nextDouble();
                            if (tesEmpat < 0)
                                throw new Exception();
                            formAslab[i] = new Form(nama, nim, tesSatu, tesDua, tesTiga, tesEmpat, "Aslab");
                            formAslab[i].hitungHasil();
                            formAslab[i].cetakHasil();
                        } catch (Exception e){
                            System.out.println("Input Harus Bilangan Bulat Positif");
                        }
                        System.out.println("");
                        scanner = new Scanner(System.in);
                    }
                    break;
                case 2:
                    System.out.println("\nFORM PENDAFTARAN ADMIN LABORATORIUM");
                    System.out.print("Berapa banyak data yang akan di inputkan? ");
                    banyak = scanner.nextInt();
                    Form[] formAdmin = new Form[banyak];
                    for (int i = 0; i < banyak; i++){
                        System.out.print("Input NIM : "); nim = scanner.next();
                        scanner = new Scanner(System.in);
                        System.out.print("Input Nama : "); nama = scanner.nextLine();
                        try {
                            System.out.print("Input Nilai Tes Tulis : "); tesSatu = scanner.nextDouble();
                            if (tesSatu < 0)
                                throw new Exception();
                            System.out.print("Input Nilai Tes Coding : "); tesDua = scanner.nextDouble();
                            if (tesDua < 0)
                                throw new Exception();
                            System.out.print("Input Nilai Tes Wawancara : "); tesTiga = scanner.nextDouble();
                            if (tesTiga < 0)
                                throw new Exception();
                            System.out.print("Input Nilai Tes Jaringan : "); tesEmpat = scanner.nextDouble();
                            if (tesEmpat < 0)
                                throw new Exception();
                            formAdmin[i] = new Form(nama, nim, tesSatu, tesDua, tesTiga, tesEmpat, "Admin");
                            formAdmin[i].hitungHasil();
                            formAdmin[i].cetakHasil();
                        } catch (Exception e){
                            System.out.println("Input Harus Bilangan Bulat Positif");
                        }
                        System.out.println("");
                        scanner = new Scanner(System.in);
                    }
                    break;
                default:
                    System.out.println("\nMenu Tidak Tesedia");
            }

            System.out.print("\nKembali ke menu utama? (y/n) : ");
            scanner = new Scanner(System.in);
            back = scanner.next().charAt(0);
        } while (back == 'y' || back == 'Y');
    }
}