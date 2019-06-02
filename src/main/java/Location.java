public class Location {

    private int row;
    private int col;



    public Location(int row, int col){
        this.row = row;
        this.col = col;
    }




    /**
     * Return a string of the form row,column
     *
     * @return A string representation of the location.
     */
    public String toString() {
        return row + "," + col;
    }


    public int getRow() {
        return row;
    }


    /**
     * @return The column.
     */
    public int getCol() {
        return col;
    }
}
