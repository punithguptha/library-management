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
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;



public class ViewIssuedBooksController implements Initializable{
    public TableView<IssueBooks> IssueBookTableView;
    public TableColumn<IssueBooks,Integer> IssueIdTableColumn;
    public TableColumn<IssueBooks,Integer> UserIdTableColumn;
    public TableColumn<IssueBooks,Integer> BookIdTableColumn;
    public TableColumn<IssueBooks,LocalDate> IssueDateTableColumn;
    public TableColumn<IssueBooks,Integer> PeriodTableColumn;
    public TableColumn<IssueBooks,LocalDate> ReturnDateTableColumn;
    public TableColumn<IssueBooks,Integer> FineTableColumn;
    private ObservableList<IssueBooks> oblist= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Integer uid=MainController.userid;
        System.out.println(uid+"This is inside initialize of view IssuedBooksController");
        ConnectionClass connectionClass=new ConnectionClass();
        Connection conn=connectionClass.getConnection();
        try {
            ResultSet rs;
            Statement statement=conn.createStatement();
            if(MainController.adminval==0){
                String sql="SELECT * FROM IssueTable where UserId="+uid;
                rs=statement.executeQuery(sql);
                System.out.println("After result statement");
            }else{
                String sql="SELECT * FROM IssueTable";
                rs=statement.executeQuery(sql);
                System.out.println("After result statement");
            }
            while(rs.next()){
                System.out.println("issuedate");
                LocalDate issuedate=null;
                LocalDate returndate=null;
                Date issuedatesql=rs.getDate(4);
                Date returndatesql=rs.getDate(6);
                System.out.println(issuedatesql);
                System.out.println(returndatesql);
                issuedate=issuedatesql.toLocalDate();
                if(returndatesql!=null)
                returndate=returndatesql.toLocalDate();
                oblist.add(new IssueBooks(rs.getInt(1),rs.getInt(2),rs.getInt(3),issuedate,rs.getInt(5),returndate,rs.getInt(7)));
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("There is an sql exception in there");
            //e.printStackTrace();
        }
        IssueIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("issueid"));
        UserIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("userid"));
        BookIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("bookid"));
        IssueDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("issuedate"));
        PeriodTableColumn.setCellValueFactory(new PropertyValueFactory<>("period"));
        ReturnDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("returndate"));
        FineTableColumn.setCellValueFactory(new PropertyValueFactory<>("fine"));
        IssueBookTableView.setItems(oblist);
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("There is an sql exception in there");
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
