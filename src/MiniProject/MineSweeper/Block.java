package MiniProject.MineSweeper;

public class Block {


    /**================================ private field ================================**/


    private boolean mine;
    private Sign sign;
    private int mineCount;


    /**================================ constructor ================================**/


    public Block() { this( false ); }

    public Block( boolean mine ) {
        this.mine = mine;
        this.sign = Sign.SIMPLE;
        this.mineCount = 0;
    }


    /**================================ public method ================================**/

    public void displaySign() {
        if( mine )
            this.sign = Sign.MINE;
        else if( mineCount == 0 )
            this.sign = Sign.BLANK;
        else
            this.sign = Sign.NUMBER;
    }

    public int markSign() {
        if( this.sign == Sign.SIMPLE ) {
            this.sign = Sign.FLAG;
            if( this.mine )
                return 1;
            else
                return 0;
        } else if( this.sign == Sign.FLAG ) {
            this.sign = Sign.UNCERTAIN;
            if( this.mine )
                return -1;
            else
                return 0;
        } else if( this.sign == Sign.UNCERTAIN ) {
            this.sign = Sign.SIMPLE;
            return 0;
        } else
            return 0;
    }

    public String getSign() {
        if( this.sign.getSign().equals( "N" ) && this.mineCount != 0 )
            return Integer.toString( this.mineCount );
        else
            return this.sign.getSign();
    }

    public void addMineCount() { mineCount++; }

    public boolean getMine() { return this.mine; }

    public void setMine() { this.mine = true; }

    public int getMineCount() { return this.mineCount; }

    public String getColor() { return this.sign.getColor(); }


}