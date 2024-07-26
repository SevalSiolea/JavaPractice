package MiniProject.MineSweeper;

public class Game {


    /**================================ private field ================================**/


    private final Difficulty difficulty;
    private final Grid grid;
    private Result result;


    /**================================ constructor ================================**/


    public Game() { this( Difficulty.MEDIUM ); }

    public Game( Difficulty difficulty ) {
        this.difficulty = difficulty;
        this.grid = new Grid( this.difficulty.getRow(), this.difficulty.getCol(), this.difficulty.getMineCount() );
        this.result = Result.Continue;
    }

    public Game( Difficulty difficulty, int row, int col, int mineCount ) {
        this.difficulty = difficulty;
        this.grid = new Grid( row, col, mineCount );
        this.result = Result.Continue;
    }


    /**================================ public method ================================**/


    public void playGame() {

        do {
            this.grid.printGrid();
            System.out.print( "Enter an operation : " );
            if( operate() ) {
                if( this.grid.getMeetMine() )
                    this.result = Result.MeetMine;
                break;
            }
        } while( true );

        if( result == Result.MeetMine ) {
            this.grid.displayMines();
            this.grid.printGrid();
            System.out.println( "Auh! You step on a mine!" );
        }
    }


    /**================================ private method ================================**/


    private boolean operate() {

        java.util.Scanner scanner = new java.util.Scanner( System.in );

        int row = scanner.nextInt();
        if( row < 1 || row > this.grid.getRow() )
            throw new RuntimeException( "Please enter right input!" );

        int col = scanner.nextInt();
        if( col < 1 || col > this.grid.getCol() )
            throw new RuntimeException( "Please enter right input!" );

        String operation = scanner.next();
        if( operation.equals( "click" ) )
            return this.grid.click( row, col );
        else if( operation.equals( "mark" ) )
            return this.grid.mark( row, col );
        else
            throw new RuntimeException( "Please enter right input!" );

    }


}