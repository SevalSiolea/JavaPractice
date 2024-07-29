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

        String command = scanner.nextLine().trim().toLowerCase();
        if( command.equals( "restart a new game" ) || command.equals( "r" ) ) {
            result = Result.RESTART;
            return;
        } else if( command.equals( "end game" ) || command.equals( "e" )) {
            result = Result.End;
            return;
        }
        String[] commands = command.split( " " );

        for( int i=0; i<commands.length; i++ ) {
            if( commands[ i ].equals( "click" ) || commands[ i ].equals( "mark" ) || commands[ i ].equals( "c" ) || commands[ i ].equals( "m" )) {
                String operation = commands[ i ];
                while( i+1 < commands.length && !commands[ i+1 ].equals( "click" ) && !commands[ i+1 ].equals( "mark" ) && !commands[ i+1 ].equals( "c" ) && !commands[ i+1 ].equals( "m" ) ) {
                    int row = Integer.parseInt( commands[ ++i ] );
                    int col = Integer.parseInt( commands[ ++i ] );
                    if( operation.equals( "click" ) || operation.equals( "c" ) )
                        grid.click( row, col );
                    else if( operation.equals( "mark" ) || operation.equals( "m" ) )
                        grid.mark( row, col );
                    else
                        throw new RuntimeException( "Please enter right input!" );
                }
            }
        }

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