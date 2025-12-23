package uts_2412510030_nurul_silpia;

public class Biodata030 {
    private String nim;
    private String nama;
    private String alamat;
    private String email;
    private String prodi;
    private String fakultas;

    public Biodata030(String nim, String nama, String alamat, String email, String prodi, String fakultas) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.prodi = prodi;
        this.fakultas = fakultas;
    }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getProdi() { return prodi; }
    public void setProdi(String prodi) { this.prodi = prodi; }

    public String getFakultas() { return fakultas; }
    public void setFakultas(String fakultas) { this.fakultas = fakultas; }

    public static void main(String[] args) {
        Biodata030 mahasiswa = new Biodata030(
            "2412510030",
            "Nurul Silpia",
            "Jakarta Selatan",
            "2412510030@student.budiluhur.ac.id",
            "Teknik Informatika",
            "Fakultas Sistem Informasi"
        );

        System.out.println("-------------------------------------------------");
        System.out.println("                 DATA MAHASISWA                  ");
        System.out.println("-------------------------------------------------");
        System.out.println("NIM           : " + mahasiswa.getNim());
        System.out.println("Nama          : " + mahasiswa.getNama());
        System.out.println("Alamat        : " + mahasiswa.getAlamat());
        System.out.println("Email         : " + mahasiswa.getEmail());
        System.out.println("Program Studi : " + mahasiswa.getProdi());
        System.out.println("Fakultas      : " + mahasiswa.getFakultas());
        System.out.println("-------------------------------------------------");
    }
}
