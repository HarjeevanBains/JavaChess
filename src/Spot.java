import javafx.scene.shape.*;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

/**
 * Spot.
 *
 * @author Harjeevan Bains
 * @version 2018
 */
public class Spot extends Button implements java.io.Serializable {
public int row;
public int column;
public String color;
public Button button;
public String piece;
public String type;
public String pieceColour;
/**
 * Constructs an object of type Spot.
 * @param row
 * @param column
 * @param colour
 */
public Spot(int column, int row, String color,String piece, String type,String pieceColour) {
    this.row = row;
    this.column = column;
    this.color = color;
    this.setStyle("-fx-font-size: 21px;  -fx-base: " + color + ";");
    this.setMinWidth(50.0);
    this.setMinHeight(50.0);
    this.setMaxWidth(50.0);
    this.setMaxHeight(50.0);
    this.piece = piece;
    this.setText(piece);
    this.type = type;
    this.pieceColour = pieceColour;
}

/**
 * Sets the pieceColour for this Spot.
 * @param pieceColour the pieceColour to set
 */
public void setPieceColour(String pieceColour) {
    this.pieceColour = pieceColour;
}

/**
 * Returns the pieceColour for this Spot.
 * @return the pieceColour
 */
public String getPieceColour() {
    return pieceColour;
}

/**
 * Returns the color for this Spot.
 * @return the color
 */
public String getColor() {
    return color;
}
/**
 * Sets the color for this Spot.
 * @param color the color to set
 */
public void setColor(String color) {
    this.color = color;
}

/**
 * Returns the row for this Spot.
 * @return the row
 */
public int getRow() {
    return row;
}

/**
 * Returns the column for this Spot.
 * @return the column
 */
public int getColumn() {
    return column;
}

/**
 * Sets the pieceColor for this Spot.
 * @param pieceColor the pieceColor to set
 */
public void setPiece(String piece) {
    this.setText(piece);
    this.piece= piece;
}

/**
 * Returns the piece for this Spot.
 * @return the piece
 */
public String getPiece() {
    return piece;
}

public void move() {
    
}

/**
 * Returns the type for this Spot.
 * @return the type
 */
public String getType() {
    return type;
}

/**
 * Sets the type for this Spot.
 * @param type the type to set
 */
public void setType(String type) {
    this.type = type;
}
}
