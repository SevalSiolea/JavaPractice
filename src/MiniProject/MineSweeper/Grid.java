package MiniProject.MineSweeper;

public class Grid {


    /**================================ private field ================================**/


    private final int row;
    private final int col;
    private final int mineCount;
    private Block[][] blocks;

    private boolean clicked;
    private boolean meetMine;


    /**================================ constructor ================================**/


    public Grid() { this( 16, 16, 32 ); }

    public Grid( int row, int col, int mineCount ) {
        this.row = row;
        this.col = col;
        this.mineCount = mineCount;
        setMines( this.mineCount );
        this.clicked = false;
        this.meetMine = false;
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

    public boolean click( int row, int col ) {

        row--;
        col--;

        if( !this.clicked )
            while( this.blocks[ row ][ col ].getMine() || this.blocks[ row ][ col ].getMineCount() != 0 )
                setMines( this.mineCount );
        this.clicked = true;

        display( row, col );
        return this.meetMine;
    }

    public boolean mark( int row, int col ) { return true; }

    public void displayMines() {
        for( int i = 0; i < this.row; i++ )
            for( int j = 0; j < this.col; j++ )
                if( this.blocks[ i ][ j ].getMine() )
                    this.blocks[ i ][ j ].displaySign();
    }

    public int getRow() { return this.row; }

    public int getCol() { return this.col; }

    public boolean getMeetMine() { return this.meetMine; }

    /**================================ private method ================================**/


    private void setMines( int mineCount ) {

        this.blocks = new Block[ this.row ][ this.col ];
        for( int i = 0; i < this.row; i++ )
            for( int j = 0; j < this.col; j++ )
                this.blocks[ i ][ j ] = new Block();

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

    private void display( int row, int col ) {

        if( !this.blocks[ row ][ col ].getSign().equals( "*" ) )
            return ;

        this.blocks[ row ][ col ].displaySign();

        String sign = this.blocks[ row ][ col ].getSign();
        switch( sign ) {
            case "X":
                this.meetMine = true;
                break;
            case "N":
                break;
            case " ":
                displayAround( row, col );
        }

    }

    private void addMineCount( int row, int col ) {
        for( int i = -1; i <= 1; i++ )
            for( int j = -1; j <= 1; j++ )
                if( row + i >= 0 && row + i < this.row && col + j >= 0 && col + j < this.col )
                    blocks[ row + i ][ col + j ].addMineCount();
    }

    private void displayAround( int row, int col ) {
        if( row - 1 >= 0 )
            display( row - 1, col );
        if( row + 1 < this.row )
            display( row + 1, col );
        if( col - 1 >= 0 )
            display( row, col - 1 );
        if( col + 1 < this.col )
            display( row, col + 1 );
    }


}