package MiniProject.MineSweeper;

public class Grid {


    /**===============================================================================**/
    /**================================ private field ================================**/
    /**===============================================================================**/


    private final int row;
    private final int col;
    private final int mineCount;

    private final Block[][] blocks;

    private int clicked;
    private int flagCount;
    private boolean meetMine;


    /**=============================================================================**/
    /**================================ constructor ================================**/
    /**=============================================================================**/


    public Grid( int row, int col, int mineCount ) {
        this.row = row;
        this.col = col;
        this.mineCount = mineCount;

        this.blocks = new Block[ this.row ][ this.col ];
        for( int i = 0; i < this.row; i++ )
            for( int j = 0; j < this.col; j++ )
                this.blocks[ i ][ j ] = new Block();
        setMines( this.mineCount );

        this.clicked = 0;
        this.flagCount = 0;
        this.meetMine = false;
    }


    /**===============================================================================**/
    /**================================ public method ================================**/
    /**===============================================================================**/


    public void printGrid() {

        System.out.printf( "%-4s", "" );
        for( int i = 0; i < this.col; i++ )
            System.out.printf( "%-3d", i+1 );
        System.out.println();

        for( int i = 0; i < this.row; i++ ) {
            System.out.printf( "%-4d", i+1 );
            for( int j = 0; j < this.col; j++ )
                System.out.printf( "%s%-3s\033[0m", blocks[ i ][ j ].getColor(), blocks[ i ][ j ].getSign() );
            System.out.println();
        }

    }

    public void click( int row, int col ) {

        row--;
        col--;

        if( this.clicked == 0 && this.row * this.col != this.mineCount )
            while( this.blocks[ row ][ col ].getMine() || this.blocks[ row ][ col ].getAroundMineCount() != 0 )
                setMines( this.mineCount );

        if( this.blocks[ row ][ col ].getMine() ) {
            this.blocks[ row ][ col ].displaySign();
            this.clicked++;
            this.meetMine = true;
            return;
        }

        display( row, col );

    }

    public void mark( int row, int col ) {
        this.flagCount += this.blocks[ --row ][ --col ].markSign();
    }

    public void displayMines() {
        for( int i = 0; i < this.row; i++ )
            for( int j = 0; j < this.col; j++ )
                if( this.blocks[ i ][ j ].getMine() )
                    this.blocks[ i ][ j ].displaySign();
    }

    /**----------------------------------------------------------------**/

    public int getRow() { return this.row; }

    public int getCol() { return this.col; }

    public int getClicked() { return this.clicked; }

    public int getFlagCount() { return this.flagCount; }

    public int getMineCount() { return this.mineCount; }

    public boolean getMeetMine() { return this.meetMine; }


    /**================================================================================**/
    /**================================ private method ================================**/
    /**================================================================================**/


    private void setMines( int mineCount ) {

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
            addAroundMineCounts( row, col );
        }

    }

    private void display( int row, int col ) {

        if( this.blocks[ row ][ col ].getMine() ) return;
        if( !this.blocks[ row ][ col ].getSign().equals( "*" ) ) return;

        this.blocks[ row ][ col ].displaySign();
        this.clicked++;

        if( this.blocks[ row ][ col ].getSign().equals( " " ) )
            displayAround( row, col );

    }

    /**----------------------------------------------------------------**/

    private void addAroundMineCounts( int row, int col ) {
        for( int i = -1; i <= 1; i++ )
            for( int j = -1; j <= 1; j++ )
                if( i != 0 || j != 0 )
                    if( row + i >= 0 && row + i < this.row && col + j >= 0 && col + j < this.col )
                        blocks[ row + i ][ col + j ].addAroundMineCount();
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