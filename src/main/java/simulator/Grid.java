package simulator;

import room.Room;
import room.RoomFactory;

import java.util.Random;

public class Grid {
    private Room[][] grid;
    private int nRow;
    private int nCol;


    public Grid(int nRow, int nCol){

        this.nCol = nCol;
        this.nRow = nRow;
        grid = new Room[nRow][nCol];
        Random rand = new Random();

        for (int i=0; i<nRow; i++){
            int t = rand.nextInt(nCol);
            for (int j=0; j<nCol; j++){
                grid[i][j] = RoomFactory.createRoom();
                if(j==t){
                    RoomFactory.setTreasure(grid[i][j]);
                }
            }
        }

    }

    public Room getRoomAt(int row, int col){

        if(row >= 0 && row < nRow && col >=0 && col < nCol){
            return grid[row][col];
        }
        return null;

    }

    public int getnRow(){
        return nRow;
    }

    public int getnCol(){
        return nCol;
    }
}
