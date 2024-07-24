package Codeforces.Easy.E1000;

/**
 * Difficulty : E1000-medium<br>
 * Feature : think carelessly and give wrong algorithm in solution1<br>
 * Solution : solution1<br>
 * Date : 2024.7.22<br>
 *
 * solution1 : think carelessly and give wrong algorithm
 */
public class E1975B {

    private enum Strategy { STRATEGY1, STRATEGY2 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY2;

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
            case STRATEGY2:
                return solution2( arr, 2 );
            default:
                return false;
        }
    }


    /**
     * Description : wrong algorithm
     * Idea : if arr[ 1 ] is divided by arr[ 0 ]
     * Idea : some elements may only be divided by arr[ 2 ]
     *
     * @param arr given array
     * @return result
     * @deprecated wrong algorithm
     */
    private static boolean solution1( int[] arr ) {

        java.util.Arrays.sort( arr );
        for( int i=0; i < arr.length; i++ )
            if( arr[ i ] % arr[ 0 ] != 0 && arr[ i ] % arr[ 1 ] != 0 )
                return false;

        return true;
    }

    /**
     * Description : simple solution<br>
     * Complexity : time O( N ), space O( N )<br>
     * Idea : iterate over given array and check whether every element can be divided by min<br>
     * Idea : construct a new array consisting of remaining elements<br>
     * Idea : repeat the above process util there does not exist factors<br>
     * Feature : this algorithm can be expanded to any times of factors<br>
     *
     * @param arr given array
     * @param factorCount 2 factor
     * @return result
     */
    private static boolean solution2( int[] arr, int factorCount ) {

        int min = Integer.MAX_VALUE;
        for( int num : arr )
            if( num < min )
                min = num;

        int[] newArr = new int[ arr.length ];
        int length = 0;
        for( int num : arr )
            if( num % min != 0 )
                newArr[ length++ ] = num;
        arr = java.util.Arrays.copyOf( newArr, length );

        if( factorCount == 1 )
            return arr.length == 0;
        else
            return solution2( arr, factorCount - 1 );
    }

}
