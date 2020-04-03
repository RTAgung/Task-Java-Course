import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InputDataMahasiswa extends JFrame {
    JLabel lNim, lNama, lAlamat;
    JTextField tfNim, tfNama, tfAlamat;
    JButton bSimpan;
    JPanel panelForm, panelTombol;

    String DBurl = "jdbc:mysql://localhost/praktikum";
    String DBusername = "root";
    String DBpassword = "";
    Connection connection;
    Statement statement;

    public InputDataMahasiswa(){
        setTitle("Coba Database!");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        lNim = new JLabel("Nim");
        lNama = new JLabel("Nama");
        lAlamat = new JLabel("Alamat");
        tfNim = new JTextField(9);
        tfNama = new JTextField(50);
        tfAlamat = new JTextField(50);
        bSimpan = new JButton("Simpan");
        panelForm = new JPanel(new GridLayout(3,2));
        panelTombol = new JPanel(new FlowLayout());

        setLayout(new BorderLayout());
        add(panelForm, BorderLayout.CENTER);
        panelForm.add(lNim);
        panelForm.add(tfNim);
        panelForm.add(lNama);
        panelForm.add(tfNama);
        panelForm.add(lAlamat);
        panelForm.add(tfAlamat);
        add(panelTombol, BorderLayout.SOUTH);
        panelTombol.add(bSimpan);

        bSimpan.addActionListener(e -> masukkanData());
    }

    private void masukkanData() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = (Statement) connection.createStatement();

            statement.executeUpdate("INSERT INTO `mahasiswa`(`NIM`, `Nama`, `Alamat`) " +
                    "VALUES ('"+ tfNim.getText() +"','"+ tfNama.getText() +"','"+ tfAlamat.getText() +"')");

            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan",
                    "Hasil", JOptionPane.INFORMATION_MESSAGE);
            statement.close();
            connection.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new InputDataMahasiswa();
    }
}
