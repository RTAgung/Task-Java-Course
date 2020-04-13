import javax.swing.*;
import java.sql.*;

public class Model {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbcontact";
    static final String USER = "root";
    static final String PASS = "";
    Connection connection;
    Statement statement;

    public Model(){
        try {
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertData(String name, String number, int age, String email){
        try{
            String query = "INSERT INTO contact VALUES " +
                    "('"+ name +"','"+ number +"',"+ age +",'"+ email +"')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Insert Successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Insert Failed!\n"+ number +" Is Already Exist!");
        }
    }

    public int getSumOfData(){
        try{
            int sumOfData = 0;
            String query = "SELECT * FROM contact";
            statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                sumOfData++;
            }
            return sumOfData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public String[][] readAllData(){
        try{
            int sumOfData = 0;
            String data[][] = new String[getSumOfData()][5];
            String query = "SELECT * FROM contact ORDER BY Nama ASC";
            statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next() && sumOfData < getSumOfData()){
                data[sumOfData][0] = "" + (sumOfData+1);
                data[sumOfData][1] = resultSet.getString("Nama");
                data[sumOfData][2] = resultSet.getString("NoHP");
                data[sumOfData][3] = resultSet.getString("Umur");
                data[sumOfData][4] = resultSet.getString("Email");
                sumOfData++;
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String[][] readDataSearch(String name){
        try{
            int sumOfData = 0;
            int getSumOfData = 0;
            String query = "SELECT * FROM contact WHERE Nama LIKE '%" + name + "%' ORDER BY Nama ASC";
            statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                getSumOfData++;
            }

            String data[][] = new String[getSumOfData][5];
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[sumOfData][0] = "" + (sumOfData+1);
                data[sumOfData][1] = resultSet.getString("Nama");
                data[sumOfData][2] = resultSet.getString("NoHP");
                data[sumOfData][3] = resultSet.getString("Umur");
                data[sumOfData][4] = resultSet.getString("Email");
                sumOfData++;
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void updateData(String name, String number, int age, String email){
        try{
            String query = "UPDATE contact SET " +
                    "Nama = '"+ name +"', Umur = "+ age +", Email = '"+ email +"'" +
                    "WHERE NoHP = '"+ number +"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Update Successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Update Failed!");
        }
    }

    public void deleteData(String number){
        try {
            String query = "DELETE FROM contact WHERE NoHP = '"+ number +"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Delete Successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Delete Failed!");
        }
    }
}
