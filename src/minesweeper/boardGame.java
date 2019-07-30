package minesweeper;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Andrea
 * 
 * This class is to create the board of the game. It includes put the bombs in 
 * random positions and fill the rest of the board with the numbers that refer
 * to the amount of bombs around them.
 */
public class boardGame {

    private int row; //number of rows of the board
    private int column; //number of columns of the board
    private int mines; //number of mines of the game 
    private ArrayList<ArrayList<Integer>> listBoard; //the board is made with a list of lists instead of vectors
      
    /*
    Getters & Setters
    */
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

    public ArrayList getListBoard() {
        return listBoard;
    }

    public void setListBoard(ArrayList listBoard) {
        this.listBoard = listBoard;
    }
  
    /*
    Constructor
    */
    public boardGame(int row, int column, int mines, ArrayList listBoard) {
        this.row = row;
        this.column = column;
        this.mines = mines;
        this.listBoard= listBoard;
    }
    
    /*
    Initial value of variables
    */
    public boardGame() {
        this.row = 8; //row;
        this.column = 10;//column;
        this.mines = 10;//mines;
        this.listBoard= new ArrayList<ArrayList<Integer>>();
    }
    
    /*
    This fuction creates the board of the game, with its bombs and numbers
    */
    public void createBoard(){
        /*
        Here the board is filled with others list, every new list is a new row.
        The lists are filled with 0 to get a base for the board.     
        */
        for(int y=0; y<row; y++){
            ArrayList auxList = new ArrayList();
            for(int x=0; x<column; x++){
                auxList.add(0);
            }
            listBoard.add(auxList);
        }

        //With this two fuctions the board is filled
        putMines();
        putNumbers();
        
        //To print the board in console
        for(int i=0; i<row; i++){
            System.out.println(listBoard.get(i));
        }
    }
    
    /*
    This fuction is used to generate a random position for the bombs
    */
    public int[] randomPosition(){
        Random rand = new Random();
        //get a random number between 0-9
        int positionx = rand.nextInt(9);
        //get a random number between 0-7
        int positiony = rand.nextInt(7);
        //Return a vector with the posible position of the bomb
        int[] pos = {positionx, positiony};
        return pos;
      }

    /*
    This fuction put the mines in the board. It's important to know that bombs
    are represented with "11" and empty spaces with "0"
    */
    public void putMines(){
        //Get the mines that are required in the game
        int leftMines = this.mines; 
        /*This loop get the posible position of the bomb from randomPosition(),
        evaluates if in that position doesn't exist a bomb and if not let the bomb
        there; if there is already a bomb it search for another position.
        */
        while(leftMines>0){
            int[] pos = randomPosition();  
            //This variable gets the value of the position
            int space = listBoard.get(pos[1]).get(pos[0]);
            //if space disfferent from 11(bomb) you can let the bomb here
            if(space!=11){
                listBoard.get(pos[1]).set(pos[0],11);
                leftMines --;   
            }
        }
    }
    
    /*
    This fuction put the numbers that are around the bombs. Those represents the 
    amount of mines that every box touchs
    */
    public void putNumbers(){
        /*
        This loop read the matriz of lists to sum the bombs that are around of 
        every box. Its sum the values around the boxes and in the end it's 
        divided by 11 to get the final amount of box
        */
        for(int y=0; y<row; y++){        
            for(int x=0; x<column; x++){
              int bombs=0;
              if  (listBoard.get(y).get(x)!=11){

                for(int i=y-1; i<y+2;i++){
                       for(int j=x-1;j<x+2;j++){
                           if(i>=0 && i<row && j>=0 && j<column){
                               bombs += listBoard.get(i).get(j);
                           }
                       }
                   }

                   listBoard.get(y).set(x, bombs/11);

                 }
            }           
        }
    }
}
