package MiniProject.MineSweeper;

public enum Difficulty {


    EASY( 8, 8, 8 ),
    MEDIUM( 16, 16, 32 ),
    HARD( 16, 32, 64 ),
    CUSTOMIZED( 16, 16, 0 );


    /**================================ private field ================================**/


    private final int row;
    private final int col;
    private final int mineCount;


    /**================================ constructor ================================**/


    private Difficulty( int row, int col, int mineCount ) {
        this.row = row;
        this.col = col;
        this.mineCount = mineCount;
    }


    /**================================ public method ================================**/


    public int getRow() { return this.row; }

    public int getCol() { return this.col; }

    public int getMineCount() { return this.mineCount; }


}