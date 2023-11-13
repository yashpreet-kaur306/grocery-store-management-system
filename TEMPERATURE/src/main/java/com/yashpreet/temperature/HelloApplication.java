package com.yashpreet.temperature;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0, menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setTitle("Temperature Convertor Tool");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuBar createMenu() {
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));
        MenuItem quitMenuItem = new MenuItem("Quit");
        quitMenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newMenuItem, quitMenuItem, separatorMenuItem);


        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");

        aboutApp.setOnAction(actionEvent -> aboutApp());
        helpMenu.getItems().addAll(aboutApp);


        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;

    }

    private static void aboutApp(){
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop App");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText("I am just a beginner");

        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

        if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
            System.out.println("Yes Button Clicked");
        }
        if(clickedBtn.isPresent() && clickedBtn.get() == noBtn){
            System.out.println("No Button Clicked");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}