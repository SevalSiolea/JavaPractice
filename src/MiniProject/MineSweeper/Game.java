package MiniProject.MineSweeper;

public class Game {


    /**================================ private field ================================**/


    private final Difficulty difficulty;
    private Grid grid;


    /**================================ constructor ================================**/


    public Game() { this( Difficulty.MEDIUM ); }

    public Game( Difficulty difficulty ) {
        this.difficulty = difficulty;
        setGame( this.difficulty.getRow(), this.difficulty.getCol(), this.difficulty.getMineCount() );
    }

    public Game( Difficulty difficulty, int row, int col, int mineCount ) {
        this.difficulty = difficulty;
        setGame( row, col, mineCount );
    }


    /**================================ public method ================================**/


    public void startGame() {
        grid.printGrid();
    }


    /**================================ private method ================================**/


    private void setGame( int row, int col, int mineCount ) {
        grid = new Grid( row, col, mineCount );
    }


}