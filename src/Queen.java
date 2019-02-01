
/**
 * Queen.
 *
 * @author Harjeevan Bains
 * @version 2018
 */
public class Queen extends Pieces implements java.io.Serializable {
    public String typeb;
    public String typew;
    public String type;
    public String colour;

    /**
     * Constructs an object of type Queen.
     * 
     * @param type
     */
    public Queen() {
        typew = "\u265B";
        typeb = "\u2655";
        type = "Queen";
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
     * Returns the type for this Queen.
     * 
     * @return the type
     */
    public String getTypeb() {
        colour = "black";
        return typeb;
    }

    /**
     * Returns the type for this Queen.
     * 
     * @return the type
     */
    public String getTypew() {
        colour = "white";
        return typew;
    }

}
