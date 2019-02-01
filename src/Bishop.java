
/**
 * Bishop.
 *
 * @author Harjeevan Bains
 * @version 2018
 */
public class Bishop extends Pieces implements java.io.Serializable {

    public String typeb;
    public String typew;
    public String type;
    public String colour;

    /**
     * Constructs an object of type Bishop.
     * 
     * @param type
     */
    public Bishop() {
        typew = "\u265D";
        typeb = "\u2657";
        type = "Bishop";
    }

    /**
     * Returns the type for this Pawn.F
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the type for this Bishop.
     * 
     * @return the type
     */
    public String getTypeb() {
        colour = "black";
        return typeb;
    }

    /**
     * Returns the type for this Bishop.
     * 
     * @return the type
     */
    public String getTypew() {
        colour = "white";
        return typew;
    }
    
    public boolean isValid(Spot old, Spot neww) {
        boolean valid=false;
        
        if((neww.getRow()-old.getRow()) == (old.getColumn()-neww.getColumn())) {
            valid = true;
        }
        else if((neww.getRow()-old.getRow()) == (neww.getColumn()-old.getColumn())) {
                valid = true;
            }
            else if((old.getRow()-neww.getRow()) == (old.getColumn()-neww.getColumn())) {
                valid = true;
            }
            
            else if((old.getRow()-neww.getRow()) == (neww.getColumn()-old.getColumn())) {
                valid = true;
            }
        else {
            valid=false;
        }
        return valid;
    }
    
    public boolean isValid3d(Spot old, Spot neww) {
        boolean valid=false;
        
        if((neww.getRow()-old.getRow()) == (old.getColumn()-(neww.getColumn()-8))) {
            valid = true;
        }
        else if((neww.getRow()-old.getRow()) == ((neww.getColumn()-8)-old.getColumn())) {
                valid = true;
            }
            else if((old.getRow()-neww.getRow()) == (old.getColumn()-(neww.getColumn()-8))) {
                valid = true;
            }
            
            else if((old.getRow()-neww.getRow()) == ((neww.getColumn()-8)-old.getColumn())) {
                valid = true;
            }
        else {
            valid=false;
        }
        return valid;
    }
}
