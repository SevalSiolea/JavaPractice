package MiniProject.MineSweeper;

public class Grid {


    /**================================ private field ================================**/


    private final int row;
    private final int col;
    private final Block[][] blocks;


    /**================================ constructor ================================**/


    public Grid() { this( 16, 16, 32 ); }

    public Grid( int row, int col, int mineCount ) {
        this.row = row;
        this.col = col;
        this.blocks = new Block[ this.row ][ this.col ];
        for( int i = 0; i < this.row; i++ )
            for( int j = 0; j < this.col; j++ )
                this.blocks[ i ][ j ] = new Block();
        setMines( mineCount );
    }


    /**================================ public method ================================**/

    public void printGrid() {

        System.out.printf( "%-4s", "" );
        for( int i = 1; i <= this.col; i++ )
            System.out.printf( "%-3d", i );
        System.out.println();

        for( int i = 1; i <= this.row; i++ ) {
            System.out.printf( "%-4d", i );
            for( int j = 0; j < this.col; j++ )
                System.out.printf( "%-3s", blocks[ i - 1 ][ j ].getSign() );
            System.out.println();
        }

    }

    /**================================ private method ================================**/


    private void setMines( int mineCount ) {

        for( int i = 0; i < mineCount; i++ ) {
            int row = (int) Math.floor( Math.random() * this.row );
            int col = (int) Math.floor( Math.random() * this.col );

            if( blocks[ row ][ col ].getMine() ) {
                i--;
                continue;
            }

            blocks[ row ][ col ].setMine();
            addMineCount( row, col );
        }

    }

    private void addMineCount( int row, int col ) {
        for( int i = -1; i <= 1; i++ )
            for( int j = -1; j <= 1; j++ )
                if( row + i >= 0 && row + i < this.row && col + j >= 0 && col + j < this.col )
                    blocks[ row + i ][ col + j ].addMineCount();
    }


}