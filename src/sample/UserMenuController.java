package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UserMenuController {

    public void ViewBooksButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Hello Inside USer Contoller java file");
        Parent parent1=FXMLLoader.load(getClass().getResource("ViewBooks.fxml"));
        Stage stage1=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1=new Scene(parent1);
        stage1.setScene(scene1);
    }

    public void MyBooksButton(ActionEvent actionEvent) throws IOException{
        Parent parent1=FXMLLoader.load(getClass().getResource("ViewIssuedBooks.fxml"));
        Stage stage1=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1=new Scene(parent1);
        stage1.setScene(scene1);
    }

    public void LogOutButton(ActionEvent actionEvent) throws IOException{
        Parent parent1=FXMLLoader.load(getClass().getResource("Main.fxml"));
        Stage stage1=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1=new Scene(parent1);
        stage1.setScene(scene1);
    }
}
