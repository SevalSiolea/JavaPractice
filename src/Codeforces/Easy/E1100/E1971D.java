package Codeforces.Easy.E1100;

/**
 * Difficulty : E1100-easy<br>
 * Date : 2024.7.25<br>
 */
public class E1971D {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        int testCount = scanner.nextInt();
        int[] results = new int[ testCount ];
        for( int i=0; i < testCount; i++ )
            results[ i ] = solution( strategy, scanner.next() );

        for( int i=0; i < testCount; i++ )
            System.out.println( results[ i ] );
    }

    private static int solution( Strategy strategy, String str ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( str );
            default:
                return -1;
        }
    }

    /**
     * Description : simple solution<br>
     * Complexity : time O( N ), space O( N )<br>
     *
     * @param str given binary string
     * @return result
     */
    private static int solution1( String str ) {

        String[] strs = str.split( "" );

        int subCount = 1;
        for( int i=0; i < strs.length - 1; i++ )
            if( !strs[ i ].equals( strs[ i + 1 ] ) )
                subCount++;

        for( int i=0; i < strs.length - 1; i++ )
            if( strs[ i ].equals( "0" ) && strs[ i + 1 ].equals( "1" ) ) {
                subCount--;
                break;
            }

        return subCount;
    }

}
