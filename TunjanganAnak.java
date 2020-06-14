package com.tunjangan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TunjanganAnak {

    private static Double tungjanganDibawah5Tahun = 5.0; // tunjangan untuk anak 1 - 5 tahun
    private static Double tungjanganDibawah10Tahun = 7.0; // tunjangan untuk anak 6 - 10 tahun
    private static Double tungjanganDibawah15Tahun = 10.0; // tunjangan untuk anak 11 - 15 tahun
    private static Double salary;
    private static List<Double> umurAnakList = new ArrayList<>();
    private static int jumlahAnak;
    private static Double totalTunjangan = 0.0;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah anak = ");
        jumlahAnak = scanner.nextInt();

        for (int a = 0; a < jumlahAnak; a++){
            System.out.print("Masukkan Umur Anak = ");
            umurAnakList.add(scanner.nextDouble());
        }

//        umurAnakList.forEach(System.out::println);

        System.out.print("Masukkan Salary = ");
        salary = scanner.nextDouble();

        int i = 1;
        if(jumlahAnak > 1){
            umurAnakList.sort(Collections.reverseOrder()); // berdasarkan anak dengan umur tertinggi
            for(Double umurAnak: umurAnakList){
                Double tunjanganAnak;
                if (i <= 2){ // max hanya 2 anak utk mendapatkan tunjangan
                    if(umurAnak <= 5) { // umur dibawah atau sama dengan 5 tahun
                        hitungTotalTunjangan(salary, i, tungjanganDibawah5Tahun);
                    } else if(umurAnak <= 10){ //umur dibawah atau sama dengan 10 thaun
                        hitungTotalTunjangan(salary, i, tungjanganDibawah10Tahun);
                    }else if(umurAnak <= 15) { // umur dibawah atau sama dengan 15 tahun
                        hitungTotalTunjangan(salary, i, tungjanganDibawah15Tahun);
                    }else {
                        System.out.println("Anak ke " + i + " tidak terdaftar dalam tunjangan");
                    }
                }
                i++;
            };
        }else if ( jumlahAnak == 1){ // jika anak hanya 1 maka tunjangan yang paling tinggi
            hitungTotalTunjangan(salary, i, tungjanganDibawah15Tahun);
        }else { // tidak punya anak atau semua anak sudah tidak ada dalam daftar tunjangan
            System.out.println("Tunjangan Anak = -");
        }
        System.out.print("Total Tunjangan Anak = " + totalTunjangan);
    }

    public static void hitungTotalTunjangan (Double salary, int i, Double tungjanganBerdasarkanUmur){
        Double tunjanganAnak = (salary * tungjanganBerdasarkanUmur)/100;
        System.out.println("Tunjangan anak ke  "+ i + " = " + tunjanganAnak);
        totalTunjangan += tunjanganAnak;
    }
}

