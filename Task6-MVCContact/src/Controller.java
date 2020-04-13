import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller implements ActionListener {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        if (model.getSumOfData() != 0){
            refreshTable();
        }

        view.bInsert.addActionListener(this);
        view.bUpdate.addActionListener(this);
        view.bDelete.addActionListener(this);
        view.bReset.addActionListener(this);
        view.bSearch.addActionListener(this);
        view.bRefresh.addActionListener(this);

        view.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = view.table.getSelectedRow();
                String name = view.table.getValueAt(row,1).toString();
                String number = view.table.getValueAt(row,2).toString();
                String age = view.table.getValueAt(row,3).toString();
                String email = view.table.getValueAt(row,4).toString();

                view.tfName.setText(name);
                view.tfNumber.setText(number);
                view.tfAge.setText(age);
                view.tfEmail.setText(email);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           if (e.getSource() == view.bInsert){
               String name = view.getNameContact();
               String number = view.getNumber();
               String sAge = view.getAge();
               int age;
               try {
                   age = Integer.parseInt(sAge);
               } catch (NumberFormatException ex){
                   age = 0;
               }
               String email = view.getEmail();

               if (number.equals("")){
                   JOptionPane.showMessageDialog(null, "Field NoHP Is Empty!");
               } else {
                   model.insertData(name,number,age,email);
                   refreshTable();
               }
           } else if (e.getSource() == view.bUpdate){
               String name = view.getNameContact();
               String number = view.getNumber();
               String sAge = view.getAge();
               int age;
               try {
                   age = Integer.parseInt(sAge);
               } catch (NumberFormatException ex){
                   age = 0;
               }
               String email = view.getEmail();

               model.updateData(name,number,age,email);
               refreshTable();
           } else if (e.getSource() == view.bDelete){
               String name = view.getNameContact();
               String number = view.getNumber();

               int input = JOptionPane.showConfirmDialog(null,
                       "Are You Sure To Delete "+ number +" "+ name +" ?",
                       "Option" , JOptionPane.YES_NO_OPTION);
               if (input == 0){
                   model.deleteData(number);
                   refreshTable();
               }
           } else if (e.getSource() == view.bReset){
               view.tfSearch.setText("");
               view.tfName.setText("");
               view.tfNumber.setText("");
               view.tfAge.setText("");
               view.tfEmail.setText("");
           } else if (e.getSource() == view.bSearch){
               String name = view.tfSearch.getText();
               if (name.equals("")){
                   JOptionPane.showMessageDialog(null,"Field Search Is Empty!");
               } else{
                   String data[][] = model.readDataSearch(name);
                   view.table.setModel(new JTable(data, view.coloumnName).getModel());
               }
           } else if (e.getSource() == view.bRefresh){
               refreshTable();
           }
    }

    public void refreshTable(){
        view.tfSearch.setText("");
        String data[][] = model.readAllData();
        view.table.setModel(new JTable(data, view.coloumnName).getModel());
    }
}
