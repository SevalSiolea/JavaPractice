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
                    this.result = Result.Lose;
                if( this.grid.getFlagCount() == this.grid.getMineCount() )
                    this.result = Result.Win;
                if( this.grid.getClicked() + this.grid.getMineCount() == this.grid.getRow() * this.grid.getCol() )
                    this.result = Result.Win;
                break;
            }
        } while( true );

        this.grid.displayMines();
        this.grid.printGrid();
        System.out.println( this.result.getResult() );

    }


    /**================================ private method ================================**/


    private boolean operate() {

        java.util.Scanner scanner = new java.util.Scanner( System.in );

        java.util.ArrayList<Integer> rows = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> cols = new java.util.ArrayList<>();
        do {
            int row = scanner.nextInt();
            if( row < 1 || row > this.grid.getRow() )
                throw new RuntimeException( "Please enter right input!" );
            rows.add( row );

            int col = scanner.nextInt();
            if( col < 1 || col > this.grid.getCol() )
                throw new RuntimeException( "Please enter right input!" );
            cols.add( col );

        } while( scanner.hasNextInt() );

        boolean result = false;
        String operation = scanner.next().toLowerCase();
        for( int i = 0; i < rows.size(); i++ ) {
            if( operation.equals( "click" ) || operation.equals( "c" ) )
                result |= this.grid.click( rows.get( i ), cols.get( i ) );
            else if( operation.equals( "mark" ) || operation.equals( "m" ) )
                result |= this.grid.mark( rows.get( i ), cols.get( i ) );
            else
                throw new RuntimeException( "Please enter right input!" );
        }

        return result;

    }


}