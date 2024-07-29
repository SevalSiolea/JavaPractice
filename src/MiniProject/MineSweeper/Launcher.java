package MiniProject.MineSweeper;

import MiniProject.MineSweeper.Enum.Difficulty;
import MiniProject.MineSweeper.Enum.Message;

public class Launcher {


    /**===============================================================================**/
    /**================================ public method ================================**/
    /**===============================================================================**/


    public static void main( String[] args ) {

        while( startGame() ) {
            Difficulty difficulty = getDifficulty();
            Game game = initGame( difficulty );
            game.playGame();
        }

    }


    /**================================================================================**/
    /**================================ private method ================================**/
    /**================================================================================**/


    private static boolean startGame() {

        java.util.Scanner scanner = new java.util.Scanner( System.in );

        while( true ) {
            System.out.print( "Start a new game ( yes / no ) : " );
            String startGame = scanner.nextLine().trim().toLowerCase();
            if( startGame.equals( "no" ) || startGame.equals( "n" ) )
                return false;
            else if( startGame.equals( "yes" ) || startGame.equals( "y" ) )
                return true;
            else
                System.out.println( Message.STARTGAME.getMessage() );
        }

    }

    private static Difficulty getDifficulty() {

        java.util.Scanner scanner = new java.util.Scanner( System.in );

        while( true ) {
            System.out.print( "Select a difficulty ( easy / medium / hard / customized ) : " );
            String difficultyStr = scanner.nextLine().trim().toUpperCase();

            switch ( difficultyStr ) {
                case "E":
                case "EASY":
                    return Difficulty.EASY;
                case "M":
                case "MEDIUM":
                    return Difficulty.MEDIUM;
                case "H":
                case "HARD":
                    return Difficulty.HARD;
                case "C":
                case "CUSTOMIZED":
                    return Difficulty.CUSTOMIZED;
            }

            System.out.println( Message.SELECT_DIFFICULTY.getMessage() );

        }

    }

    private static Game initGame( Difficulty difficulty ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );

        if( difficulty == Difficulty.EASY || difficulty == Difficulty.MEDIUM || difficulty == Difficulty.HARD )
            return new Game( difficulty );
        else if( difficulty != Difficulty.CUSTOMIZED )
            throw new RuntimeException( "Please enter right input!" );

        while( true ) {

            int row;
            System.out.print( "Set row of the game ( from 1 to 32 ) : " );
            String rowStr = scanner.nextLine().trim();
            if( !rowStr.matches( "^-?\\d+$" ) ) {
                System.out.println( Message.NOTROW.getMessage() );
                continue;
            } else {
                row = Integer.parseInt( rowStr );
                if( row <= 0 || row > 32 ) {
                    System.out.println( Message.FALSEROW.getMessage() );
                    continue;
                }
            }

            int col;
            System.out.print( "Set col of the game ( from 1 to 32 ) : " );
            String colStr = scanner.nextLine().trim();
            if( !colStr.matches( "^-?\\d+$" ) ) {
                System.out.println( Message.NOTCOL.getMessage() );
                continue;
            } else {
                col = Integer.parseInt( colStr );
                if( col <= 0 || col > 32 ) {
                    System.out.println( Message.FALSECOL.getMessage() );
                    continue;
                }
            }

            int mineCount;
            System.out.print( "Set number of mines ( from 1 to row * col ) : " );
            String mineCountStr = scanner.nextLine().trim();
            if( !mineCountStr.matches( "^-?\\d+$" ) ) {
                System.out.println( Message.NOTMINECOUNT.getMessage() );
                continue;
            } else {
                mineCount = Integer.parseInt( mineCountStr );
                if( mineCount <= 0 || mineCount > 32 ) {
                    System.out.println( Message.FALSEMINECOUNT.getMessage() );
                    continue;
                }
            }

            return new Game( Difficulty.CUSTOMIZED, row, col, mineCount );

        }

    }


}