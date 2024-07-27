package MiniProject.MineSweeper;

public enum Sign {


    SIMPLE( "*", Color.WHITE ),
    BLANK( " ", Color.WHITE ),
    NUMBER( "N", Color.YELLOW ),
    MINE( "X", Color.RED ),
    FLAG( "F", Color.PURPLE ),
    UNCERTAIN( "?", Color.GREEN );


    /**================================ private field ================================**/


    private final String sign;
    private final Color color;


    /**================================ constructor ================================**/


    private Sign( String sign, Color color ) { this.sign = sign; this.color = color; }


    /**================================ public method ================================**/


    public String getSign() { return this.sign; }

    public String getColor() { return this.color.getColor(); }


}