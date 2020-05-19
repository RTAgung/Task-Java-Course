package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContLogin implements ActionListener{

    ViewLogin viewLogin;
    ViewDaftar viewDaftar;
    ModelLogin modelLogin;
    public ContLogin(ViewLogin viewLogin, ViewDaftar viewDaftar, ModelLogin modelLogin) {
        this.viewLogin = viewLogin;
        this.viewDaftar = viewDaftar;
        this.modelLogin = modelLogin;

        viewLogin.setVisible(true);

        viewLogin.bLogin.addActionListener(this);
        viewLogin.bDaftar.addActionListener(this);
        viewLogin.bExit.addActionListener(this);
        viewDaftar.bDaftar.addActionListener(this);
        viewDaftar.bBatal.addActionListener(this);
        viewDaftar.bExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewLogin.bLogin){
            login();
        } else if (e.getSource() == viewLogin.bDaftar){
            viewLogin.setVisible(false);
            viewDaftar.setVisible(true);
            reset();
        } else if (e.getSource() == viewLogin.bExit){
            exit();
        } else if (e.getSource() == viewDaftar.bDaftar) {
            daftar();
        } else if (e.getSource() == viewDaftar.bBatal){
            viewDaftar.setVisible(false);
            viewLogin.setVisible(true);
            reset();
        } else if (e.getSource() == viewDaftar.bExit) {
            exit();
        }
    }

    public void login(){
        String username = viewLogin.getUsername();
        String password = viewLogin.getPassword();

        if (modelLogin.getCountForSignIn(username, password) > 0){
            JOptionPane.showMessageDialog(null, "Berhasil Login");
            viewLogin.setVisible(false);
            viewDaftar.setVisible(false);
            new MVCMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Gagal Login");
        }
    }

    public void daftar() {
        String username = viewDaftar.getUsername();
        String password = viewDaftar.getPassword();

        if (modelLogin.insertAccount(username, password) == 1){
            JOptionPane.showMessageDialog(null, "Berhasil Daftar");
            viewDaftar.setVisible(false);
            viewLogin.setVisible(true);
            reset();
        } else {
            JOptionPane.showMessageDialog(null, "Username telah terdaftar");
        }
    }

    public void reset(){
        viewLogin.tfUsername.setText("");
        viewLogin.tfPassword.setText("");
        viewDaftar.tfUsername.setText("");
        viewDaftar.tfPassword.setText("");
    }

    public void exit(){
        int input = JOptionPane.showConfirmDialog(null, "Yakin ? ", "EXIT" ,JOptionPane.YES_NO_OPTION);
        if (input == 0){
            System.exit(0);
        }
    }
}
