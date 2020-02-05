// Name : Rama Tri Agung
// NIM : 123180053

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value[] = new int[5];
        int max, min;
        double avg;

        System.out.print("Nama : ");
        String name = scanner.nextLine();

        for (int i = 0; i < value.length; i++) {
            System.out.print("Nilai ke-" + (i+1) + " : ");
            value[i] = scanner.nextInt();
        }

        max = value[0];
        min = value[0];
        avg = 0;
        for (int i = 0; i < value.length; i++) {
            if (max < value[i])
                max = value[i];
            if (min > value[i])
                min = value[i];
            avg += value[i];
        }
        avg /= value.length;

        System.out.print("\nNama : " + name + "\n" +
                "Niali Tertinggi : " + max + "\n" +
                "Nilai Terendah : " + min + "\n" +
                "Nilai Rata-rata : " + avg);
    }
}
