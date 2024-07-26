package MiniProject.MineSweeper;

public class Launcher {


    /**================================ public method ================================**/


    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );

        while( true ) {
            System.out.print( "Start a new game ( yes / no ) : ");
            String startGame = scanner.next();
            if( startGame.equals( "no" ) )
                break;
            else if( !startGame.equals( "yes" ) )
                throw new RuntimeException( "Please enter right input!" );

            System.out.println( "Select a difficulty ( easy / medium / hard / customized ) : easy / medium / hard / customized : " );
            Difficulty difficulty = Difficulty.valueOf( scanner.next().toUpperCase() );
            Game game;
            if( difficulty == Difficulty.EASY || difficulty == Difficulty.MEDIUM || difficulty == Difficulty.HARD )
                game = new Game( difficulty );
            else if( difficulty == Difficulty.CUSTOMIZED ) {
                System.out.print( "Set row of game ( from 1 to 64 ) : " );
                int row = scanner.nextInt();
                if( row < 1 || row > 64 )
                    throw new RuntimeException( "Please enter right input!" );

                System.out.print( "Set column of game ( from 1 to 64 ) : " );
                int column = scanner.nextInt();
                if( column < 1 || column > 64 )
                    throw new RuntimeException( "Please enter right input!" );

                System.out.print( "Set number of mines of game ( from 1 to row * col ) : " );
                int mineCount = scanner.nextInt();
                if( mineCount < 1 || mineCount > row * column )
                    throw new RuntimeException( "Please enter right input!" );

                game = new Game( Difficulty.CUSTOMIZED, row, column, mineCount );
            } else
                throw new RuntimeException( "Please enter right input!" );

            game.playGame();
        }

    }


}