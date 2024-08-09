package MiniProject.Gomoku;

import MiniProject.Gomoku.Enum.*;

public class Game {


    /**===============================================================================**/
    /**================================ private field ================================**/
    /**===============================================================================**/


    private Player player1;
    private Player player2;
    private Board board;
    private Result result;


    /**=============================================================================**/
    /**================================ constructor ================================**/
    /**=============================================================================**/


    public Game() {
        this.player1 = new Player( "●" );
        this.player2 = new Player( "○" );
        this.board = new Board();
        this.result = Result.CONTINUE;
    }


    /**===============================================================================**/
    /**================================ public method ================================**/
    /**===============================================================================**/


    public void playGame() {
        Player currentPlayer = this.player1;
        while( this.result == Result.CONTINUE ) {
            this.board.printBoard();
            Location location = getLocation( currentPlayer );
            this.board.put( location.getRow(), location.getCol(), currentPlayer.getPiece() );
            currentPlayer = ( currentPlayer == this.player1 ) ? this.player2 : this.player1;
            judgeWin( location.getRow(), location.getCol() );
        }
        endGame();
    }


    /**================================================================================**/
    /**================================ private method ================================**/
    /**================================================================================**/


    private Location getLocation( Player currentPlayer ) {
        java.util.Scanner scanner = new java.util.Scanner( System.in );
        System.out.print( "Player using " + currentPlayer.getPiece() + " turns to put a piece at : " );
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new Location( row - 1, col - 1 );
    }

    private void judgeWin( int row, int col ) {}

    private void endGame() {}


    /**===============================================================================**/
    /**================================ private class ================================**/
    /**===============================================================================**/


    private class Location{

        private int row;
        private int col;

        public Location( int row, int col ) { this.row = row; this.col = col; }

        public int getRow() { return this.row; }
        public int getCol() { return this.col; }

    }


}