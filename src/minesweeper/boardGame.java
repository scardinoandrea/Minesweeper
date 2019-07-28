package minesweeper;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Andrea
 */
public class boardGame {
    private int row;
    private int column;
    private int mines;
    private ArrayList listRow;
    private ArrayList<ArrayList<Integer>> listBoard;
    
    

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getMines() {
        return mines;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }

    public ArrayList getListRow() {
        return listRow;
    }

    public void setListRow(ArrayList listRow) {
        this.listRow = listRow;
    }

    public ArrayList getListBoard() {
        return listBoard;
    }

    public void setListBoard(ArrayList listBoard) {
        this.listBoard = listBoard;
    }
  
    public boardGame(int row, int column, int mines, ArrayList listRow, ArrayList listBoard) {
        this.row = row;
        this.column = column;
        this.mines = mines;
        this.listRow = listRow;
        this.listBoard= listBoard;
    }
    
    public boardGame() {
        this.row = 8; //row;
        this.column = 10;//column;
        this.mines = 10;//mines;
        this.listRow = new ArrayList<Integer>();
        this.listBoard= new ArrayList<ArrayList<Integer>>();
    }
    
    public void createBoard(){
       /* for(int x=0; x<column; x++){
            listRow.add(0);
         }*/
        for(int y=0; y<row; y++){
            ArrayList aux1 = new ArrayList();
            for(int x=0; x<column; x++){
                aux1.add(0);
            }
            listBoard.add(aux1);
        }
        
       /* for(int i=0; i<row; i++){
            System.out.println(listBoard.get(i));
        }
        
        System.out.println(listBoard.get(1).get(2));
        System.out.println(listBoard.get(1).set(2,9));
        System.out.println(listBoard.get(1).get(2));
        
        for(int i=0; i<row; i++){
            System.out.println(listBoard.get(i));
        }*/

        putMines();
        
        for(int i=0; i<row; i++){
            System.out.println(listBoard.get(i));
        }
    }
    
    public void putMines(){
        int leftMines = this.mines; 
        
        while(leftMines>0){
            int[] pos = randomPosition();
            int space = listBoard.get(pos[0]).get(pos[1]);
            
            if(space!=9){
                listBoard.get(pos[0]).set(pos[1],11);
                leftMines --;
            }
        }
    }
    
    public int[] randomPosition(){
        Random rand = new Random();
        int positionx = rand.nextInt(9);
        int positiony = rand.nextInt(7);
        int[] pos = {positionx, positiony};
        return pos;
    }

    public void putNumbers(){
        putMines();
        /* for(int y=0; y<row; y++){
            
            for(int x=0; x<column; x++){
              int bombs=0;
              if  (listBoard.get(x).get(y)!=11){
                bombs= 
                        listBoard.get(x-1).get(y-1)+
                        listBoard.get(x).get(y-1)+
                        listBoard.get(x+1).get(y-1)+
                        listBoard.get(x+1).get(y)+
                        listBoard.get(x+1).get(y+1)+
                        listBoard.get(x).get(y+1)+
                        listBoard.get(x-1).get(y+1)+
                        listBoard.get(x-1).get(y);

                listBoard.get(x).set(y, bombs/11);
              }
            }           
        }*/
    }
}
