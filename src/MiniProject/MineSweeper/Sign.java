package MiniProject.MineSweeper;

public enum Sign {


    SIMPLE( "*", "" ),
    BLANK( " ", "" ),
    NUMBER( "N", "\033[32m" ),
    MINE( "X", "\033[31m" ),
    FLAG( "F", "\033[34m" ),
    UNCERTAIN( "?", "\033[45m" );


    /**================================ private field ================================**/


    private final String sign;
    private final String color;


    /**================================ constructor ================================**/


    private Sign() { this( "*", "" ); }

    private Sign( String sign, String color ) {
        this.sign = sign;
        this.color = color;
    }


    /**================================ public method ================================**/


    public String getSign() { return this.sign; }

    public String getColor() { return this.color; }


}