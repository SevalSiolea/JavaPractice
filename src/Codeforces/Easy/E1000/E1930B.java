package Codeforces.Easy.E1000;

/**
 * Difficulty : E1000B-easy<br>
 * Algorithm : constructive, math<br>
 * Feature : you need knowledge of number theory to construct result, and programming is easy<br>
 * Solution : solution1<br>
 * Date : 2024.7.22<br>
 */
public class E1930B {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        int testCount = scanner.nextInt();
        int[][] results = new int[ testCount ][];
        for( int i=0; i < testCount; i++ )
            results[ i ] = solution( strategy, scanner.nextInt() );

        for( int i=0; i < testCount; i++ ) {
            for (int num : results[i])
                System.out.print(num + " ");
            System.out.println();
        }
    }

    private static int[] solution( Strategy strategy, int length ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( length );
            default:
                return new int[] {};
        }
    }

    /**
     * Description : simple solution, math solution<br>
     * Complexity : time O( N ), space O( 1 )<br>
     * Hint : for any x > length / 2, there does not exist y such that y is divided by x<br>
     * Thought : construct array = { 1, n, 2, n-1, ... }<br>
     *
     * @param length length of array
     * @return result
     */
    private static int[] solution1( int length ) {
        int[] arr = new int[ length ];
        for( int i=0; i < length; i++ )
            arr[ i ] = ( i % 2 == 0 ) ? ( i / 2 + 1 ) : ( length - i / 2 );
        return arr;
    }

}
