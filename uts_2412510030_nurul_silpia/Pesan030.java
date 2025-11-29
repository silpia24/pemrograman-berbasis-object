package uts_2412510030_nurul_silpia;

import java.util.Scanner;

public class Pesan030 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String namaBarang;
            double hargaBarang;
            int jumlahBeli;
            double totalHarga;
            
            System.out.println("-----------------SISTEM PENJUALAN BARANG-----------------");
            System.out.print("Masukkan Nama Barang  : ");
            namaBarang = scanner.nextLine();
            
            System.out.print("Masukkan Harga Barang : ");
            hargaBarang = scanner.nextDouble();
            
            System.out.print("Masukkan Jumlah Beli  : ");
            jumlahBeli = scanner.nextInt();
            
            totalHarga = hargaBarang * jumlahBeli;
            
            System.out.println("\n---------------------DATA PEMESANAN----------------------");
            System.out.println("Nama Barang  : " + namaBarang);
            System.out.println("Harga Barang : " + hargaBarang);
            System.out.println("Jumlah Beli  : " + jumlahBeli);
            System.out.println("Total Harga  : " + totalHarga);
            System.out.println("---------------------------------------------------------");
            
            System.out.println("TOTAL PEMBAYARAN AKHIR : " + (int) totalHarga);
            System.out.println("---------------------------------------------------------");
        }
    }
}
