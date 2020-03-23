package sample;

import Connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ViewUsersController implements Initializable{

    public TableView ViewUsersTableView;
    public TableColumn UserIdTableColumn;
    public TableColumn UserNameTableColumn;
    public TableColumn PasswordTableColumn;
    public TableColumn AdminTableColumn;

    public ObservableList<Users> oblist= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ConnectionClass connectionclass=new ConnectionClass();
        Connection conn=connectionclass.getConnection();
        Statement statement= null;
        try {
            statement = conn.createStatement();
            ResultSet rs=statement.executeQuery("SELECT * FROM UserTable");
            while(rs.next()){
                oblist.add(new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        UserIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("uid"));
        UserNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        PasswordTableColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        AdminTableColumn.setCellValueFactory(new PropertyValueFactory<>("Admin"));
        ViewUsersTableView.setItems(oblist);
        try {
            conn.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
