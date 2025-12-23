# ProjectBank030 - Sistem Manajemen Data Nasabah

> **Aplikasi Desktop untuk Pengelolaan Data Nasabah Bank**  
> Dibuat dengan Java Swing & MySQL | Menggunakan Arsitektur MVC

---

## Deskripsi Project

ProjectBank030 adalah aplikasi desktop sederhana untuk mengelola data nasabah bank. Aplikasi ini bisa digunakan untuk menambah, mengubah, menghapus, dan mencari data nasabah beserta informasi pekerjaan dan gaji pokok mereka.

**Fitur Utama:**
- Tambah data nasabah baru
- Edit data nasabah yang sudah ada
- Hapus data nasabah
- Cari data berdasarkan kode nasabah
- Tampilkan semua data dalam bentuk tabel
- Data tersimpan di database MySQL

---

## Apa itu MVC?

### Analogi Sederhana: Restoran 🍽️

Bayangin kamu lagi di restoran. Ada 3 peran utama:

#### 1. **MODEL (Koki di Dapur)** 
- **Tugas:** Nyiapin data, masak makanan, kelola bahan-bahan
- **Dalam project ini:** `Nasabah_M030.java`
- **Fungsinya:** 
  - Nyimpen data nasabah (kode, nama, alamat, dll)
  - Ngatur operasi database (INSERT, UPDATE, DELETE, SELECT)
  - Nggak peduli sama tampilan atau siapa yang minta data

**Analogi:**  
Koki cuma fokus masak. Dia nggak peduli siapa yang pesen atau gimana cara pelayannya ngomong ke customer. Yang penting dia tau resepnya dan bahan-bahannya lengkap!

---

#### 2. **VIEW (Pelayan & Menu)** 
- **Tugas:** Nampilin menu, terima pesanan, kasih tau customer ada promo apa
- **Dalam project ini:** `Nasabah_V030.java`
- **Fungsinya:**
  - Nampung tampilan form (text field, button, tabel)
  - Nge-layout GUI biar good looking
  - Nampilin data ke user dalam bentuk yang mudah dibaca

**Analogi:**  
Pelayan itu yang ketemu langsung sama customer. Dia kasih menu, catat pesanan, dan antar makanan. Tapi pelayan nggak masak sendiri dan nggak asal eksekusi—semua harus lewat manager dulu!

---

#### 3. **CONTROLLER (Manager Restoran)** 
- **Tugas:** Koordinasi antara pelayan dan koki, atur alur kerja
- **Dalam project ini:** `Nasabah_C030.java`
- **Fungsinya:**
  - Dengerin event dari user (klik tombol, tekan Enter, dsb)
  - Validasi input dari VIEW
  - Suruh MODEL ngolah data
  - Update VIEW setelah data berubah

**Analogi:**  
Manager itu yang atur semuanya. Pas pelayan terima pesanan, manager yang bilang ke koki "bikinin nasi goreng 2 porsi ya!". Pas udah jadi, manager yang bilang ke pelayan "antar ke meja 5!". Semua komunikasi lewat manager!

---

### Alur Kerja MVC dalam Project Ini

```
USER (Kamu) 
   ↓
   klik tombol "Simpan"
   ↓
VIEW (Nasabah_V030)
   ↓
   kirim event ke...
   ↓
CONTROLLER (Nasabah_C030)
   ↓
   ambil data dari form VIEW
   ↓
   validasi data
   ↓
   kirim ke MODEL untuk disimpan
   ↓
MODEL (Nasabah_M030)
   ↓
   jalankan query INSERT ke Database
   ↓
   berhasil? kirim balik ke CONTROLLER
   ↓
CONTROLLER
   ↓
   perintahkan VIEW refresh tampilan tabel
   ↓
VIEW
   ↓
   tampilkan data terbaru ke USER
```

**Kenapa pake MVC?**
- **Rapih:** Kode nggak campur aduk. Kalau mau ganti tampilan, tinggal edit VIEW aja
- **Gampang maintenance:** Bug di database? Tinggal cek MODEL doang
- **Reusable:** Model bisa dipake buat project lain yang butuh CRUD nasabah
- **Teamwork friendly:** Front-end developer fokus di VIEW, back-end di MODEL

---

## 🗂️ Struktur Project

```
ProjectBank030/
│
├── Main.java
│
├── controller/
│   └── Nasabah_C030.java
│
├── model/
│   └── Nasabah_M030.java
│
├── view/
│   └── Nasabah_V030.java
│
└── koneksi/
    └── KoneksiDB.java
```

---

## Teknologi yang Digunakan

| Teknologi | Kegunaan |
|-----------|----------|
| **Java 20** | Bahasa pemrograman utama |
| **Java Swing** | Framework untuk bikin GUI desktop |
| **MySQL** | Database untuk nyimpen data nasabah |
| **JDBC** | Driver buat konek Java ke MySQL |

---

## Cara Menjalankan Project

### Prerequisites

1. **Java Development Kit (JDK)**
   - Minimal JDK 8 (project ini menggunakan JDK 20)
   - Download: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) atau [OpenJDK](https://adoptium.net/)
   - Cek instalasi: buka terminal/cmd, ketik `java --version`

2. **MySQL Server**
   - Download: [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)
   - Jangan lupa install MySQL Workbench / phpMyAdmin juga biar gampang manage database

3. **MySQL Connector/J (JDBC Driver)**
   - Download: [MySQL Connector](https://dev.mysql.com/downloads/connector/j/)
   - Extract dan simpan file `.jar` nya
   - Nanti file ini harus di-include ke classpath

4. **IDE (Opsional tapi Disarankan)**
   - IntelliJ IDEA atau VS Code
   - Biar gampang compile & run

---

### Setup MySQL Connector (PENTING!)

#### Kalau Pakai Visual Studio Code:

1. **Download MySQL Connector/J:**
   - Link download: https://dev.mysql.com/downloads/connector/j/
   - Pilih "Platform Independent" (file ZIP)
   - Extract file ZIP-nya
   - Cari file `.jar` (contoh: `mysql-connector-j-8.2.0.jar`)

2. **Install Extension Java di VS Code:**
   - Install extension "Extension Pack for Java" dari Microsoft
   - Setelah install, bakal muncul panel "JAVA PROJECTS" di sidebar kiri

3. **Tambahkan MySQL Connector ke Project:**
   - Buka project di VS Code
   - Di sidebar kiri, cari panel **"JAVA PROJECTS"**
   - Expand folder project kamu
   - Cari bagian **"Referenced Libraries"**
   - **Drag and drop** file `mysql-connector-j-x.x.x.jar` ke "Referenced Libraries"
   - Atau klik icon **"+"** di samping "Referenced Libraries", terus pilih file JAR-nya

4. **Verifikasi:**
   - Pastikan file JAR muncul di bawah "Referenced Libraries"
   - Coba run program, kalau nggak ada error "ClassNotFoundException", berarti berhasil!

#### Kalau Pakai IDE Lain:

- **IntelliJ IDEA:** File → Project Structure → Libraries → + → Java → pilih JAR file
- **Eclipse:** Klik kanan project → Build Path → Configure Build Path → Libraries → Add External JARs

> **💡 Tips:** Simpen file JAR di folder khusus di project (misal: `lib/`) biar nggak ilang dan gampang di-track!

---

### Step-by-Step Setup

#### Step 1: Setup Database

1. Buka MySQL Workbench atau MySQL CLI
2. Buat database baru:
   ```sql
   CREATE DATABASE UAS_2412510030;
   ```

3. Gunakan database tersebut:
   ```sql
   USE UAS_2412510030;
   ```

4. Buat tabel `Nasabah030`:
   ```sql
   CREATE TABLE Nasabah030 (
       Kode030 VARCHAR(10) PRIMARY KEY,
       Nama030 VARCHAR(100) NOT NULL,
       Alamat030 TEXT,
       Pekerjaan030 VARCHAR(50),
       GajiPokok030 DOUBLE
   );
   ```

#### Step 2: Konfigurasi Koneksi Database

1. Buka file `koneksi/KoneksiDB.java`
2. Edit bagian koneksi sesuai setting MySQL kamu:
   ```java
   return DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/UAS_2412510030?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
       "root",           // ← ganti sesuai username MySQL kamu
       ""    // ← ganti sesuai password MySQL kamu
   );
   ```

#### Step 3: Compile & Run

**A. Kalau Pake IDE (Gampang banget!):**
1. Import project ke IDE
2. Add MySQL Connector JAR ke library project
3. Run `Main.java`
4. Done! ✅

**B. Kalau Pake Terminal/CMD (Manual Mode):**

1. Pindah ke folder project:
   ```bash
   cd /ProjectBank030
   ```

2. Compile semua file Java:
   ```bash
   javac -cp ".:/path/to/mysql-connector-java.jar" Main.java controller/*.java model/*.java view/*.java koneksi/*.java
   ```
   
   **Windows:**
   ```bash
   javac -cp ".;C:\path\to\mysql-connector-java.jar" Main.java controller/*.java model/*.java view/*.java koneksi/*.java
   ```

3. Jalankan program:
   ```bash
   java -cp ".:/path/to/mysql-connector-java.jar" Main
   ```
   
   **Windows:**
   ```bash
   java -cp ".;C:\path\to\mysql-connector-java.jar" Main
   ```

---

## Cara Pakai Aplikasi

### 1️⃣ Tambah Data Nasabah Baru
- Isi semua field (Kode, Nama, Alamat, Pekerjaan, Gaji Pokok)
- Klik tombol **"Simpan"**
- Kalau kode sudah ada, bakal muncul konfirmasi mau overwrite atau nggak

### 2️⃣ Cari Data Nasabah
- Ketik Kode Nasabah di field "Kode Nasabah"
- Tekan **Enter**
- Data akan otomatis muncul di form (kalau ketemu)

### 3️⃣ Edit Data Nasabah
- Pilih data yang mau diedit (pake cara di atas, atau klik row di tabel)
- Ubah field yang mau diganti
- Klik tombol **"Ubah"**

### 4️⃣ Hapus Data Nasabah
- Pilih data yang mau dihapus
- Klik tombol **"Hapus"**
- Konfirmasi penghapusan

### 5️⃣ Batal/Reset Form
- Klik tombol **"Batal"** untuk kosongkan semua field

---

## 🐛 Troubleshooting (Kalau Ada Masalah)

### ❌ Error: "Driver MySQL tidak ditemukan!"
**Solusi:**  
- Pastikan MySQL Connector JAR sudah di-add ke classpath
- Cek file JAR-nya ada atau nggak
- Kalau pake IDE, add library lewat Project Settings

### ❌ Error: "Access denied for user 'root'@'localhost'"
**Solusi:**  
- Username atau password MySQL salah
- Cek file `KoneksiDB.java`, pastikan username & password sesuai

### ❌ Error: "Unknown database 'UAS_2412510030'"
**Solusi:**  
- Database belum dibuat
- Jalankan query `CREATE DATABASE` di Step 1 dulu

### ❌ Error: "Table 'Nasabah030' doesn't exist"
**Solusi:**  
- Tabel belum dibuat
- Jalankan query `CREATE TABLE` di Step 1

### ❌ Aplikasi jalan tapi data nggak muncul
**Solusi:**  
- Cek koneksi internet (kalau MySQL di server remote)
- Cek service MySQL udah jalan atau belum
- Lihat console, ada error message nggak

---

## Penjelasan File-File

### 📄 Main.java
File starter yang bikin instance dari View, Model, dan Controller, terus nampilin window-nya.

### 📄 Nasabah_M030.java (Model)
Class ini punya:
- **Atribut:** kode, nama, alamat, pekerjaan, gajiPokok
- **Method CRUD:**
  - `simpan()` → INSERT data baru
  - `ubah()` → UPDATE data
  - `hapus()` → DELETE data
  - `cari()` → SELECT berdasarkan kode
  - `getAllData()` → SELECT semua data

### 📄 Nasabah_V030.java (View)
Class yang extends `JFrame`, berisi:
- Text fields untuk input
- Text area untuk alamat
- Buttons untuk aksi
- Table untuk tampilkan data
- Method `kosongkanForm()` untuk reset form

### 📄 Nasabah_C030.java (Controller)
Class yang implements `ActionListener` dan `KeyListener`:
- **actionPerformed():** Handle klik button (Simpan, Ubah, Hapus, Batal)
- **keyPressed():** Handle pencarian pas tekan Enter di field Kode
- **tampilkanData():** Refresh tabel setelah ada perubahan data
- **isiModel():** Ambil data dari form dan masukin ke object Model

### 📄 KoneksiDB.java
Utility class untuk manage koneksi ke database:
- Load driver MySQL
- Buat connection ke database
- Handle exception

---

## 🤝 Kontribusi & Saran

Project ini dibuat untuk keperluan UAS Pemrograman Berbasis Objek. Kalau ada saran atau bug, feel free to improve!