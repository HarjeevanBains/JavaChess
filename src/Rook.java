
/**
 * Rook.
 *
 * @author Harjeevan Bains
 * @version 2018
 */
public class Rook extends Pieces implements java.io.Serializable{
    public String typeb;
    public String typew;
    public String type;
    public String colour;

    /**
     * Constructs an object of type Rook.
     * 
     * @param type
     */
    public Rook() {
        typew = "\u265C";
        typeb = "\u2656";
        type = "Rook";
    }
    /**
     * Returns the type for this Pawn.
     * @return the type
     */
    public String getType() {
        return type;
    }
    /**
     * Returns the type for this Rook.
     * 
     * @return the type
     */
    public String getTypeb() {
        colour = "black";
        return typeb;
    }

    /**
     * Returns the type for this Rook.
     * 
     * @return the type
     */
    public String getTypew() {
        colour = "white";
        return typew;
    }
    
    public boolean isValid(Spot old, Spot neww) {
        boolean valid=false;
            if(neww.getRow()==old.getRow()) {
                valid = true;
            }
            else if(neww.getColumn()==old.getColumn()) {
                valid = true;
            }
        else {
            valid=false;
        }
        return valid;
    }
    
    public boolean isValid3d(Spot old, Spot neww) {
        boolean valid=false;
            if((neww.getRow()==(old.getRow() + 8)) ||  (neww.getRow()==(old.getRow() + 16))){
                valid = true;
            }
            else if((neww.getColumn()==(old.getColumn()+8)) || (neww.getColumn()==(old.getColumn()+16))){
                valid = true;
            }
            else if((neww.getColumn()==(old.getColumn()-8)) || (neww.getColumn()==(old.getColumn()-16))){
                valid = true;
            }
            else if((neww.getRow()==(old.getRow() - 8)) ||  (neww.getRow()==(old.getRow() - 16))){
                valid = true;
            }
        else {
            valid=false;
        }
        return valid;
    }
    
    public boolean spacesNullRow(Spot old, Spot neww, Spot[][] spaces) { //for vertical 
        boolean yes = false;
        
        for(int i = neww.getRow()-1; i==old.getRow()+1; i--) {//top-down
            if(spaces[neww.getColumn()-1][i-1].getType()==null) {
                yes = true;
            }
            else {
                yes = false;
                break;
            }    
        }
        
        if(yes=false) {
        for(int i = neww.getRow()+1; i==old.getRow()-1; i++) {//down-top
            if(spaces[neww.getColumn()-1][i-1].getType()==null) {
                yes = true;
            }
            else {
                yes = false;
                break;
            }    
        }
        }
        return yes;
    }
    
    
    
    
    public boolean spacesNullColumn(Spot old, Spot neww, Spot[][] spaces) {
        boolean yes = false;
        
        for(int i = neww.getColumn()-1; i==old.getColumn()+1; i--) {
            if(spaces[i-1][neww.getRow()-1].getType()==null) {
                yes = true;
            }
            else {
                yes = false;
                break;
            }    
        }
        
        if(yes=false) {
        for(int i = neww.getRow()+1; i>old.getRow()-1; i--) {
            if(spaces[i-1][neww.getRow()-1].getType()==null) {
                yes = true;
            }
            else {
                yes = false;
                break;
            }    
        }
        }
        return yes;
    }
    
    
}
