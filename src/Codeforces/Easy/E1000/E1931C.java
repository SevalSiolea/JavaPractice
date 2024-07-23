package Codeforces.Easy.E1000;

/**
 * Difficulty : E1931-medium<br>
 * Date : 2024.7.22<br>
 */
public class E1931C {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        int testCount = scanner.nextInt();
        int[] results = new int[ testCount ];
        for( int i=0; i < testCount; i++ ) {
            int arrLength = scanner.nextInt();
            int[] arr = new int[ arrLength ];
            for( int j=0; j < arrLength; j++ )
                arr[ j ] = scanner.nextInt();
            results[ i ] = solution( strategy, arr );
        }

        for( int i=0; i < testCount; i++ )
            System.out.println( results[ i ] );
    }

    private static int solution( Strategy strategy, int[] arr ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( arr );
            default:
                return -1;
        }
    }

    /**
     * Description : simple solution, easiest solution<br>
     * Complexity : time O( N ), space O( 1 )<br>
     *
     * @param arr given array
     * @return result
     */
    private static int solution1( int[] arr ) {

        int prefix = arr[ 0 ];
        int prefixCount = 1;
        while( prefixCount < arr.length && arr[ prefixCount - 1 ] == arr[ prefixCount ] )
            prefixCount++;

        int suffix = arr[ arr.length - 1 ];
        int suffixCount = 1;
        while( arr.length - 1 - suffixCount >= 0 && arr[ arr.length - suffixCount ] == arr[ arr.length - 1 - suffixCount ] )
            suffixCount++;

        if( prefix == suffix )
            return Math.max( arr.length - prefixCount - suffixCount, 0 );
        else
            return arr.length - Math.max ( prefixCount, suffixCount );

    }

}
