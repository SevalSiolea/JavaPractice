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


    public void addMineCount() { mineCount++; }

    public String getSign() { return this.sign.getSign(); }

    public void setSign( Sign sign ) { this.sign = sign; }

    public boolean getMine() { return this.mine; }

    public void setMine() { this.mine = true; }


}