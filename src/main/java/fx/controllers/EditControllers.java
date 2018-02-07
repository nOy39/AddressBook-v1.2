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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

//TODO Изменить FXML Файл на форму добавления, подсказки к TextField
public class EditControllers {

    @FXML
    public Label labelName;


    ProgressController pg = new ProgressController();
    public static MainControllers mc = new MainControllers();
    public static Constante constante = new Constante();
    public static Stage stage;


    public int indexTabla;

    public int getIndexTabla() {
        return indexTabla;
    }

    public void setIndexTabla(int value) {
        this.indexTabla = value;
    }

    public Person person;

    @FXML
    public TextField fldFirstName;

    @FXML
    private TextField fldLastName;

    @FXML
    private TextField fldPhone;

    @FXML
    private TextField fldCountry;

    @FXML
    private TextField fldCity;

    @FXML
    private TextField fldAddress;

    @FXML
    private TextField fldIndex;

    @FXML
    private TextField fldEmail;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnCancel;

    public void handleSave() {
        System.out.println(indexTabla);
        String querryString = "SET ";
        String updateString = "SET ";
        if (!fldFirstName.getText().equals("")) {
            updateString = updateString + "firstname = \"" + fldFirstName.getText() + "\"";

        }
        if (!fldLastName.getText().equals("")) {
            if (updateString.equals("SET ")) {
                updateString = updateString + "lastname = \"" + fldLastName.getText() + "\"";

            } else {
                updateString = updateString + ", lastname = \"" + fldLastName.getText() + "\"";

            }
        }
        if (!fldPhone.getText().equals("")) {
            if (updateString.equals("SET ")) {
                updateString = updateString + "phone = \"" + fldPhone.getText() + "\"";

            } else {
                updateString = updateString + ", phone = \"" + fldPhone.getText() + "\"";

            }
        }
        if (!fldCountry.getText().equals("")) {
            if (updateString.equals("SET ")) {
                updateString = updateString + "country = \"" + fldCountry.getText() + "\"";

            } else {
                updateString = updateString + ", country = \"" + fldCountry.getText() + "\"";

            }
        }
        if (!fldCity.getText().equals("")) {
            if (updateString.equals("SET ")) {
                updateString = updateString + "city = \"" + fldCity.getText() + "\"";

            } else {
                updateString = updateString + ", city = \"" + fldCity.getText() + "\"";

            }
        }
        if (!fldAddress.getText().equals("")) {
            if (updateString.equals("SET ")) {
                updateString = updateString + "address = \"" + fldAddress.getText() + "\"";

            } else {
                updateString = updateString + ", address = \"" + fldAddress.getText() + "\"";

            }
        }
        if (!fldIndex.getText().equals("")) {
            if (updateString.equals("SET ")) {
                updateString = updateString + "indx = \"" + fldIndex.getText() + "\"";

            } else {
                updateString = updateString + ", indx = \"" + fldIndex.getText() + "\"";

            }
        }
        if (!fldEmail.getText().equals("")) {
            if (updateString.equals("SET ")) {
                updateString = updateString + "email = \"" + fldEmail.getText() + "\"";

            } else {
                updateString = updateString + ", email = \"" + fldEmail.getText() + "\"";

            }
        }


        System.out.println(constante.getIndex());
        String querry = "UPDATE maintabla "+updateString+" WHERE id = "+constante.getIndex();

        CRUD.updateTable(querry);
        handleClear();

    }

    public void handleClear() {

        mc.clear(fldFirstName, fldLastName, fldPhone, fldCountry, fldCity, fldAddress, fldIndex, fldEmail);

    }

    public void handleCancel() {
        mc.stageEdit.close();

    }


    public void showPersonData() {
        ConnectDB.openConnection();


        try {
            ResultSet resultSet = ConnectDB.connection.createStatement().
                    executeQuery("SELECT * FROM maintabla WHERE id =" + indexTabla);
            while (resultSet.next()) {
                person = (new Person(resultSet.getString("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("phone"),
                        resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getString("address"),
                        resultSet.getString("indx"),
                        resultSet.getString("email")));
                System.out.println(person.getFirstName());

            }
        } catch (SQLException e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!");
            System.err.println(e);
        }

/*        fldFirstName.setPromptText(person.getFirstName());
        fldLastName.setPromptText(person.getLastName());
        fldPhone.setPromptText(person.getPhone());
        fldCountry.setPromptText(person.getCountry());
        fldCity.setPromptText(person.getCity());
        fldAddress.setPromptText(person.getAddress());
        fldIndex.setPromptText(person.getIndx());
        fldEmail.setPromptText(person.getEmail());
        */


    }


    //TODO Загрузка изображения
    public void handleImage(ActionEvent actionEvent) {
        {

            try {
                ProgressController.stageProgress = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/progress.fxml"));
                ProgressController.stageProgress.setTitle("Изменить запись.");
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

    public void labelShow() {

    }
}



