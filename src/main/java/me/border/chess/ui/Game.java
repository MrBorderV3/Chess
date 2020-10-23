package me.border.chess.ui;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 */
public class Game extends Application {

    private static Game instance;

    private static Board board;

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public static Board getBoard() {
        return board;
    }

    public static Game getInstance(){
        return instance;
    }
}
