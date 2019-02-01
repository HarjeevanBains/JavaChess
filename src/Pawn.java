
/**
 * Pawn.
 *
 * @author Harjeevan Bains
 * @version 2018
 */
public class Pawn extends Pieces implements java.io.Serializable {

    public String typeb;
    public String typew;
    public String type;
    public String colour;

    /**
     * Constructs an object of type Pawn.
     * 
     * @param type
     */
    public Pawn() {
        typew = "\u265F";
        typeb = "\u2659";
        type = "Pawn";
    }

    /**
     * Returns the type for this Pawn.
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the type for this Pawn.
     * 
     * @return the type
     */
    public String getTypeb() {
        colour = "black";
        return typeb;
    }

    /**
     * Returns the type for this Pawn.
     * 
     * @return the type
     */
    public String getTypew() {
        colour = "white";
        return typew;
    }

    /**
     * @return
     */
    public boolean isValidFirst(Spot old, Spot neww) {
        boolean valid = false;
        if (old.getPieceColour() == "black") {
            if ((old.getColumn() == neww.getColumn())
                    && ((neww.getRow() - old.getRow() == 1)
                            || (neww.getRow() - old.getRow() == 2))
                    && (neww.getPiece() == null)) {
                valid = true;
            }
        } else if (old.getPieceColour() == "white") {
            if ((old.getColumn() == neww.getColumn())
                    && ((neww.getRow() - old.getRow() == -1)
                            || (neww.getRow() - old.getRow() == -2))
                    && (neww.getPiece() == null)) {
                valid = true;
            }
        }
        return valid;
    }

    public boolean isValid(Spot old, Spot neww) {
        boolean valid = false;
        if (old.getPieceColour() == "black") {
            if ((old.getColumn() == neww.getColumn())
                    && (neww.getRow() - old.getRow() == 1)
                    && (neww.getPiece() == null)) {
                valid = true;
            } else if ((old.getColumn() - neww.getColumn() == 1)
                    && (neww.getRow() - old.getRow() == 1)
                    && (neww.getPieceColour() == "white")) {
                valid = true;
            } else if ((old.getColumn() - neww.getColumn() == -1)
                    && (neww.getRow() - old.getRow() == 1)
                    && (neww.getPieceColour() == "white")) {
                valid = true;
            }
        } else if (old.getPieceColour() == "white") {
            if ((old.getColumn() == neww.getColumn())
                    && (neww.getRow() - old.getRow() == -1)
                    && (neww.getPiece() == null)) {
                valid = true;
            } else if ((old.getColumn() - neww.getColumn() == 1)
                    && (neww.getRow() - old.getRow() == -1)
                    && (neww.getPieceColour() == "black")) {
                valid = true;
            } else if ((old.getColumn() - neww.getColumn() == -1)
                    && (neww.getRow() - old.getRow() == -1)
                    && (neww.getPieceColour() == "black")) {
                valid = true;
            }
        }

        return valid;
    }

    public boolean isValidFirst3d(Spot old, Spot neww) {
        boolean valid = false;
        if (old.getPieceColour() == "black") {
            if (((old.getColumn() + 8) == neww.getColumn())
                    || ((old.getColumn() + 16) == neww.getColumn())
                            && ((neww.getRow() - old.getRow() == 1)
                                    || (neww.getRow() - old.getRow() == 2))) {
                valid = true;
            }
        } else if (old.getPieceColour() == "white") {
            if (((old.getColumn() + 8) == neww.getColumn())
                    || ((old.getColumn() + 16) == neww.getColumn())
                            && ((neww.getRow() - old.getRow() == -1)
                                    || (neww.getRow() - old.getRow() == -2))) {
                valid = true;
            }
        }
        return valid;
    }

    public boolean isValid3d(Spot old, Spot neww) {
        boolean valid = false;
        if (old.getPieceColour() == "black") {
            if (((old.getColumn() + 8) == neww.getColumn())
                    || ((old.getColumn() + 16) == neww.getColumn())
                    || ((old.getColumn() - 8) == neww.getColumn())
                    || ((old.getColumn() - 16) == neww.getColumn())
                            && ((neww.getRow() - old.getRow() == 1))) {
                valid = true;
            }
        } else if (old.getPieceColour() == "white") {
            if (((old.getColumn() + 8) == neww.getColumn())
                    || ((old.getColumn() + 16) == neww.getColumn())
                    || ((old.getColumn() - 8) == neww.getColumn())
                    || ((old.getColumn() - 16) == neww.getColumn())
                            && ((neww.getRow() - old.getRow() == -1))) {
                valid = true;
            }
        }
        return valid;
    }
}
