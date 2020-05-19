package Main;

public class MVCMenu {

    ViewHome viewHome = new ViewHome();
    ViewPinjam viewPinjam = new ViewPinjam();
    ViewTampil viewTampil = new ViewTampil();
    ViewAbout viewAbout = new ViewAbout();
    ViewEdit viewEdit = new ViewEdit();
    ModelMenu modelMenu = new ModelMenu();
    ContMenu contMenu = new ContMenu(viewHome, viewPinjam, viewTampil, viewAbout, viewEdit, modelMenu);
}
