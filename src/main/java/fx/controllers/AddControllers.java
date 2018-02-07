package fx.controllers;

import helpers.CRUD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AddControllers {
    MainControllers mc = new MainControllers();
    ProgressController pg = new ProgressController();


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
    private Button btnSave;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnCancel;

    public void handleSave() {
        CRUD.saveToBase(fldFirstName.getText(),fldLastName.getText(),fldPhone.getText(),fldCountry.getText(),
                fldCity.getText(),fldAddress.getText(),fldIndex.getText(),fldEmail.getText());
        handleClear();
        MainControllers mc = new MainControllers();
    }

    public void handleClear() {
        mc.clear(fldFirstName,fldLastName,fldPhone,fldCountry,fldCity,fldAddress,fldIndex,fldEmail);
    }

    public void handleCancel() {

        mc.stageAdd.close();

    }

    //TODO Загрузка изображения по клику изображения
    public void handleImage(ActionEvent actionEvent) {
        System.out.println("IN PROGRESS");

            try {
                ProgressController.stageProgress = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/progress.fxml"));
                ProgressController.stageProgress.setTitle("В разработке");
                ProgressController.stageProgress.setMinHeight(400);
                ProgressController.stageProgress.setMinWidth(200);
                ProgressController.stageProgress.setResizable(false);
                ProgressController.stageProgress.setScene(new Scene(root));
                ProgressController.stageProgress.initModality(Modality.WINDOW_MODAL);
                ProgressController.stageProgress.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
                ProgressController.stageProgress.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


