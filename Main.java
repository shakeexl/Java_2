package com.geekbrains.chat.client;

/*
Не смотря на возможность сборщика Maven, только зависимостей не хватило.
Пришлось еще скачать javafx-sdk и добавить VM-options. Помогла эта инструкция:
        https://www.jetbrains.com/help/idea/javafx.html#top
        */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/sample.fxml")));
        primaryStage.setTitle("Messenger");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
