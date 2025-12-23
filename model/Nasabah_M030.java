package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Nasabah_M030 {

    private String kode030, nama030, alamat030, pekerjaan030;
    private Double gajiPokok030;

    public void setKode030(String kode030) {
        this.kode030 = kode030;
    }

    public void setNama030(String nama030) {
        this.nama030 = nama030;
    }

    public void setAlamat030(String alamat030) {
        this.alamat030 = alamat030;
    }

    public void setPekerjaan030(String pekerjaan030) {
        this.pekerjaan030 = pekerjaan030;
    }

    public void setGajiPokok030(Double gajiPokok030) {
        this.gajiPokok030 = gajiPokok030;
    }

    public String getKode030() {
        return kode030;
    }

    public String getNama030() {
        return nama030;
    }

    public String getAlamat030() {
        return alamat030;
    }

    public String getPekerjaan030() {
        return pekerjaan030;
    }

    public Double getGajiPokok030() {
        return gajiPokok030;
    }

    public void simpan(Connection conn) throws SQLException {
        String sql = "INSERT INTO Nasabah030 (Kode030, Nama030, Alamat030, Pekerjaan030, GajiPokok030) VALUES (?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, kode030);
        pst.setString(2, nama030);
        pst.setString(3, alamat030);
        pst.setString(4, pekerjaan030);
        pst.setDouble(5, gajiPokok030);
        pst.executeUpdate();
    }

    public void ubah(Connection conn) throws SQLException {
        String sql = "UPDATE Nasabah030 SET Nama030=?, Alamat030=?, Pekerjaan030=?, GajiPokok030=? WHERE Kode030=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nama030);
        pst.setString(2, alamat030);
        pst.setString(3, pekerjaan030);
        pst.setDouble(4, gajiPokok030);
        pst.setString(5, kode030);
        pst.executeUpdate();
    }

    public void hapus(Connection conn) throws SQLException {
        String sql = "DELETE FROM Nasabah030 WHERE Kode030=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, kode030);
        pst.executeUpdate();
    }

    public ResultSet cari(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Nasabah030 WHERE Kode030=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, kode030);
        return pst.executeQuery();
    }

    public ResultSet getAllData(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Nasabah030";
        PreparedStatement pst = conn.prepareStatement(sql);
        return pst.executeQuery();
    }
}
