package MiniProject.MineSweeper;

public enum Result {


    Continue( "Game is continuing ..." ),
    MeetMine( "Auh! You step on a mine!" );


    /**================================ private field ================================**/


    private final String result;


    /**================================ constructor ================================**/


    private Result( String result ) { this.result = result; }


    /**================================ public method ================================**/


    public String getResult() { return this.result; }


}