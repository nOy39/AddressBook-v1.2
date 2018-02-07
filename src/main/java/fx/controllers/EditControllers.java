package fx.controllers;

import helpers.CRUD;
import helpers.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

//TODO Изменить FXML Файл на форму добавления, подсказки к TextField
public class EditControllers {


    @FXML
    public Label testLabel = new Label("jdhfjdfk");

    ProgressController pg = new ProgressController();
    MainControllers mc = new MainControllers();
    public static Stage stage;

    @FXML
    private Label labelFirstName = new Label("dlfjdklf");
    @FXML
    private Label labelLastName;
    @FXML
    private Label labelPhone;
    @FXML
    private Label labelCountry;
    @FXML
    private Label labelCity;
    @FXML
    private Label labelAddress;
    @FXML
    private Label labelIndex;
    @FXML
    private Label labelEmail;


    @FXML
    private TextField fldFirstName;

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
    private Button btnImage;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnCancel;

    public void handleSave() {
        CRUD.saveToBase(fldFirstName.getText(), fldLastName.getText(), fldPhone.getText(), fldCountry.getText(),
                fldCity.getText(), fldAddress.getText(), fldIndex.getText(), fldEmail.getText());
        handleClear();

    }

    public void handleClear() {

        mc.clear(fldFirstName, fldLastName, fldPhone, fldCountry, fldCity, fldAddress, fldIndex, fldEmail);

    }

    public void handleCancel() {
        mc.stageEdit.close();

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

}



