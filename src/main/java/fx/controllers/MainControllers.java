package fx.controllers;

import helpers.CRUD;
import helpers.ConnectDB;
import helpers.Constante;
import helpers.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class MainControllers implements Initializable {


    public static Stage stageEdit;
    public static Stage stageAdd;

    public int selectedIndex;

    public PreparedStatement preparedStatement;

    public Connection connection;

    //TODO: Сделать обработчик меню
    @FXML
    public MenuItem menuOpen;
    @FXML
    public MenuItem menuSave;
    @FXML
    public MenuItem menuPrint;
    @FXML
    public MenuItem menuExit;
    @FXML
    public MenuItem menuCopy;
    @FXML
    public MenuItem menuAdd;
    @FXML
    public MenuItem menuEdit;
    @FXML
    public MenuItem menuDelete;

    private ObservableList<Person> personList;

    public static AddControllers addControllers = new AddControllers();
    public static EditControllers editControllers = new EditControllers();
    public static Constante constante = new Constante();

    //кнопка добавить
    @FXML
    private Button btnAdd;

    //кнопка изменить
    @FXML
    private Button btnEdit;

    //кнопка удалить
    @FXML
    private Button btnDelete;

    //кнопка печать
    @FXML
    private Button btnPrint;

    //кнопка поиск
    @FXML
    private Button btnSearch;

    @FXML
    public TextField fldSearch;


    @FXML
    private Label lblStatus;

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblCountry;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblIndex;

    @FXML
    private Label lblemail;

    //TODO сделать загрузку изображения из базы
    @FXML
    private ImageView imgPhotos;

    @FXML
    public TableView<Person> tblPersonView;

    @FXML
    private TableColumn<Person, String> columnFirstName;

    @FXML
    private TableColumn<Person, String> columnLastName;

    @FXML
    private TableColumn<Person, String> columnPhone;

    private MenuBar menuBar;

    //TODO: сделать подтверждение очистки формы.
    public void clear(TextField field1, TextField field2, TextField field3, TextField field4,
                      TextField field5, TextField field6, TextField field7, TextField field8) {
        field1.clear();
        field2.clear();
        field3.clear();
        field4.clear();
        field5.clear();
        field6.clear();
        field7.clear();
        field8.clear();
    }

    //TODO: По выходу из метода обновлять TableView
    public void handleAdd(ActionEvent actionEvent) {

        try {
            stageAdd = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/add.fxml"));
            stageAdd.setTitle("Добавить запись.");
            stageAdd.setMinHeight(540);
            stageAdd.setMinWidth(340);
            stageAdd.setResizable(false);
            stageAdd.setScene(new Scene(root));
            stageAdd.initModality(Modality.WINDOW_MODAL);
            stageAdd.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stageAdd.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void handleEdit(ActionEvent actionEvent) {

        constante.setIndex(selectedIndex);

        try {
            stageEdit = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/edit.fxml"));
            stageEdit.setTitle("Редактировать запись.");
            stageEdit.setMinHeight(540);
            stageEdit.setMinWidth(340);
            stageEdit.setResizable(false);
            stageEdit.setScene(new Scene(root));
            stageEdit.initModality(Modality.WINDOW_MODAL);
            stageEdit.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stageEdit.show();
            editControllers.showPersonData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleDelete() {
        int selCell = tblPersonView.getSelectionModel().getSelectedIndex();
        if (selCell >= 0) {
            CRUD.deleteFromBase(selectedIndex);
            tblPersonView.getItems().remove(selCell);
        }
        System.out.println("ArrayIndexOutOfBoundsException");
    }

    //TODO: Метод печати контакта
    public void handlePrint(ActionEvent actionEvent) {

        {
            {

                try {
                    ProgressController.stageProgress = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/progress.fxml"));
                    ProgressController.stageProgress.setTitle("Распечатать");
                    ProgressController.stageProgress.setMinHeight(400);
                    ProgressController.stageProgress.setMinWidth(200);
                    ProgressController.stageProgress.setResizable(false);
                    ProgressController.stageProgress.setScene(new Scene(root));
                    ProgressController.stageProgress.initModality(Modality.WINDOW_MODAL);
                    ProgressController.stageProgress.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
                    ProgressController.stageProgress.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //TODO: Поиск контакта.
    public void handleSearch() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ConnectDB.openConnection();
        personList = FXCollections.observableArrayList();

        try {
            ResultSet rs = ConnectDB.connection.createStatement().executeQuery("SELECT * FROM maintabla");
            while (rs.next()) {
                personList.add(new Person(rs.getString("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phone"),
                        rs.getString("country"),
                        rs.getString("city"),
                        rs.getString("address"),
                        rs.getString("indx"),
                        rs.getString("email")));
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }

        columnFirstName.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        tblPersonView.setItems(personList);

        tblPersonView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                        -> showPersonDetails(newValue, lblFirstName, lblLastName, lblPhone,
                        lblCountry, lblCity, lblAddress, lblIndex, lblemail));
    }

    public void showPersonDetails(Person person, Label fName, Label sName, Label lPhone, Label lCountry,
                                  Label lCity, Label lAddress, Label lIndex, Label lEmail) {
        System.out.println("Refresh");
        if (person != null) {
            selectedIndex = Integer.parseInt(person.getId());
            editControllers.setIndexTabla(selectedIndex);
            fName.setText(person.getFirstName());
            sName.setText(person.getLastName());
            lPhone.setText(person.getPhone());
            lCountry.setText(person.getCountry());
            lCity.setText(person.getCity());
            lAddress.setText(person.getAddress());
            lIndex.setText(person.getIndx());
            lEmail.setText(person.getEmail());

            System.out.println(selectedIndex);
        }
    }

    public static void test() {
        System.out.println("Clicked!!!");
    }

    public void statusShowAdd(MouseEvent mouseEvent) {
        lblStatus.setText("Добавить контакт в БД.");
    }

    public void statusHideAdd(MouseEvent mouseEvent) {
        lblStatus.setText("");
    }


    public void statusShowEdit(MouseEvent mouseEvent) {
        lblStatus.setText("Изменить данные контакта.");
    }

    public void statusHideEdit(MouseEvent mouseEvent) {
        lblStatus.setText("");
    }


    public void statusShowDelete(MouseEvent mouseEvent) {
        lblStatus.setText("Удалить контакт из БД.");
    }

    public void statusHideDelete(MouseEvent mouseEvent) {
        lblStatus.setText("");
    }


    public void statusShowPrint(MouseEvent mouseEvent) {
        lblStatus.setText("Распечатать данные контакта.");
    }

    public void statusHidePrint(MouseEvent mouseEvent) {
        lblStatus.setText("");
    }


    public void statusShowSearch(MouseEvent mouseEvent) {

        lblStatus.setText("Поиск контакта в БД.");
        fldSearch.setPromptText("Имя, Фамилия, Телефон...");
    }

    public void statusHideSearch(MouseEvent mouseEvent) {
        lblStatus.setText("");
        fldSearch.setPromptText("");
    }


    public int getSelectedIndex() {
        return selectedIndex;
    }
}


