package sample;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddBookController {

    public Label SuccessfulLabel;
    public TextField BookIdTextField;
    public TextField BookNameTextField;
    public TextField GenreTextField;
    public TextField PriceTextField;
    public void AddBookButton(ActionEvent actionEvent) throws IOException{
        String s1=BookNameTextField.getText();
        String s2=GenreTextField.getText();
        String s3=PriceTextField.getText();
        int n1=Integer.parseInt(s3);
        if(s1.equals("")||s2.equals("")||s3.equals("")){
            SuccessfulLabel.setVisible(true);
            SuccessfulLabel.setText("One/more entries is blank..!!");
        }else{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection conn=connectionClass.getConnection();
            try {
                Statement statement=conn.createStatement();
                String sql="INSERT INTO BookTable (BookName,Genre,Price) values ('"+s1+"','"+s2+"','"+n1+"')";
                int x=statement.executeUpdate(sql);
                if(x>0){
                    SuccessfulLabel.setVisible(true);
                    SuccessfulLabel.setText("Book Successfully entered");
                    System.out.println("Successfully Entered a book");
                }else{
                    System.out.println("Book not entered");
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
