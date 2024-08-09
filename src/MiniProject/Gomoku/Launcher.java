package MiniProject.Gomoku;

import MiniProject.Gomoku.Enum.*;

public class Launcher {


    /**===============================================================================**/
    /**================================ public method ================================**/
    /**===============================================================================**/


    public static void main( String[] args ) {

        while( startGame() ) {
            Game game = new Game();
            game.playGame();
        }

    }


    /**================================================================================**/
    /**================================ private method ================================**/
    /**================================================================================**/


    private static boolean startGame() {

        java.util.Scanner scanner = new java.util.Scanner( System.in );

        while( true ) {
            System.out.print( "Start a new Game ( yes / no ) : " );
            String input = scanner.nextLine().trim().toLowerCase();
            if( input.equals( "yes" ) )
                return true;
            else if( input.equals( "no" ) )
                return false;
            else
                System.out.println( Message.WRONG_START.getMessage() );
        }

    }


}