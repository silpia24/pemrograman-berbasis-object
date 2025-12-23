package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import koneksi.KoneksiDB;
import model.Nasabah_M030;
import view.Nasabah_V030;

public class Nasabah_C030 implements ActionListener, KeyListener {

    Nasabah_V030 view;
    Nasabah_M030 model;

    public Nasabah_C030(Nasabah_V030 view, Nasabah_M030 model) {
        this.view = view;
        this.model = model;

        view.btnSimpan.addActionListener(this);
        view.btnUbah.addActionListener(this);
        view.btnHapus.addActionListener(this);
        view.btnBatal.addActionListener(this);
        view.tfKode030.addKeyListener(this);

        view.tabelData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int baris = view.tabelData.getSelectedRow();
                if (baris != -1) {
                    view.tfKode030.setText(view.modelTabel.getValueAt(baris, 0).toString());
                    view.tfNama030.setText(view.modelTabel.getValueAt(baris, 1).toString());
                    view.taAlamat030.setText(view.modelTabel.getValueAt(baris, 2).toString());
                    view.tfPekerjaan030.setText(view.modelTabel.getValueAt(baris, 3).toString());
                    view.tfGajiPokok030.setText(view.modelTabel.getValueAt(baris, 4).toString());
                }
            }
        });

        tampilkanData();
    }

    private void isiModel() {
        model.setKode030(view.tfKode030.getText());
        model.setNama030(view.tfNama030.getText());
        model.setAlamat030(view.taAlamat030.getText());
        model.setPekerjaan030(view.tfPekerjaan030.getText());

        try {
            Double gaji = Double.parseDouble(view.tfGajiPokok030.getText());
            model.setGajiPokok030(gaji);
        } catch (NumberFormatException e) {
            model.setGajiPokok030(0.0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Connection conn = KoneksiDB.getConnection();

            if (e.getSource() == view.btnSimpan) {
                isiModel();

                ResultSet rs = model.cari(conn);

                if (rs.next()) {
                    rs.close();

                    int konfirmasi = JOptionPane.showConfirmDialog(view,
                            "Data dengan Kode " + view.tfKode030.getText() + " sudah ada.\nApakah Anda ingin menimpanya (Overwrite)?",
                            "Konfirmasi Overwrite",
                            JOptionPane.YES_NO_OPTION);

                    if (konfirmasi == JOptionPane.YES_OPTION) {
                        model.ubah(conn);
                        JOptionPane.showMessageDialog(view, "Data berhasil diperbarui (Overwritten)");
                    } else {
                        conn.close();
                        return;
                    }
                } else {
                    model.simpan(conn);
                    JOptionPane.showMessageDialog(view, "Data berhasil disimpan");
                }

                tampilkanData();
                view.kosongkanForm();

            } else if (e.getSource() == view.btnUbah) {
                isiModel();
                model.ubah(conn);
                JOptionPane.showMessageDialog(view, "Data Nasabah berhasil diubah");
                tampilkanData();
                view.kosongkanForm();
            } else if (e.getSource() == view.btnHapus) {
                isiModel();
                model.hapus(conn);
                JOptionPane.showMessageDialog(view, "Data Nasabah berhasil dihapus");
                tampilkanData();
                view.kosongkanForm();
            } else if (e.getSource() == view.btnBatal) {
                view.kosongkanForm();
            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage());
        }
    }

    private void tampilkanData() {
        try {
            int baris = view.modelTabel.getRowCount();
            for (int i = 0; i < baris; i++) {
                view.modelTabel.removeRow(0);
            }

            Connection conn = KoneksiDB.getConnection();
            ResultSet rs = model.getAllData(conn);

            while (rs.next()) {
                Object[] data = {
                    rs.getString("Kode030"),
                    rs.getString("Nama030"),
                    rs.getString("Alamat030"),
                    rs.getString("Pekerjaan030"),
                    rs.getInt("GajiPokok030")
                };
                view.modelTabel.addRow(data);
            }

            rs.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Gagal tampil data: " + e.getMessage());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                Connection conn = KoneksiDB.getConnection();
                model.setKode030(view.tfKode030.getText());
                ResultSet rs = model.cari(conn);

                if (rs.next()) {
                    view.tfNama030.setText(rs.getString("Nama030"));
                    view.taAlamat030.setText(rs.getString("Alamat030"));
                    view.tfPekerjaan030.setText(rs.getString("Pekerjaan030"));
                    view.tfGajiPokok030.setText(String.valueOf(rs.getInt("GajiPokok030")));
                    JOptionPane.showMessageDialog(view, "Data Ditemukan!");
                } else {
                    JOptionPane.showMessageDialog(view, "Data Kode Nasabah tidak ditemukan!");
                }
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
