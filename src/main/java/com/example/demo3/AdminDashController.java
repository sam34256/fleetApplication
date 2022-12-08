package com.example.demo3;



import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminDashController implements Initializable {

    private String genderSet = "";

    private String  stutusSet="";

    @FXML
    private TextField FName_fld;

    @FXML
    private TextField Phone_no_fld;
    @FXML
    private TextField LName_fld;
    @FXML
    private TextField licenseNumber;


    @FXML
    private RadioButton Male_radio_btn;
    @FXML
    private RadioButton Female_radio_btn;
    @FXML
    private RadioButton active_radio_btn;
    @FXML
    private RadioButton inactive_radio_btn;




    //Second splitPane clients listview
    @FXML
    private TextField email_fld;
    @FXML
    private TextField Vechile_Year;
    @FXML
    private TextField model_fld;
    @FXML
    private TextField mileAge_fld;
    @FXML
    private TextField username_fld;
    @FXML
    private TextField type_fld;
    @FXML
    private TextField password_fld;
    @FXML
    private CheckBox ck_acc_cb;
    @FXML
    private CheckBox sv_acc_cb;
    @FXML
    private TextField ck_acc_bal_fld;
    @FXML
    private TextField sv_acc_bal_fld;
    @FXML
    private Button Create_new_btn;
    @FXML
    private ChoiceBox state_fld;

    //Third Pane clients deposit
    @FXML
    private TextField rusername_fld;
    @FXML
    private Button search_btn;
    @FXML
    private TextField ck_amount_fld;
    @FXML
    private Button ck_deposit_btn;
    @FXML
    private TextField sv_amount_fld;
    @FXML
    private Button sv_deposit_btn;
    @FXML
    private TextField search_database_fld;
    @FXML
    private Button Search_Client_btn;
    @FXML
    private TextField raddress_fld;
    @FXML
    private Button Delete_btn;
    //Driver table
    @FXML
    private TableView<DriverView> drivers_table;
    @FXML
    private TableColumn  <DriverView,String> col_Driver_id;
    @FXML
    private TableColumn <DriverView,String>   col_FirstName;
    @FXML
    private TableColumn <DriverView,String>  col_LastName;
    @FXML
    private TableColumn <DriverView,String>  col_driverEmail;
    @FXML
    private TableColumn <DriverView,String>  col_Gender;
    @FXML
    private TableColumn  <DriverView,String> col_phoneNumber;
    @FXML
    private TableColumn <DriverView,String>  col_LicenseNumber;

    //Available_drivers table
    @FXML
    private TableView <DriverAvailabilityView>  Available_drivers;
    @FXML
    private TableColumn <DriverAvailabilityView,String>  driverId;
    @FXML
    private TableColumn  <DriverAvailabilityView,String>  col_avFirstName;
    @FXML
    private TableColumn  <DriverAvailabilityView,String>  col_vechileId;
    @FXML
    private TextField ck_assignField;
    @FXML
    private Button ck_assign_driver_btn;
    //unavailableDrivers table
    //l
    @FXML
    private TableView <DriverAvailabilityView> unavailableDrivers;
    @FXML
    private TableColumn  <DriverAvailabilityView,String> col_un_driverId;
    @FXML
    private TableColumn <DriverAvailabilityView,String> col_ud_firstName;
    @FXML
    private TableColumn <DriverAvailabilityView,String> col_ud_vehicleId;
    @FXML

    private TextField search_db_fld;


  


    @FXML
    private Button Update_btn;
    @FXML
    private ComboBox<String> state_ComboBox;
    @FXML
    private SplitPane pnCreateClient;
    @FXML
    private Pane pnClientsListview;
    @FXML
    private AnchorPane pnDeposits;


    @FXML
    private Button create_c_btn, vechiles_btn, drivers_btn, logout_btn;
// table data vehicle view
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
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;


    ObservableList<DriverView>viewDriver = FXCollections.observableArrayList();
    ObservableList<DriverAvailabilityView>viewAavailableDriver = FXCollections.observableArrayList();

    ObservableList<DriverAvailabilityView>viewunAavailableDriver = FXCollections.observableArrayList();
    ObservableList<VechileView> VechicleList = FXCollections.observableArrayList();
    ObservableList<String> stateList = FXCollections.observableArrayList(
            "Alabama",
            "Alaska",
            "Arizona",
            "Arkansas",
            "California",
            "Colorado",
            "Connecticut",
            "Delaware",
            "Florida",
            "Georgia",
            "Hawaii",
            "Idaho",
            "Illinois",
            "Indiana",
            "Iowa",
            "Kansas",
            "Kentucky",
            "Louisiana",
            "Maine",
            "Maryland",
            "Massachusetts",
            "Michigan",
            "Minnesota",
            "Mississippi",
            "Missouri",
            "Montana",
            "Nebraska",
            "Nevada",
            "New Hampshire",
            "New Jersey",
            "New Mexico",
            "New York",
            "North Carolina",
            "North Dakota",
            "Ohio",
            "Oklahoma",
            "Oregon",
            "Pennsylvania",
            "Rhode Island",
            "South Carolina",
            "South Dakota",
            "Tennessee",
            "Texas",
            "Utah",
            "Vermont",
            "Virginia",
            "Washington",
            "West Virginia",
            "Wisconsin",
            "Wyoming");
    @FXML
    private TextField oil_due;
    @FXML
    private TextField reg_due;
    @FXML
    private TextField anual_check;



   
  
    
 @FXML
 public void newDriver(ActionEvent event) throws SQLException {
     Connectivity connect = new Connectivity();
     Connection con=connect.getConnection();
     String query = "INSERT INTO driver ("+"first_name,last_name,email,gender,phone_number, license_number, user_name,password,status) values"
             +"(?,?,?,?,?,?,?,?,?)";
     PreparedStatement statement = con.prepareStatement(query);
     statement.setString(1, FName_fld.getText());
     statement.setString(2, LName_fld.getText());
     statement.setString(3, email_fld.getText());
     statement.setString(4,genderCheck() );
     statement.setString(5, Phone_no_fld.getText() );
     statement.setString(6,licenseNumber.getText() );
     statement.setString(7, username_fld.getText());
     statement.setString(8, password_fld.getText());
     statement.setString(9, statusCheck());


     statement.executeUpdate();



 }
@FXML
    private void assign() throws SQLException {

        Connectivity connect = new Connectivity();
        Connection con=connect.getConnection();
        String query =
                "UPDATE fleet_management_system.vechiles_info  SET Status = 'inActive' WHERE vechile_number = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1,ck_assignField.getText()) ;

    }
    @FXML
    private void unassign() throws SQLException {

        Connectivity connect = new Connectivity();
        Connection con = connect.getConnection();
        String query =
                "UPDATE fleet_management_system.vechiles_info  SET Status = 'inActive' WHERE vechile_number = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, ck_assignField.getText());
    }


    @FXML
    private void handleClicks(ActionEvent event) throws IOException {

        if (event.getSource() == create_c_btn) {

            pnCreateClient.toFront();


        } else if (event.getSource() == vechiles_btn) {
            pnClientsListview.toFront();
        } else if (event.getSource() == drivers_btn) {
            pnDeposits.toFront();
        } else if (event.getSource() == logout_btn) {
            root =  FXMLLoader.load(getClass().getResource("MainModified.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();
        }
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
      Connectivity connect = new Connectivity();
        Connection con;
        con = connect.getConnection();

        vechile_table.setEditable(true);
        col_mname.setCellFactory(TextFieldTableCell.forTableColumn());
        col_dob.setCellFactory(TextFieldTableCell.forTableColumn());
        col_address.setCellFactory(TextFieldTableCell.forTableColumn());
        col_zip.setCellFactory(TextFieldTableCell.forTableColumn());
        col_country.setCellFactory(TextFieldTableCell.forTableColumn());



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
            state_ComboBox.setItems(stateList);

            FilteredList<VechileView> filteredData = new FilteredList<>(VechicleList, b -> true );

            search_db_fld.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(VechileView ->{
                     if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                         return true;
                     }

                     String searchKeyword = newValue.toLowerCase();
                     if(VechileView.getVechile_year().toLowerCase().indexOf(searchKeyword) >-1){
                         return true;
                     }
                     else
                         if(VechileView.getMaking_model().toLowerCase().indexOf(searchKeyword) >-1) {
                             return true;
                         }
                     else
                         if ((VechileView.getAccount_number().toString().indexOf(searchKeyword) >-1)) {
                               return true;
                         }
                         else
                         if ((VechileView.getAnnual_checkup().toString().indexOf(searchKeyword) >-1)) {
                             return true;
                         }
                         else
                         if ((VechileView.getStatus().toString().indexOf(searchKeyword) >-1)) {
                             return true;
                         }
                         else
                             return false;
                });
            });
            SortedList<VechileView> sortedData = new SortedList<>(filteredData);

            sortedData.comparatorProperty().bind(vechile_table.comparatorProperty());
            vechile_table.setItems(sortedData);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        drivers_table.setEditable(true);
        col_FirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        col_LastName.setCellFactory(TextFieldTableCell.forTableColumn());
        col_driverEmail.setCellFactory(TextFieldTableCell.forTableColumn());

        try {
            ResultSet rs2 = con.createStatement().executeQuery("select * from driver ");
            while (rs2.next()) {
                viewDriver.add(new DriverView(
                        rs2.getString("driver_id"),
                        rs2.getString("first_name"),
                        rs2.getString("last_name"),
                        rs2.getString("email"),
                        rs2.getString("gender"),
                        rs2.getString("phone_number"),
                        rs2.getString("license_number")));

            }

        col_Driver_id.setCellValueFactory(new PropertyValueFactory<>("driver_id"));
        col_FirstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        col_LastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        col_driverEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_Gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        col_LicenseNumber.setCellValueFactory(new PropertyValueFactory<>("license_number"));

        drivers_table.setItems(viewDriver);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try{
            ResultSet rs1 = con.createStatement().executeQuery("select driver_id,first_name,password from driver where status= 'active' ");
            while (rs1.next()) {
                viewAavailableDriver.add( new DriverAvailabilityView(
                        rs1.getString("driver_id"),
                        rs1.getString("first_name"),
                        rs1.getString("password")
                ));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        driverId.setCellValueFactory(new PropertyValueFactory<>("driver_id"));
        col_avFirstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        col_vechileId.setCellValueFactory(new PropertyValueFactory<>("password"));


        Available_drivers.setItems(viewAavailableDriver);


        try{
            ResultSet rs2 = con.createStatement().executeQuery("select driver_id,first_name,password from driver where status= 'inactive' ");
            while (rs2.next()) {
                viewunAavailableDriver.add( new DriverAvailabilityView(
                        rs2.getString("driver_id"),
                        rs2.getString("first_name"),
                        rs2.getString("password")
                ));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        col_un_driverId.setCellValueFactory(new PropertyValueFactory<>("driver_id"));
        col_ud_firstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        col_ud_vehicleId.setCellValueFactory(new PropertyValueFactory<>("password"));


        unavailableDrivers.setItems(viewunAavailableDriver);


       }

    public String genderCheck() {

        if (Male_radio_btn.isSelected()) {
            genderSet = "Male";
        } else if (Female_radio_btn.isSelected()) {
            genderSet = "Female";


        }
        return genderSet;
    }
    public String statusCheck() {

        if (active_radio_btn.isSelected()) {
           stutusSet = "active";
        } else if (inactive_radio_btn.isSelected()) {
            stutusSet = "inactive";


        }
        return stutusSet;
    }

    public void createVehicle(ActionEvent event) throws SQLException {
        Connectivity connect = new Connectivity();
        Connection con=connect.getConnection();
        String query = "INSERT INTO vechiles_info ("+"making_model,vechile_year,oil_due_date,registeration_due_date,annual_checkup,mile_age,Type,Status) values"
                +"(?,?,?,?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, model_fld.getText());
        statement.setString(2, Vechile_Year.getText());
        statement.setString(3,oil_due.getText());
        statement.setString(4, reg_due.getText());
        statement.setString(5,anual_check.getText() );
        statement.setString(6, mileAge_fld.getText() );
        statement.setString(7,type_fld.getText() );
        statement.setString(8, "commercial");

        statement.executeUpdate();
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
            state_ComboBox.setItems(stateList);


    }

    public void delete(ActionEvent event) throws SQLException {
        Connectivity connect = new Connectivity();
        Connection con;
        con = connect.getConnection();
        vechile_table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<VechileView>() {
            @Override
            public void changed(ObservableValue<? extends VechileView> observableValue, VechileView vechileView, VechileView t1) {
                if(vechile_table.getSelectionModel().getSelectedItem()!=null) {
                    TableView.TableViewSelectionModel selectionModel  = vechile_table.getSelectionModel();
                    ObservableList selctedCells = selectionModel.getSelectedCells();
                    TablePosition tablePosition = (TablePosition) selctedCells.get(0);
                    Object val = tablePosition.getTableColumn().getCellData(t1);
                    System.out.println(val);
                }
            }
        });




    }



}
