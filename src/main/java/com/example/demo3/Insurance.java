package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Insurance implements Initializable {
    ObservableList<VechileView> VechicleList = FXCollections.observableArrayList();
    @FXML
    private TableView<VechileView> vechile_table;
    @FXML
    private TableColumn<VechileView, String> col_accnum;
    @FXML
    private TableColumn<VechileView, String> col_fname;
    @FXML
    private TableColumn<VechileView, String> col_lname;
    @FXML
    private TableColumn<VechileView, String> col_mname;
    @FXML
    private TableColumn<VechileView, String> col_dob;
    @FXML
    private TableColumn<VechileView, String> col_address;
    @FXML
    private TableColumn<VechileView, String> col_zip;
    @FXML
    private TableColumn<VechileView, String> col_state;
    @FXML
    private TableColumn<VechileView, String> col_country;
    @FXML
    private TextField search_db_fld;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connectivity connect = new Connectivity();
        Connection con;
        con = connect.getConnection();

        try {
            ResultSet rs = con.createStatement().executeQuery("select * from vechiles_info ");
            while (rs.next()) {

                VechicleList.add(new VechileView(
                        rs.getString("vechile_number"),
                        rs.getString("making_model"),
                        rs.getString("vechile_year"),
                        rs.getString("oil_due_date"),
                        rs.getString("registeration_due_date"),
                        rs.getString("annual_checkup"),
                        rs.getString("mile_age"),
                        rs.getString("Type"),
                        rs.getString("Status")));


            }
            col_accnum.setCellValueFactory(new PropertyValueFactory<>("vechile_number"));
            col_fname.setCellValueFactory(new PropertyValueFactory<>("making_model"));
            col_lname.setCellValueFactory(new PropertyValueFactory<>("vechile_year"));
            col_mname.setCellValueFactory(new PropertyValueFactory<>("oil_due_date"));
            col_dob.setCellValueFactory(new PropertyValueFactory<>("registeration_due_date"));
            col_address.setCellValueFactory(new PropertyValueFactory<>("annual_checkup"));
            col_zip.setCellValueFactory(new PropertyValueFactory<>("mile_age"));
            col_state.setCellValueFactory(new PropertyValueFactory<>("Type"));
            col_country.setCellValueFactory(new PropertyValueFactory<>("Status"));

            vechile_table.setItems(VechicleList);


            FilteredList<VechileView> filteredData = new FilteredList<>(VechicleList, b -> true);

            search_db_fld.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(VechileView -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();
                    if (VechileView.getVechile_year().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (VechileView.getMaking_model().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if ((VechileView.getAccount_number().toString().indexOf(searchKeyword) > -1)) {
                        return true;
                    } else if ((VechileView.getAnnual_checkup().toString().indexOf(searchKeyword) > -1)) {
                        return true;
                    } else if ((VechileView.getStatus().toString().indexOf(searchKeyword) > -1)) {
                        return true;
                    } else
                        return false;
                });
            });
            SortedList<VechileView> sortedData = new SortedList<>(filteredData);

            sortedData.comparatorProperty().bind(vechile_table.comparatorProperty());
            vechile_table.setItems(sortedData);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void refresh(ActionEvent event) throws SQLException {
        Connectivity connect = new Connectivity();
        Connection con;
        con = connect.getConnection();

        ResultSet rs = con.createStatement().executeQuery("select * from vechiles_info ");
        while (rs.next()) {

            VechicleList.add(new VechileView(
                    rs.getString("vechile_number"),
                    rs.getString("making_model"),
                    rs.getString("vechile_year"),
                    rs.getString("oil_due_date"),
                    rs.getString("registeration_due_date"),
                    rs.getString("annual_checkup"),
                    rs.getString("mile_age"),
                    rs.getString("Type"),
                    rs.getString("Status")));
            System.out.println(rs.getString("vechile_number"));


        }
        col_accnum.setCellValueFactory(new PropertyValueFactory<>("vechile_number"));
        col_fname.setCellValueFactory(new PropertyValueFactory<>("making_model"));
        col_lname.setCellValueFactory(new PropertyValueFactory<>("vechile_year"));
        col_mname.setCellValueFactory(new PropertyValueFactory<>("oil_due_date"));
        col_dob.setCellValueFactory(new PropertyValueFactory<>("registeration_due_date"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("annual_checkup"));
        col_zip.setCellValueFactory(new PropertyValueFactory<>("mile_age"));
        col_state.setCellValueFactory(new PropertyValueFactory<>("Type"));
        col_country.setCellValueFactory(new PropertyValueFactory<>("Status"));

        vechile_table.setItems(VechicleList);



    }

    public void logout(ActionEvent event) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }
}
