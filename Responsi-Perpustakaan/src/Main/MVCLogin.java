package Main;

public class MVCLogin {

    ViewLogin viewLogin = new ViewLogin();
    ViewDaftar viewDaftar = new ViewDaftar();
    ModelLogin modelLogin = new ModelLogin();
    ContLogin contLogin = new ContLogin(viewLogin, viewDaftar, modelLogin);
}
