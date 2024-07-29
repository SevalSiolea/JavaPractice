package MiniProject.MineSweeper;

import MiniProject.MineSweeper.Enum.*;

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
            System.out.print( "Enter an operation ( click / mark ): " );
            operate();
            judgeResult();
        } while( result == Result.CONTINUE );
        endGame();
    }


    /**================================================================================**/
    /**================================ private method ================================**/
    /**================================================================================**/


    private void operate() {

        String command = getCommand();
        if( result == Result.RESTART || result == Result.End ) return;
        String[] commands = command.split( " " );

        int[] blockCounts = getBlockCounts( commands );
        if( blockCounts == null ) return;

        int idx = 0;
        for( int i=0; i < commands.length; i++ ) {
            String operation = commands[ i ].trim().toLowerCase();
            int blockCount = 0;

            while( ++blockCount <= blockCounts[ idx ] ) {
                int row = Integer.parseInt( commands[ ++i ] );
                int col = Integer.parseInt( commands[ ++i ] );
                if( operation.equals( "click" ) || operation.equals( "c" ) )
                    this.grid.click( row, col );
                if( operation.equals( "mark" ) || operation.equals( "m" ) )
                    this.grid.mark( row, col );
            }

            idx++;
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

    private String getCommand() {

        java.util.Scanner scanner = new java.util.Scanner( System.in );

        String command;
        while( true ) {
            command = scanner.nextLine().trim().toLowerCase();
            if( command.equals( "restart a new game" ) || command.equals( "r" ) ) {
                System.out.println( Message.RESTART.getMessage() );
                command = scanner.nextLine().trim().toLowerCase();
                if( command.equals( "restart a new game" ) || command.equals( "r" ) ) {
                    result = Result.RESTART;
                    break;
                }
            } else if( command.equals( "end game" ) || command.equals( "e" ) ) {
                System.out.println( Message.ENDGAME.getMessage() );
                command = scanner.nextLine().trim().toLowerCase();
                if( command.equals( "end game" ) || command.equals( "e" ) ) {
                    result = Result.End;
                    break;
                }
            } else
                break;
        }

        return command;
    }

    private int[] getBlockCounts( String[] commands ) {

        java.util.ArrayList<Integer> blockCounts = new java.util.ArrayList<>();

        for( int i=0; i < commands.length; i++ ) {

            if( !commands[ i ].equals( "click" ) && !commands[ i ].equals( "c" )
                    && !commands[ i ].equals( "mark" ) && !commands[ i ].equals( "m" ) ) {
                System.out.println( Message.OPERATION.getMessage() );
                return null;
            }

            int blockCount = 0;
            while( true ) {

                if( i+1 >= commands.length )
                    if( blockCount == 0 ) {
                        System.out.println( Message.NOTROWAT.getMessage() + ( i+1 ) );
                        return null;
                    } else
                        break;

                if( !commands[ ++i ].matches( "^-?\\d+$" ) ) {
                    System.out.println( Message.NOTROWAT.getMessage() + ( i+1 ) );
                    return null;
                }
                else {
                    int row = Integer.parseInt( commands[ i ] );
                    if( row <= 0 || row > this.grid.getRow() ) {
                        System.out.println( Message.FALSEROW.getMessage() );
                        return null;
                    }
                }

                if( ++i >= commands.length || !commands[ i ].matches( "^-?\\d+$" ) ) {
                    System.out.println( Message.NOTCOLAT.getMessage() + ( i+1 ) );
                    return null;
                }
                else {
                    int col = Integer.parseInt( commands[ i ] );
                    if( col <= 0 || col > this.grid.getRow() ) {
                        System.out.println( Message.FALSECOL.getMessage() );
                        return null;
                    }
                }

                blockCount++;

                if( i+1 < commands.length )
                    if( commands[ i+1 ].equals( "click" ) || commands[ i+1 ].equals( "c" )
                            || commands[ i+1 ].equals( "mark" ) || commands[ i+1 ].equals( "m" ) )
                        break;

            }

            blockCounts.add( blockCount );

        }

        int[] result = new int[ blockCounts.size() ];
        for( int i=0; i < blockCounts.size(); i++ )
            result[ i ] = blockCounts.get( i );
        return result;

    }


}