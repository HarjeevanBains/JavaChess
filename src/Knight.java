
/**
 * Knight.
 *
 * @author Harjeevan Bains
 * @version 2018
 */
public class Knight extends Pieces implements java.io.Serializable{
    public String typeb;
    public String typew;
    public String type;
    public String colour;

    /**
     * Constructs an object of type Pawn.
     * 
     * @param type
     */
    public Knight() {
        typew = "\u265E";
        typeb = "\u2658";
        type = "Knight";
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
     * Returns the type for this Knight.
     * 
     * @return the type
     */
    public String getTypeb() {
        colour = "black";
        return typeb;
    }

    /**
     * Returns the type for this Knight.
     * 
     * @return the type
     */
    public String getTypew() {
        colour = "white";
        return typew;
    }

    public boolean isValid(Spot old, Spot neww) {
        boolean valid = false;
        if ((neww.getColumn() - old.getColumn() == 1)
                && (neww.getRow() - old.getRow() == 2)) {
            valid = true;
        } else if ((neww.getColumn() - old.getColumn() == -1)
                && (neww.getRow() - old.getRow() == -2)) {
            valid = true;
        }

        else if ((neww.getColumn() - old.getColumn() == 1)
                && (neww.getRow() - old.getRow() == -2)) {
            valid = true;
        } else if ((neww.getColumn() - old.getColumn() == -1)
                && (neww.getRow() - old.getRow() == 2)) {
            valid = true;
        }

        else if ((neww.getColumn() - old.getColumn() == 2)
                && (neww.getRow() - old.getRow() == 1)) {
            valid = true;
        } else if ((neww.getColumn() - old.getColumn() == -2)
                && (neww.getRow() - old.getRow() == -1)) {
            valid = true;
        }

        else if ((neww.getColumn() - old.getColumn() == 2)
                && (neww.getRow() - old.getRow() == -1)) {
            valid = true;
        } else if ((neww.getColumn() - old.getColumn() == -2)
                && (neww.getRow() - old.getRow() == 1)) {
            valid = true;
        }

        else {
            valid = false;
        }
        return valid;
    }

}
