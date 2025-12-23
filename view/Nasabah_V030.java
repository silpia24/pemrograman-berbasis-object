package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Nasabah_V030 extends JFrame {

    public JTextField tfKode030, tfNama030, tfPekerjaan030, tfGajiPokok030;
    public JTextArea taAlamat030;
    public JButton btnSimpan, btnUbah, btnHapus, btnBatal;
    public JTable tabelData;
    public DefaultTableModel modelTabel;

    public Nasabah_V030() {
        setTitle("Form Nasabah 030 - UAS");
        setSize(900, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("Kode Nasabah:")).setBounds(20, 20, 100, 25);
        tfKode030 = new JTextField();
        tfKode030.setBounds(130, 20, 200, 25);
        add(tfKode030);

        add(new JLabel("Nama Nasabah:")).setBounds(20, 60, 100, 25);
        tfNama030 = new JTextField();
        tfNama030.setBounds(130, 60, 200, 25);
        add(tfNama030);

        add(new JLabel("Alamat:")).setBounds(20, 100, 100, 25);
        taAlamat030 = new JTextArea();
        taAlamat030.setLineWrap(true);
        taAlamat030.setWrapStyleWord(true);
        JScrollPane spAlamat = new JScrollPane(taAlamat030);
        spAlamat.setBounds(130, 100, 200, 60);
        add(spAlamat);

        add(new JLabel("Pekerjaan:")).setBounds(20, 170, 100, 25);
        tfPekerjaan030 = new JTextField();
        tfPekerjaan030.setBounds(130, 170, 200, 25);
        add(tfPekerjaan030);

        add(new JLabel("Gaji Pokok:")).setBounds(20, 210, 100, 25);
        tfGajiPokok030 = new JTextField();
        tfGajiPokok030.setBounds(130, 210, 200, 25);
        add(tfGajiPokok030);

        btnSimpan = new JButton("Simpan");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");
        btnBatal = new JButton("Batal");

        btnSimpan.setBounds(20, 260, 80, 30);
        btnUbah.setBounds(110, 260, 80, 30);
        btnHapus.setBounds(200, 260, 80, 30);
        btnBatal.setBounds(290, 260, 80, 30);

        add(btnSimpan);
        add(btnUbah);
        add(btnHapus);
        add(btnBatal);

        String[] kolom = {"Kode", "Nama", "Alamat", "Pekerjaan", "Gaji Pokok"};
        modelTabel = new DefaultTableModel(kolom, 0);
        tabelData = new JTable(modelTabel);

        JScrollPane spTabel = new JScrollPane(tabelData);
        spTabel.setBounds(400, 20, 450, 400);
        add(spTabel);
    }

    public void kosongkanForm() {
        tfKode030.setText("");
        tfNama030.setText("");
        taAlamat030.setText("");
        tfPekerjaan030.setText("");
        tfGajiPokok030.setText("");
        tfKode030.requestFocus();
    }
}
