package MiniProject.MineSweeper.Enum;

public enum Message {


    STARTGAME( "Please enter yes or no!", Color.RED ),
    SELECT_DIFFICULTY( "Please select right difficulty!\nYou should enter ( easy / medium / hard / customized )", Color.RED ),

    NOTROW( "Please enter correct row!", Color.RED ),
    NOTCOL( "Please enter correct col!", Color.RED ),
    NOTMINECOUNT( "Please enter correct number of mines!", Color.RED ),

    RESTART( "Do you REALLY want to restart?", Color.RED ),
    ENDGAME( "Do you REALLY want to end game? Enter again : ", Color.RED ),
    OPERATION( "Please enter click or mark!", Color.RED ),

    NOTROWAT( "Please enter correct row or an operation ( click / mark )!\nError at : ", Color.RED ),
    NOTCOLAT( "Please enter correct col!\nError at : ", Color.RED ),

    FALSEROW( "Please enter a row of correct range!", Color.RED ),
    FALSECOL( "Please enter a col of correct range!", Color.RED ),
    FALSEMINECOUNT( "Please enter number of mines of correct range!", Color.RED ),
    ;


    /**===============================================================================**/
    /**================================ private field ================================**/
    /**===============================================================================**/


    private final String message;
    private final Color color;


    /**=============================================================================**/
    /**================================ constructor ================================**/
    /**=============================================================================**/


    private Message( String message, Color color ) { this.message = message; this.color = color; }


    /**===============================================================================**/
    /**================================ public method ================================**/
    /**===============================================================================**/


    public String getMessage() { return color.getColor() + message + "\033[0m"; }


}