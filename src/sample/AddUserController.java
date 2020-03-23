package sample;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddUserController {


    public TextField UserNameTextField;
    public Label SuccessfulLabel;
    public PasswordField UserPasswordTextField;
    public RadioButton AdminRadioButton;
    public RadioButton UserRadioButton;
    public ToggleGroup MyGroup;

    public void CreateUserButton(ActionEvent actionEvent) throws IOException{
        String s1=UserNameTextField.getText();
        String s2=UserPasswordTextField.getText();
        if(s1.equals("")||s2.equals("")){
            System.out.println("One/more fields is empty");
            SuccessfulLabel.setVisible(true);
            SuccessfulLabel.setText("One/More Fields is empty");
        }else {
            int x = 0;
            if (AdminRadioButton.isSelected()) {
                x = 1;
            }
            ConnectionClass connectionClass = new ConnectionClass();
            Connection conn = connectionClass.getConnection();
            try {
                Statement statement = conn.createStatement();
                String sql = "INSERT INTO UserTable (UserName,Password,Admin) values ('" + s1 + "','" + s2 + "','" + x + "')";
                int y = statement.executeUpdate(sql);
                if (y > 0) {
                    System.out.println("One User Added!..");
                    SuccessfulLabel.setVisible(true);
                    SuccessfulLabel.setText("User Added");
                }else {
                    System.out.println("No user added");
                    SuccessfulLabel.setVisible(true);
                    SuccessfulLabel.setText("No User Added");
                }
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void BackButton(ActionEvent actionEvent) throws IOException{
        if(MainController.adminval==0){
            Parent parent1= FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
            Stage stage1=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene1=new Scene(parent1);
            stage1.setScene(scene1);
            stage1.show();
        }else{
            Parent parent1= FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
            Stage stage1=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene1=new Scene(parent1);
            stage1.setScene(scene1);
            stage1.show();
        }
    }
}
