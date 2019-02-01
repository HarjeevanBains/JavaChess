
/**
 * King.
 *
 * @author Harjeevan Bains
 * @version 2018
 */
public class King extends Pieces implements java.io.Serializable{
    public String typeb;
    public String typew;
    public String type;
    public String colour;

    /**
     * Constructs an object of type Pawn.
     * 
     * @param type
     */
    public King() {
        typew = "\u265A";
        typeb = "\u2654";
        type = "King";
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
     * Returns the type for this King.
     * 
     * @return the type
     */
    public String getTypeb() {
        colour = "black";
        return typeb;
    }

    /**
     * Returns the type for this King.
     * 
     * @return the type
     */
    public String getTypew() {
        colour = "white";
        return typew;
    }
    
    public boolean isValid(Spot old, Spot neww) {
        boolean valid=false;
            if((neww.getRow()==old.getRow()) && ((neww.getColumn()-old.getColumn() == 1) || (neww.getColumn()-old.getColumn() == -1))) {
                valid = true; //side to side
            }
            else if((neww.getColumn()==old.getColumn()) && ((neww.getRow()-old.getRow() == 1) || (neww.getRow()-old.getRow() == -1))) {
                valid = true; //up and down
            }
            else if(((neww.getColumn()-old.getColumn() == 1) || (neww.getColumn()-old.getColumn() == -1)) && ((neww.getRow()-old.getRow() == 1) || (neww.getRow()-old.getRow() == -1))) {
                valid = true;//Diagonal
            }
        else {
            valid=false;
        }
        return valid;
    }

}
