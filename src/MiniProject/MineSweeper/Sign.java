package MiniProject.MineSweeper;

public enum Sign {


    SIMPLE( "*" ),
    BLANK( " " ),
    NUMBER( "N" ),
    MINE( "X" ),
    FLAG( "F" ),
    UNCERTAIN( "?" );


    /**================================ private field ================================**/


    private final String sign;


    /**================================ constructor ================================**/


    private Sign() { this( "*" ); }

    private Sign( String sign ) { this.sign = sign; }


    /**================================ public method ================================**/


    public String getSign() { return this.sign; }

}
