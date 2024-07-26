package MiniProject.MineSweeper;

public enum Result {


    Continue( "Game is continuing ..." ),
    Lose( "Auh! You step on a mine!" ),
    Win( "You win the game! Your time is : " );


    /**================================ private field ================================**/


    private final String result;


    /**================================ constructor ================================**/


    private Result( String result ) { this.result = result; }


    /**================================ public method ================================**/


    public String getResult() { return this.result; }


}