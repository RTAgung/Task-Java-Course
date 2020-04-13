import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
    JLabel title;

    JLabel lName = new JLabel("Nama : ");
    JTextField tfName = new JTextField();
    JLabel lNumber = new JLabel("No HP : ");
    JTextField tfNumber = new JTextField();
    JLabel lAge = new JLabel("Umur : ");
    JTextField tfAge = new JTextField();
    JLabel lEmail = new JLabel("Email : ");
    JTextField tfEmail = new JTextField();
    JLabel lSearch = new JLabel("Search : ");
    JTextField tfSearch = new JTextField();

    JButton bInsert = new JButton("Insert");
    JButton bUpdate = new JButton("Update");
    JButton bDelete = new JButton("Delete");
    JButton bSearch = new JButton("Search");
    JButton bRefresh = new JButton("Refresh");
    JButton bReset = new JButton("Reset");

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    Object coloumnName[] = {"#", "Nama", "No HP", "Umur", "Email"};

    public View(){
        tableModel = new DefaultTableModel(coloumnName, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(840,400);

        title = new JLabel("CONTACT");
        add(title);
        title.setBounds(680,20,100,20);
        title = new JLabel("NUMBER");
        add(title);
        title.setBounds(683,40,100,20);

        add(scrollPane);
        scrollPane.setBounds(20,50,560,300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(lSearch);
        lSearch.setBounds(20,20,50,20);
        add(lName);
        lName.setBounds(600,100,50,20);
        add(lNumber);
        lNumber.setBounds(600,130,50,20);
        add(lAge);
        lAge.setBounds(600,160,50,20);
        add(lEmail);
        lEmail.setBounds(600,190,50,20);

        add(tfSearch);
        tfSearch.setBounds(80,20,300,20);
        add(tfName);
        tfName.setBounds(660,100,150,20);
        add(tfNumber);
        tfNumber.setBounds(660,130,150,20);
        add(tfAge);
        tfAge.setBounds(660,160,150,20);
        add(tfEmail);
        tfEmail.setBounds(660,190,150,20);

        add(bSearch);
        bSearch.setBounds(390,20,90,20);
        add(bRefresh);
        bRefresh.setBounds(490,20,90,20);
        add(bInsert);
        bInsert.setBounds(600,230,90,20);
        add(bUpdate);
        bUpdate.setBounds(720,230,90,20);
        add(bDelete);
        bDelete.setBounds(660,260,90,20);
        add(bReset);
        bReset.setBounds(660,290,90,20);
    }

    public String getNameContact(){ return tfName.getText();}
    public String getNumber(){ return tfNumber.getText();}
    public String getAge(){ return tfAge.getText();}
    public String getEmail(){ return tfEmail.getText();}
    public String getSearch(){ return tfSearch.getText();}
}
