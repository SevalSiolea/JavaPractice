package MiniProject.MineSweeper;

public class Launcher {


    /**================================ public method ================================**/


    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Difficulty difficulty = Difficulty.valueOf( scanner.next().toUpperCase() );

        Game game = new Game( difficulty );
        game.startGame();

    }


}