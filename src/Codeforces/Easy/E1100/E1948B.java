package Codeforces.Easy.E1100;

/**
 * Difficulty : E1100-easy<br>
 * Date : 2024.7.26<br>
 */
public class E1948B {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        int testCount = scanner.nextInt();
        boolean[] results = new boolean[ testCount ];
        for( int i=0; i < testCount; i++ ) {
            int arrLength = scanner.nextInt();
            int[] arr = new int[ arrLength ];
            for( int j=0; j < arrLength; j++ )
                arr[ j ] = scanner.nextInt();
            results[ i ] = solution( strategy, arr );
        }

        for( int i=0; i < testCount; i++ )
            System.out.println( results[ i ] ? "YES" : "NO" );
    }

    private static boolean solution( Strategy strategy, int[] arr ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( arr );
            default:
                return false;
        }
    }

    /**
     * Description : simple solution<br>
     * Complexity : time O( N ), space O( N )<br>
     *
     * @param arr given array
     * @return result
     */
    private static boolean solution1( int[] arr ) {

        for( int i = arr.length - 1; i >= 1; i-- ) {
            if( arr[ i ] >= arr[ i - 1 ] )
                continue;

            if( arr[ i - 1 ] < 10 && arr[ i ] < 10 )
                return false;
            if( arr[ i - 1 ] % 10 > arr[ i ] )
                return false;
            if( arr[ i - 1 ] / 10 > arr[ i - 1 ] % 10 )
                return false;
            arr[ i - 1 ] /= 10;
        }

        return true;
    }

}
