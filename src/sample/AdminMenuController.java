package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminMenuController {

    public void ViewBooksButton(ActionEvent actionEvent) throws IOException{
        Parent parent1=FXMLLoader.load(getClass().getResource("ViewBooks.fxml"));
        Stage stage1=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1=new Scene(parent1);
        stage1.setScene(scene1);
    }

    public void ViewUsersButton(ActionEvent actionEvent) throws IOException {
        Parent parent1=FXMLLoader.load(getClass().getResource("ViewUsers.fxml"));
        Stage stage1=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene1=new Scene(parent1);
        stage1.setScene(scene1);
    }

    public void ViewIssuedBooksButton(ActionEvent actionEvent) throws IOException{
        Parent parent1=FXMLLoader.load(getClass().getResource("ViewIssuedBooks.fxml"));
        Stage stage1=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene1=new Scene(parent1);
        stage1.setScene(scene1);
    }

    public void IssueBookButton(ActionEvent actionEvent) throws IOException {
        Parent parent1=FXMLLoader.load(getClass().getResource("IssueBook.fxml"));
        Stage stage1=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene1=new Scene(parent1);
        stage1.setTitle("Issue Book");
        stage1.setScene(scene1);
    }

    public void AddUserButton(ActionEvent actionEvent) throws IOException{
        Parent parent1=FXMLLoader.load(getClass().getResource("AddUser.fxml"));
        Stage stage1=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene1=new Scene(parent1);
        stage1.setScene(scene1);
    }

    public void AddBookButton(ActionEvent actionEvent) throws IOException{
        Parent parent1=FXMLLoader.load(getClass().getResource("AddBook.fxml"));
        Stage stage1=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene1=new Scene(parent1);
        stage1.setScene(scene1);
    }

    public void ReturnBookButton(ActionEvent actionEvent) throws IOException{
        Parent parent1=FXMLLoader.load(getClass().getResource("ReturnBook.fxml"));
        Stage stage1=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene1=new Scene(parent1);
        stage1.setScene(scene1);
    }

    public void CreateorResetButton(ActionEvent actionEvent) {

    }

    public void LogOutButton(ActionEvent actionEvent) throws IOException{
        Parent parent1=FXMLLoader.load(getClass().getResource("Main.fxml"));
        Stage stage1=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1=new Scene(parent1);
        stage1.setScene(scene1);
    }
}
