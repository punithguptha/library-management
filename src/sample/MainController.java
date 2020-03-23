package sample;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainController {

    public TextField UserNameTextField;
    public PasswordField PasswordTextField;
    public TextField AlertTextField;
    public static int userid;
    public static int adminval=0;

    public void LoginButton(ActionEvent actionEvent) {
        System.out.println("Hello world");
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        String s1=UserNameTextField.getText();
        String s2=PasswordTextField.getText();
        System.out.println(s1);
        System.out.println(s2);
        if(s1.equals("")&&s2.equals("")){
            AlertTextField.setText("both fields are empty");
            AlertTextField.setVisible(true);
        }else if(s1.equals("")){
            AlertTextField.setText("Empty username");
            AlertTextField.setVisible(true);
        }else if(s2.equals("")){
            AlertTextField.setText("Empty password field");
            AlertTextField.setVisible(true);
        }
        String sql="SELECT * FROM UserTable where UserName="+"'"+s1+"'"+"and Password="+"'"+s2+"'";
        Statement statement=null;
        try{
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            if(rs.next()){
                String uid=rs.getString(1);
                userid=Integer.parseInt(uid);
                String uname=rs.getString(2);
                String password=rs.getString(3);
                String admin=rs.getString(4);
                if(admin.equals("1")){
                    adminval=1;
                    Parent parent1=FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
                    Stage stage1=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
                    Scene scene1=new Scene(parent1);
                    stage1.setScene(scene1);
                }else if(admin.equals("0")){
                    adminval=0;
                    Parent parent1=FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
                    Scene scene1=new Scene(parent1);
                    Stage stage1=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                    stage1.setScene(scene1);
                }
                System.out.println(uid+uname+password+admin);
            }else{
                System.out.println("Invalid login attempt");
            }
            rs.close();
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
