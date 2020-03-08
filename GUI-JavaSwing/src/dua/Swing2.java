package dua;

import javax.swing.*;

public class Swing2 extends JFrame {
    JLabel luser = new JLabel(" Username : ");
    JLabel lpass = new JLabel(" Password : ");
    JTextField fuser = new JTextField(10);
    JPasswordField fpass = new JPasswordField(10);
    JButton blogin = new JButton(" Login ");
    JButton bcancel = new JButton(" Cancel ");

    public Swing2(){
        setTitle("Login");
        setDefaultCloseOperation(3);
        setSize(280,150);

        setLayout(null);
        add(luser);
        add(lpass);
        add(fuser);
        add(fpass);
        add(blogin);
        add(bcancel);

        luser.setBounds(10,10, 120, 20);
        lpass.setBounds(10,35, 120, 20);
        fuser.setBounds(100,10, 150, 20);
        fpass.setBounds(100,35, 150, 20);

        blogin.setBounds(30,70,100,20);
        bcancel.setBounds(140,70,100,20);
        setVisible(true);
    }
}
