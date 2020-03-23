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
import java.net.ConnectException;
import java.net.URL;
import java.rmi.ConnectIOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ViewBooksController implements Initializable{


    public TableView<Books> TableViewMain;
    public TableColumn<Books,Integer> TableColumnBookId;
    public TableColumn<Books,String> TableColumnBookName;
    public TableColumn<Books,String> TableColumnGenre;
    public TableColumn<Books,Integer> TableColumnPrice;

    private ObservableList<Books> oblist= FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources){
        Connection conn;
        ConnectionClass connectionclass=new ConnectionClass();
        conn=connectionclass.getConnection();
        try {
            Statement statement=conn.createStatement();
            ResultSet rs=statement.executeQuery("SELECT * FROM BookTable");
            while(rs.next()){
                oblist.add(new Books(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TableColumnBookId.setCellValueFactory(new PropertyValueFactory<>("BookId"));
        TableColumnBookName.setCellValueFactory(new PropertyValueFactory<>("Bookname"));
        TableColumnGenre.setCellValueFactory(new PropertyValueFactory<>("Genre"));
        TableColumnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        TableViewMain.setItems(oblist);
        try {
            conn.close();
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
