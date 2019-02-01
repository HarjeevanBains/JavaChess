import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Game.
 *
 * @author Harjeevan Bains
 * @version 2018
 */
public class Game extends Application {
    public Board board;
    public Board3d board3d;
    public void start(Stage primaryStage) {
        board3d = new Board3d();
        board = new Board();
        Button save = new Button();
        Button load = new Button();
        save.setText("save");
        load.setText("load");
       // board.add(save, 5, 9, 2, 1);
        //board.add(load, 7, 9, 2, 1);
        save.setOnAction(this::processSavePress);
        load.setOnAction(this::processLoadPress);
        Scene scene = new Scene(board);

        primaryStage.setTitle("Chess Board");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the JavaFX application.
     * 
     * @param args
     *            command line arguments
     */

    public static void main(String[] args) {
        launch(args);

    }


    public void processSavePress(ActionEvent event) {
        try {
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\harje\\eclipse-workspace\\Comp2526_A2a\\tmp\\board.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(board);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in C:\\Users\\harje\\eclipse-workspace\\Comp2526_A2a\\tmp\\board.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void processLoadPress(ActionEvent event) {
       try {
            Board newBoard = null;
            FileInputStream fileIn = new FileInputStream("C:\\Users\\harje\\eclipse-workspace\\Comp2526_A2a\\tmp\\board.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            newBoard = (Board) in.readObject();
            board = newBoard;
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Board not found");
            c.printStackTrace();
            return;
        }
    }
}
