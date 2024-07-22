package Codeforces.Easy.E1000;

public class E1927C {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        int testCount = scanner.nextInt();
        boolean[] results = new boolean[ testCount ];
        for( int i=0; i < testCount; i++ ) {
            int lengthA = scanner.nextInt();
            int lengthB = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arrA = new int[ lengthA ];
            for( int j=0; j < lengthA; j++ )
                arrA[ j ] = scanner.nextInt();
            int[] arrB = new int[ lengthB ];
            for( int j=0; j < lengthB; j++ )
                arrB[ j ] = scanner.nextInt();
            results[ i ] = solution( strategy, arrA, arrB, k );
        }

        for( int i=0; i < testCount; i++ )
            System.out.println( results[ i ] ? "YES" : "NO" );
    }

    private static boolean solution( Strategy strategy, int[] arrA, int[] arrB, int k ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( arrA, arrB, k );
            default:
                return false;
        }
    }

    // easiest solution
    // traverse arrA and arrB, note whether i can be chosen from arrA or arrB
    // if there exist i cant be chosen from arrA or arrB, return false
    // if more than half elements can be chosen from arrA or from arrA and arrB, and
    // if more than half elements can be chosen from arrB or from arrA and arrB
    // return true;
    private static boolean solution1( int[] arrA, int[] arrB, int k ) {

        int[] resultA = new int[ k ];
        java.util.Arrays.fill( resultA, 0 );
        for( int num : arrA )
            if ( num <= k )
                resultA[ num - 1 ] = 1;

        int[] resultB = new int[ k ];
        java.util.Arrays.fill( resultB, 0 );
        for( int num : arrB )
            if ( num <= k )
                resultB[ num - 1 ] = 2;

        int[] result = new int[] { 0, 0, 0, 0 };
        for( int i=0; i < k; i++ )
            result[ resultA[ i ] + resultB[ i ] ]++;

        if( result[ 0 ] != 0 )
            return false;
        if( result[ 1 ] + result[ 3 ] < k / 2 )
            return false;
        if( result[ 2 ] + result[ 3 ] < k / 2 )
            return false;
        return true;
    }

}
