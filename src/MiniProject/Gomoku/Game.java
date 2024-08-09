package MiniProject.Gomoku;

import MiniProject.Gomoku.Enum.*;

public class Game {


    /**===============================================================================**/
    /**================================ private field ================================**/
    /**===============================================================================**/


    private final Player player1;
    private final Player player2;
    private final Board board;
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
            put( location );
            currentPlayer = ( currentPlayer == this.player1 ) ? this.player2 : this.player1;
            judgeWin( location );
        }
        this.board.printBoard();
        currentPlayer = ( currentPlayer == this.player1 ) ? this.player2 : this.player1;
        endGame( currentPlayer );
    }


    /**================================================================================**/
    /**================================ private method ================================**/
    /**================================================================================**/


    private Location getLocation( Player currentPlayer ) {
        java.util.Scanner scanner = new java.util.Scanner( System.in );
        while( true ) {
            System.out.print( Prompt.PUT_PIECE.getMessage().replaceAll( "#", currentPlayer.getPiece() ) );
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            if( !this.board.matchNullPiece( row, col, "+" ) )
                System.out.println( WrongInput.INVALID_LOCATION.getMessage() );
            else
                return new Location( row, col, currentPlayer.getPiece() );
        }
    }

    private void judgeWin( Location location ) {

        int row = location.row;
        int col = location.col;
        String piece = location.piece;
        int count;

        count = 0;
        for( int i = -4; i <= 4; i++ ) {
            count = board.matchNullPiece( row, col + i, piece ) ? count + 1 : 0;
            if( count == 5 ) {
                this.result = Result.WIN;
                break;
            }
        }

        count = 0;
        for( int i = -4; i <= 4; i++ ) {
            count = board.matchNullPiece( row + i, col, piece ) ? count + 1 : 0;
            if( count == 5 ) {
                this.result = Result.WIN;
                break;
            }
        }

        count = 0;
        for( int i = -4; i <= 4; i++ ) {
            count = board.matchNullPiece( row + i, col + i, piece ) ? count + 1 : 0;
            if( count == 5 ) {
                this.result = Result.WIN;
                break;
            }
        }

        count = 0;
        for( int i = -4; i <= 4; i++ ) {
            count = board.matchNullPiece( row - i, col + i, piece ) ? count + 1 : 0;
            if( count == 5 ) {
                this.result = Result.WIN;
                break;
            }
        }

    }

    private void endGame( Player currentPlayer ) {
        if( this.result == Result.DRAW )
            System.out.println( result.getMessage() );
        else
            System.out.println( result.getMessage().replaceAll( "#", currentPlayer.getPiece() ) );
    }

    private void put( Location location ) {
        this.board.put( location.row, location.col, location.piece );
    }


    /**===============================================================================**/
    /**================================ private class ================================**/
    /**===============================================================================**/


    private static class Location{

        private final int row;
        private final int col;
        private final String piece;

        public Location( int row, int col, String piece ) {
            this.row = row; this.col = col; this.piece = piece;
        }

    }


}