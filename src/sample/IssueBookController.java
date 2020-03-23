package sample;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class IssueBookController {

    public TextField UserIdTextField;
    public TextField BookIdTextField;
    public TextField PeriodTextField;
    public DatePicker IssueDateDatePicker;

    public void SubmitButton(ActionEvent actionEvent) {
        String s1=UserIdTextField.getText();
        String s2=BookIdTextField.getText();
        String s3=PeriodTextField.getText();
        LocalDate localdate=IssueDateDatePicker.getValue();
        int n1=Integer.parseInt(s1);
        int n2=Integer.parseInt(s2);
        int n3=Integer.parseInt(s3);
        ConnectionClass connectionClass= new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        String sqldash="SELECT * from IssueTable where BookId="+n2;
        String sql="INSERT INTO IssueTable (UserId,BookId,IssueDate,Period) values ('"+n1+"','"+n2+"','"+localdate+"','"+n3+"')";
        try {
            Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=statement.executeQuery(sqldash);
            while(rs.next()){
                System.out.println("IssueID "+rs.getInt(1));
            }
            rs.previous();
            rs.previous();
            if(rs.next()){
                System.out.println("Issue ID inside If condition"+rs.getInt(1));
                if(rs.getDate(6)!=null){
                    int x=statement.executeUpdate(sql);
                    if(x>0){
                        System.out.println("Book Issued Successfully");
                    }else{
                        System.out.println("Book not issued");
                    }
                }else{
                    System.out.println("Book already issued to someone");
                }
            }else{
                //System.out.println("Issue ID inside else condition"+rs.getInt(1));
                int x=statement.executeUpdate(sql);
                if(x>0){
                    System.out.println("Book Issued Successfully");
                }else{
                    System.out.println("Book not issued");
                }
            }
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
