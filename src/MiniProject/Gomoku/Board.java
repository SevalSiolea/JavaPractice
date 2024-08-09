package MiniProject.Gomoku;

public class Board {


    /**===============================================================================**/
    /**================================ private field ================================**/
    /**===============================================================================**/


    private String[][] blocks;
    private final int length;


    /**=============================================================================**/
    /**================================ constructor ================================**/
    /**=============================================================================**/


    public Board() { this.length = 15; initBoard(); }


    /**===============================================================================**/
    /**================================ public method ================================**/
    /**===============================================================================**/


    public void printBoard() {

        System.out.printf( "%-4s", "" );
        for( int i = 0; i < this.length; i++ )
            System.out.printf( "%-3d", i+1 );
        System.out.println();

        for( int i=0; i < this.length; i++ ) {
            System.out.printf( "%-4d", i+1 );
            for( int j=0; j < this.length; j++ )
                System.out.printf( "%-3s", this.blocks[ i ][ j ] );
            System.out.println();
        }

    }

    public void put( int row, int col, String piece ) {
        this.blocks[ row ][ col ] = piece;
    }

    public boolean matchNullPiece( int row, int col, String piece ) {
        if( row < 0 || row >= this.length ) return false;
        if( col < 0 || col >= this.length ) return false;
        return this.blocks[ row ][ col ].equals( piece );
    }

    public int getLength() { return this.length; }


    /**================================================================================**/
    /**================================ private method ================================**/
    /**================================================================================**/


    private void initBoard() {
        this.blocks = new String[ this.length ][ this.length ];
        for( int i=0; i < this.length; i++ )
            for( int j=0; j < this.length; j++ )
                this.blocks[ i ][ j ] = "+";
    }


}