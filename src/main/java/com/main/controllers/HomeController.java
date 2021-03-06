package com.main.controllers;


import com.Laboratory.controllers.LabScreens;
import com.PharmacyMgt.Controllers.PharmacyScreens;
import com.common.*;
import com.employeemanagement.controllers.MyScreens;
import com.financemanagement.controllers.FinanceScreens;
import com.main.Main;
import com.patientmanagement.controllers.PatientScreens;
import com.suppliermanagement.controllers.SupplierScreens;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements ControlledScreen, Initializable,SessionListener{

    private Session session;

    ScreenController controller;

    @FXML
    private Button closebtn;

    @FXML
    private Button patientBtn;

    @FXML
    private GridPane pane;

    @FXML
    private Button supplierBtn;

    @FXML
    private Button labBtn;

    @FXML
    private Button adminBtn;

    @FXML
    private Button pharmacyBtn;

    @FXML
    private Button employeeBtn;

    @Override
    public void setScreenParent(ScreenController screenParent) {
        controller = screenParent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        translateXY(-300, 0, patientBtn);
        translateXY(300, 0, supplierBtn);
        translateXY(160, 280, labBtn);
        translateXY(-160, -280, adminBtn);
        translateXY(160, -280, pharmacyBtn);
        translateXY(-160, 280, employeeBtn);
        translateXY(0, 120, closebtn);
    }

    @FXML
    public void closeWindow(ActionEvent actionEvent){
        Stage s = (Stage) patientBtn.getScene().getWindow();
        Main.createLogin(new Stage());
        s.close();
    }

    private void translateXY(double x, double y, Node node){

        TranslateTransition translate = new TranslateTransition();
        ScaleTransition scale =  new ScaleTransition();
        FadeTransition fade = new FadeTransition();

        translate.setDuration(Duration.seconds(1.7));
        translate.setNode(node);
        scale.setDuration(Duration.seconds(1.7));
        scale.setNode(node);
        fade.setDuration(Duration.seconds(1.5));
        fade.setNode(node);
        scale.setFromX(0.1);
        scale.setFromY(0.1);
        scale.setToX(1);
        scale.setToY(1);
        fade.setFromValue(0.5);
        fade.setToValue(1);

        if(y != 0)
            translate.setToY(y);
        if(x != 0)
            translate.setToX(x);

        ParallelTransition parallelTransition =  new ParallelTransition(translate, fade);
        parallelTransition.play();

    }

    @FXML
    public void openWindow(ActionEvent event){

        switch (((Button)event.getSource()).getId()){

            case "adminBtn":
                ScreenController.changeScreen(controller, MainScreens.HOME_SCREEN, FinanceScreens.MAIN_DASHBOARD_SCREEN);
                break;

            case "patientBtn":
                ScreenController.changeScreen(controller, MainScreens.HOME_SCREEN, PatientScreens.MAIN_DASHBOARD_SCREEN);
                break;

            case "supplierBtn":
                ScreenController.changeScreen(controller, MainScreens.HOME_SCREEN, SupplierScreens.DASHBOARD_SCREEN);
                break;

            case "labBtn":
                ScreenController.changeScreen(controller, MainScreens.HOME_SCREEN, LabScreens.DASHBOARD_SCREEN);
                break;

            case "employeeBtn":
                ScreenController.changeScreen(controller, MainScreens.HOME_SCREEN, MyScreens.MAIN_SCREEN);
                //loadEmployeeManagement();
                break;

            case "pharmacyBtn":
                ScreenController.changeScreen(controller, MainScreens.HOME_SCREEN, PharmacyScreens.DASHBOARD_SCREEN);
                break;
        }
    }


    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void setMainController(SessionListener controller) {

    }


}
