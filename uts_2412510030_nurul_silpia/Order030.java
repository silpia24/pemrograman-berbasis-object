package uts_2412510030_nurul_silpia;

import java.util.Scanner;

// --- SUPER CLASS: Barang030 ---
class Barang030 {

    protected String namaBarang;
    protected double hargaBarang;

    // Constructor Super Class
    public Barang030(String namaBarang, double hargaBarang) {
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }
}

// --- SUB CLASS: Order030 ---
public class Order030 extends Barang030 {

    // Atribut tambahan
    private final String namaPelanggan;
    private final String metodeBayar;
    private final String namaKasir;

    private final int jumlahBeli;
    private final double totalHarga;

    // Constructor Sub Class
    public Order030(String namaBarang, double hargaBarang, int jumlahBeli, String namaPelanggan, String metodeBayar, String namaKasir) {

        super(namaBarang, hargaBarang);

        this.jumlahBeli = jumlahBeli;
        this.namaPelanggan = namaPelanggan;
        this.metodeBayar = metodeBayar;
        this.namaKasir = namaKasir;

        this.totalHarga = this.hargaBarang * this.jumlahBeli;
    }

    // Method menampilkan struk lengkap
    public void displayStruk() {
        System.out.println("\n=========================================================");
        System.out.println("                 STRUK PEMBELIAN BARANG                  ");
        System.out.println("=========================================================");

        System.out.println("Nama Kasir      : " + this.namaKasir);
        System.out.println("Nama Pelanggan  : " + this.namaPelanggan);
        System.out.println("Metode Bayar    : " + this.metodeBayar);
        System.out.println("---------------------------------------------------------");

        System.out.println("Nama Barang     : " + super.namaBarang);
        System.out.println("Harga Satuan    : Rp " + (int) super.hargaBarang);
        System.out.println("Jumlah Beli     : " + this.jumlahBeli);

        System.out.println("---------------------------------------------------------");
        System.out.println("TOTAL HARGA     : Rp " + (int) this.totalHarga);
        System.out.println("=========================================================");
    }

    // --- MAIN METHOD ---
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("----------- INPUT DATA TRANSAKSI -----------");

            System.out.print("Masukkan Nama Kasir     : ");
            String kasir = scanner.nextLine();

            System.out.print("Masukkan Nama Pelanggan : ");
            String pelanggan = scanner.nextLine();

            System.out.print("Metode Pembayaran       : ");
            String metode = scanner.nextLine();

            System.out.println("--------------------------------------------");

            System.out.print("Masukkan Nama Barang    : ");
            String namaB = scanner.nextLine();

            System.out.print("Masukkan Harga Barang   : ");
            double hargaB = scanner.nextDouble();

            System.out.print("Masukkan Jumlah Beli    : ");
            int jml = scanner.nextInt();

            Order030 transaksi = new Order030(namaB, hargaB, jml, pelanggan, metode, kasir);

            transaksi.displayStruk();
        }
    }
}
