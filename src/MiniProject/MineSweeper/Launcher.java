package MiniProject.MineSweeper;

public class Launcher {


    /**================================ public method ================================**/


    public static void main( String[] args ) {

        while( startGame() ) {
            Difficulty difficulty = getDifficulty();
            Game game = initGame( difficulty );
            game.playGame();
        }

    }


    /**================================ private method ================================**/



    private static boolean startGame() {

        java.util.Scanner scanner = new java.util.Scanner( System.in );

        System.out.print( "Start a new game ( yes / no ) : " );
        String startGame = scanner.next().toLowerCase();
        if( startGame.equals( "no" ) )
            return false;
        else if( startGame.equals( "yes" ) )
            return true;
        else
            throw new RuntimeException( "Please enter right input!" );

    }

    private static Difficulty getDifficulty() {

        java.util.Scanner scanner = new java.util.Scanner( System.in );

        System.out.print( "Select a difficulty ( easy / medium / hard / customized ) : " );
        String difficultyStr = scanner.next().toUpperCase();

        if( difficultyStr.equals( "E" ) ) return Difficulty.EASY;
        if( difficultyStr.equals( "M" ) ) return Difficulty.MEDIUM;
        if( difficultyStr.equals( "H" ) ) return Difficulty.HARD;
        if( difficultyStr.equals( "C" ) ) return Difficulty.CUSTOMIZED;

        return Difficulty.valueOf( difficultyStr );

    }

    private static Game initGame( Difficulty difficulty ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );

        if( difficulty == Difficulty.EASY || difficulty == Difficulty.MEDIUM || difficulty == Difficulty.HARD )
            return new Game( difficulty );
        else if( difficulty != Difficulty.CUSTOMIZED )
            throw new RuntimeException( "Please enter right input!" );

        System.out.print( "Set row of the game ( from 1 to 32 ) : " );
        int row = scanner.nextInt();
        System.out.print( "Set col of the game ( from 1 to 32 ) : " );
        int col = scanner.nextInt();
        System.out.print( "Set number of mines ( from 1 to row * col ) " );
        int mineCount = scanner.nextInt();

        return new Game( Difficulty.CUSTOMIZED, row, col, mineCount );

    }


}