package sample;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class ReturnBookController {
    public TextField IssueIdTextField;
    public DatePicker ReturnDatePicker;
    public Label SuccessfulLabel;

    public void ReturnBookButton(ActionEvent actionEvent) {
        String s1=IssueIdTextField.getText();
        int n1=Integer.parseInt(s1);
        LocalDate returndate=ReturnDatePicker.getValue();
        if(s1.equals("")||returndate==null){
            SuccessfulLabel.setVisible(true);
            SuccessfulLabel.setText("one/more fields are empty");
        }else{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection conn=connectionClass.getConnection();
            Statement statement= null;
            try {
                statement = conn.createStatement();
                String sql="Update IssueTable set ReturnDate="+"'"+returndate+"' where IssueId="+n1;
                int x=statement.executeUpdate(sql);
                if(x>0){
                    System.out.println("Succesfully returned");
                    SuccessfulLabel.setVisible(true);
                    SuccessfulLabel.setText("Book Returned Successfully");
                }
                conn.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void BackButton(ActionEvent actionEvent) throws IOException {
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
