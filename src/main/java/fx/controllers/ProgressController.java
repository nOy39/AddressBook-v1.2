package fx.controllers;

import javafx.stage.Stage;

import java.awt.*;

public class ProgressController {

    public static Stage stageProgress;

    private Button btnOK;

    public void handleOk() {
        stageProgress.close();
    }

    }

