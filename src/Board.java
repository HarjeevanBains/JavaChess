import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;

/**
 * Board.
 *
 * @author Harjeevan Bains
 * @version 2018
 */
public class Board extends GridPane implements java.io.Serializable {
    public int column;
    public int row;
    public String color;
    int clicks = 1;
    public Spot Ospot;
    public Spot Nspot;
    public transient Text turn = new Text();
    public transient Text invalid = new Text();
    public Spot[][] spaces = new Spot[8][8];
    public Bishop bishop = new Bishop();
    public King king = new King();
    public Knight knight = new Knight();
    public Pawn pawn = new Pawn();
    public Queen queen = new Queen();
    public Rook rook = new Rook();
    public int maxRow = 8;
    public int maxColumn = 8;


    public Board() {
        turn.setText("turn: black");
        invalid.setText(" ");;
        this.add(turn, 1, 9, 2, 1);
        this.add(invalid, 3, 9, 2, 1);
        for (row = 1; row <= maxRow; row++) {
            for (column = 1; column <= maxColumn; column++) {
                if (row % 2 == 0) {
                    if (column % 2 == 0) {
                        color = "#ff0000";
                        setBoard(this);
                        this.add(spaces[column - 1][row - 1], column, row, 1,
                                1);
                        spaces[column - 1][row - 1]
                                .setOnAction(this::processButtonPress);
                    } else {
                        color = "#000000";
                        setBoard(this);
                        this.add(spaces[column - 1][row - 1], column, row, 1,
                                1);
                        spaces[column - 1][row - 1]
                                .setOnAction(this::processButtonPress);
                    }
                } else {
                    if (column % 2 == 0) {
                        color = "#000000";
                        setBoard(this);
                        this.add(spaces[column - 1][row - 1], column, row, 1,
                                1);
                        spaces[column - 1][row - 1]
                                .setOnAction(this::processButtonPress);
                    } else {
                        color = "#ff0000";
                        setBoard(this);
                        this.add(spaces[column - 1][row - 1], column, row, 1,
                                1);
                        spaces[column - 1][row - 1]
                                .setOnAction(this::processButtonPress);
                    }
                }
            }
        }
    }

    public void setBoard(Board b) {
        if (row == 2) {
            spaces[column - 1][row - 1] = new Spot(column, row, color,
                    pawn.getTypeb(), "Pawn", "black");
        } else if (row == 7) {
            spaces[column - 1][row - 1] = new Spot(column, row, color,
                    pawn.getTypew(), "Pawn", "white");
        }

        else if ((row == 1) && (column == 1 || column == 8)) {
            spaces[column - 1][row - 1] = new Spot(column, row, color,
                    rook.getTypeb(), "Rook", "black");

        } else if ((row == 8) && (column == 1 || column == 8)) {
            spaces[column - 1][row - 1] = new Spot(column, row, color,
                    rook.getTypew(), "Rook", "white");

        }

        else if ((row == 1) && (column == 2 || column == 7)) {
            spaces[column - 1][row - 1] = new Spot(column, row, color,
                    knight.getTypeb(), "Knight", "black");

        } else if ((row == 8) && (column == 2 || column == 7)) {
            spaces[column - 1][row - 1] = new Spot(column, row, color,
                    knight.getTypew(), "Knight", "white");

        }

        else if ((row == 1) && (column == 3 || column == 6)) {
            spaces[column - 1][row - 1] = new Spot(column, row, color,
                    bishop.getTypeb(), "Bishop", "black");

        } else if ((row == 8) && (column == 3 || column == 6)) {
            spaces[column - 1][row - 1] = new Spot(column, row, color,
                    bishop.getTypew(), "Bishop", "white");

        }

        else if ((row == 1) && (column == 4)) {
            spaces[column - 1][row - 1] = new Spot(column, row, color,
                    queen.getTypeb(), "Queen", "black");

        } else if ((row == 8) && (column == 4)) {
            spaces[column - 1][row - 1] = new Spot(column, row, color,
                    queen.getTypew(), "Queen", "white");

        }

        else if ((row == 1) && (column == 5)) {
            spaces[column - 1][row - 1] = new Spot(column, row, color,
                    king.getTypeb(), "King", "black");

        } else if ((row == 8) && (column == 5)) {
            spaces[column - 1][row - 1] = new Spot(column, row, color,
                    king.getTypew(), "King", "white");

        }

        else {
            spaces[column - 1][row - 1] = new Spot(column, row, color, null,
                    null, null);

        }
    }

    public boolean isValid(Spot old, Spot neww) {
        boolean valid;
        String type = old.getType();
        if (old.getPieceColour() == neww.getPieceColour()) {
            valid = false;
        } else if (old.getType() == null) {
            valid = false;
        } else if (old == neww) {
            valid = false;
        }

        else if (type == "Pawn") {
            if (old.getPieceColour() == "black" && old.getRow() == 2) {
                valid = pawn.isValidFirst(old, neww);
            } else if (old.getPieceColour() == "white" && old.getRow() == 7) {
                valid = pawn.isValidFirst(old, neww);
            } else {
                valid = pawn.isValid(old, neww);
            }
        } else if (type == "Rook") {
            valid = ((rook.isValid(old, neww)) || ((rook.spacesNullColumn(old,neww,spaces)) || (rook.spacesNullRow(old,neww,spaces))));
        } else if (type == "Knight") {
            valid = knight.isValid(old, neww);
        } else if (type == "King") {
            valid = king.isValid(old, neww);
        } else if (type == "Bishop") {
            valid = bishop.isValid(old, neww);
        } else if (type == "Queen") {
            valid = (bishop.isValid(old, neww)
                    || rook.isValid(old, neww));
        }

        else {
            valid = true;
        }
        return valid;
    }

    public void processButtonPress(ActionEvent event) {
        if (clicks == 1) {
            Ospot = ((Spot) event.getSource());
            clicks++;
        } else if (clicks == 2) {
            Nspot = ((Spot) event.getSource());
            if ((isValid(Ospot, Nspot)) && turn.getText() == "turn: black"
                    && Ospot.getPieceColour() == "black") {
                spaces[Nspot.getColumn() - 1][Nspot.getRow() - 1]
                        .setType(Ospot.getType());
                spaces[Nspot.getColumn() - 1][Nspot.getRow() - 1]
                        .setPiece(Ospot.getPiece());
                spaces[Nspot.getColumn() - 1][Nspot.getRow() - 1]
                        .setPieceColour(Ospot.getPieceColour());
                spaces[Ospot.getColumn() - 1][Ospot.getRow() - 1].setType(null);
                spaces[Ospot.getColumn() - 1][Ospot.getRow() - 1]
                        .setPiece(null);
                spaces[Ospot.getColumn() - 1][Ospot.getRow() - 1]
                        .setPieceColour(null);
                clicks--;
                turn.setText("turn: white");
                invalid.setText(" ");
            } else if ((isValid(Ospot, Nspot))
                    && turn.getText() == "turn: white"
                    && Ospot.getPieceColour() == "white") {
                spaces[Nspot.getColumn() - 1][Nspot.getRow() - 1]
                        .setType(Ospot.getType());
                spaces[Nspot.getColumn() - 1][Nspot.getRow() - 1]
                        .setPiece(Ospot.getPiece());
                spaces[Nspot.getColumn() - 1][Nspot.getRow() - 1]
                        .setPieceColour(Ospot.getPieceColour());
                spaces[Ospot.getColumn() - 1][Ospot.getRow() - 1].setType(null);
                spaces[Ospot.getColumn() - 1][Ospot.getRow() - 1]
                        .setPiece(null);
                spaces[Ospot.getColumn() - 1][Ospot.getRow() - 1]
                        .setPieceColour(null);
                clicks--;
                turn.setText("turn: black");
                invalid.setText(" ");
            } else {
                invalid.setText("invalid move");
                clicks--;
            }
        }
    }
}
