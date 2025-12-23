# Dokumentasi UTS Praktikum Java (Studi Kasus OOP)

**Nama:** Nurul Silpia  
**NIM:** 2412510030  
**Matkul:** Pemrograman Berorientasi Objek (PBO)

---

## Sekilas Tentang Project Ini
Repositori ini berisi hasil pengerjaan 3 studi kasus untuk UTS mata kuliah PBO. Intinya, project ini berisi latihan dasar Java mulai dari cara menampilkan data diri, membuat sistem kasir sederhana, sampai menerapkan konsep **Pewarisan (Inheritance)**.

**Catatan Kecil:** Sesuai instruksi soal, semua nama file dan *class* di sini saya beri akhiran **030** (mengambil 3 digit terakhir NIM saya).

---

## Cara Menjalankan Program (Compile & Run)
Sebelum mulai, pastikan di laptop kamu sudah terinstall Java (JDK) ya. Kalau sudah aman, ikuti langkah berikut di terminal/CMD:

### 1. Program Biodata (Soal No. 1)
Ini program simpel untuk menampilkan data mahasiswa.
* **Cara Compile (Menerjemahkan kode):**
    ```bash
    javac Biodata030.java
    ```
* **Cara Run (Menjalankan program):**
    ```bash
    java Biodata030
    ```

### 2. Program Kasir Sederhana (Soal No. 2)
Program untuk input barang belanjaan.
*> Note: Di soal aslinya, logika "Harga" dan "Jumlah" sepertinya tertukar. Jadi di kode ini sudah saya perbaiki biar masuk akal (Harga itu nominal uang, Jumlah itu banyaknya barang).*

* **Compile:**
    ```bash
    javac Pesan030.java
    ```
* **Run:**
    ```bash
    java Pesan030
    ```

### 3. Program Kasir Lanjutan/Inheritance (Soal No. 3)
Versi lebih canggih dari soal no 2. Di sini ada tambahan data kasir, pelanggan, dan metode bayar.

* **Compile:**
    ```bash
    javac Order030.java
    ```
* **Run:**
    ```bash
    java Order030
    ```

---

## Penjelasan Logika

Penjelasan simpel tentang apa yang terjadi di balik layar:

### 1. `Biodata030.java` (Soal Enkapsulasi)
* **Kenapa ada `Private`?**
    Ibarat buku harian yang digembok. Data seperti NIM dan Nama saya set `private final` agar tidak bisa diubah-ubah sembarangan oleh kode lain dari luar. Ini namanya **Enkapsulasi**.
* **Getter & Setter:**
    Karena digembok, kalau mau lihat isinya atau ganti isinya, harus lewat pintu resmi. `Get` untuk mengintip data, `Set` untuk mengganti data.
* **Constructor:**
    Ini seperti formulir pendaftaran. Saat data mahasiswa dibuat, formulir ini memastikan semua data (Nama, Alamat, dll) langsung terisi lengkap di awal.

### 2. `Pesan030.java` (Input/Output Dasar)
* **Scanner:**
    Fitur ini fungsinya seperti "telinga". Dia mendengarkan apa yang kita ketik di keyboard (misal: nama barang), lalu menangkapnya untuk diproses program.
* **Casting (Merubah Tipe Data):**
    Di bagian total harga, saya mengubah angka desimal (koma-komaan) menjadi bilangan bulat. Biar struk belanjanya rapi dan nggak ada buntut `.0` di belakang angka duitnya.

### 3. `Order030.java` (Pewarisan/Inheritance)
* **Kenapa Satu File?**
    Sebenarnya ada dua bagian: `Barang` (Induk) dan `Order` (Anak). Saya gabung dalam satu file agar lebih mudah untuk didownload dan running-nya. Nggak perlu repot compile banyak file.
* **Konsep Warisan (`extends`):**
    Bayangkan `Barang` adalah Orang Tua, dan `Order` adalah Anak.
    Si Anak (`Order`) otomatis punya sifat-sifat Orang Tuanya (`Barang`). Jadi, kalau di `Barang` sudah ada "Nama Barang" dan "Harga", si `Order` nggak perlu bikin variabel itu lagi. Tinggal pakai saja ("Mewarisi").
* **Keyword `super`:**
    Ini cara si Anak melapor ke Orang Tua. Saat kita input data barang di `Order`, kode `super` akan mengirim data itu untuk disimpan oleh `Barang`.

---
*Terima kasih :)*