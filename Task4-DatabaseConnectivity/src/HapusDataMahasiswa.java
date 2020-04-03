import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HapusDataMahasiswa extends JFrame {
    JLabel lNim, lKeterangan;
    JTextField tfNim;
    JButton bHapus;
    JPanel panelForm, panelTombol, panelKeterangan;

    String DBurl = "jdbc:mysql://localhost/praktikum";
    String DBusername = "root";
    String DBpassword = "";
    Connection connection;
    Statement statement;

    public HapusDataMahasiswa() {
        setTitle("Coba Database!");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        lNim = new JLabel("Nim");
        lKeterangan = new JLabel("Data dengan nim yang akan dihapus : ");
        tfNim = new JTextField(9);
        bHapus = new JButton("Hapus");
        panelForm = new JPanel(new GridLayout(1, 2));
        panelTombol = new JPanel(new FlowLayout());
        panelKeterangan = new JPanel(new FlowLayout());

        setLayout(new BorderLayout());
        add(panelKeterangan, BorderLayout.NORTH);
        panelKeterangan.add(lKeterangan);
        add(panelForm, BorderLayout.CENTER);
        panelForm.add(lNim);
        panelForm.add(tfNim);
        add(panelTombol, BorderLayout.SOUTH);
        panelTombol.add(bHapus);

        bHapus.addActionListener(e -> hapusData());
    }

    private void hapusData() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = (Statement) connection.createStatement();
            statement.execute("DELETE FROM `mahasiswa` WHERE `NIM` = '"+ tfNim.getText() +"'");
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!");
        }
    }

    public static void main(String[] args) {
        new HapusDataMahasiswa();
    }
}


