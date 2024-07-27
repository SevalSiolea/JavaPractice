package MiniProject.MineSweeper;

import MiniProject.MineSweeper.Enum.Difficulty;
import MiniProject.MineSweeper.Enum.Result;

public class Game {


    /**===============================================================================**/
    /**================================ private field ================================**/
    /**===============================================================================**/


    private final Difficulty difficulty;
    private final Grid grid;
    private Result result;


    /**=============================================================================**/
    /**================================ constructor ================================**/
    /**=============================================================================**/


    public Game( Difficulty difficulty ) {
        assert difficulty != Difficulty.CUSTOMIZED;

        this.difficulty = difficulty;
        this.grid = new Grid( this.difficulty.getRow(), this.difficulty.getCol(), this.difficulty.getMineCount() );
        this.result = Result.CONTINUE;
    }

    public Game( Difficulty difficulty, int row, int col, int mineCount ) {
        assert difficulty == Difficulty.CUSTOMIZED;

        this.difficulty = difficulty;
        this.grid = new Grid( row, col, mineCount );
        this.result = Result.CONTINUE;
    }


    /**===============================================================================**/
    /**================================ public method ================================**/
    /**===============================================================================**/


    public void playGame() {
        do {
            this.grid.printGrid();
            System.out.print( "Enter an operation : " );
            operate();
            judgeResult();
        } while( result == Result.CONTINUE );
        endGame();
    }


    /**================================================================================**/
    /**================================ private method ================================**/
    /**================================================================================**/


    private void operate() {

        java.util.Scanner scanner = new java.util.Scanner( System.in );

        String command = scanner.nextLine();
        if( command.equals( "Restart a new game" ) ) {
            result = Result.RESTART;
            return;
        } else if( command.equals( "End game" ) ) {
            result = Result.End;
            return;
        }
        String[] commands = command.split( " " );

        String operation = commands[ 0 ];
        int row = Integer.parseInt( commands[ 1 ] );
        int col = Integer.parseInt( commands[ 2 ] );
        if( operation.equals( "click" ) )
            grid.click( row, col );
        else if( operation.equals( "mark" ) )
            grid.mark( row, col );
        else
            throw new RuntimeException( "Please enter right input!" );

    }

    private void judgeResult() {
        if( this.grid.getMeetMine() )
            this.result = Result.LOSE;
        if( this.grid.getFlagCount() == this.grid.getMineCount() )
            this.result = Result.WIN;
        if( this.grid.getClicked() + this.grid.getMineCount() == this.grid.getRow() * this.grid.getCol() )
            this.result = Result.WIN;
    }

    private void endGame() {
        if( result != Result.RESTART && result != Result.End ) {
            this.grid.displayMines();
            this.grid.printGrid();
            System.out.println( this.result.getMessage() );
        }
    }


}