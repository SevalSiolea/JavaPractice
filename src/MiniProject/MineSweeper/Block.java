package MiniProject.MineSweeper;

import MiniProject.MineSweeper.Enum.Sign;

public class Block {


    /**===============================================================================**/
    /**================================ private field ================================**/
    /**===============================================================================**/


    private boolean mine;
    private Sign sign;
    private int aroundMineCount;


    /**=============================================================================**/
    /**================================ constructor ================================**/
    /**=============================================================================**/


    public Block() {
        this.mine = false;
        this.sign = Sign.SIMPLE;
        this.aroundMineCount = 0;
    }


    /**===============================================================================**/
    /**================================ public method ================================**/
    /**===============================================================================**/


    public void displaySign() {
        if( this.mine )
            this.sign = Sign.MINE;
        else {
            if ( this.aroundMineCount == 0 )
                this.sign = Sign.BLANK;
            else
                this.sign = Sign.NUMBER;
        }
    }

    public int markSign() {
        if( this.sign == Sign.SIMPLE ) {
            this.sign = Sign.FLAG;
            return this.mine ? 1 : 0;
        } else if( this.sign == Sign.FLAG ) {
            this.sign = Sign.UNCERTAIN;
            return this.mine ? -1 : 0;
        } else if( this.sign == Sign.UNCERTAIN ) {
            this.sign = Sign.SIMPLE;
            return 0;
        } else
            return 0;
    }

    /**----------------------------------------------------------------**/

    public String getSign() {
        if( this.sign.getSign().equals( "N" ) && this.aroundMineCount != 0 )
            return Integer.toString( this.aroundMineCount );
        else
            return this.sign.getSign();
    }

    public void addAroundMineCount() { this.aroundMineCount++; }

    public boolean getMine() { return this.mine; }

    public void setMine() { this.mine = true; }

    public int getAroundMineCount() { return this.aroundMineCount; }

    public String getColor() { return this.sign.getColor(); }


}