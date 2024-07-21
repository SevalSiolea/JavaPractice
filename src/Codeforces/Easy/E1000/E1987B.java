package Codeforces.Easy.E1000;

import java.util.Scanner;

public class E1987B {

    private enum Strategy { strategy1, strategy2 }

    public static void main( String[] args ) {

        Scanner scanner = new Scanner( System.in );
        Strategy strategy = Strategy.strategy1;

        int testCount = scanner.nextInt();
        long[] coins = new long[ testCount ];
        for( int i=0; i < testCount; i++ ) {
            int arrLength = scanner.nextInt();
            int[] arr = new int[ arrLength ];
            for( int j=0; j < arrLength; j++ )
                arr[ j ] = scanner.nextInt();
            coins[ i ] = solution( strategy, arr );
        }

        for( int i=0; i < testCount; i++ )
            System.out.println( coins[ i ] );
    }

    private static long solution( Strategy strategy, int[] arr ) {
        switch( strategy ) {
            case strategy1:
                return solution1( arr );
            case strategy2:
                return solution2( arr );
            default:
                return -1L;
        }
    }

    // simulate solution
    // simulate the process of pay coins and non-decrease array
    private static long solution1( int[] arr ) {

        long coin = 0L;

        for( int i=0; i < arr.length - 1; i++ )
            while( arr[ i ] > arr[ i+1 ] ) {
                for( int j = i; j < arr.length - 1; j++ ) {
                    if( arr[ j ] > arr[ j+1 ] ) {
                        arr[ j+1 ]++;
                        coin++;
                    }
                }
                coin++;
            }

        return coin;
    }

    // calculate solution
    // firstly calculate diff[ i ] as operation times of arr[ i+1 ]
    // then calculate sum of operation times
    private static long solution2( int[] arr ) {

        // diff[ i ] is operation times of arr[ i+1 ]
        int[] diff = new int[ arr.length - 1 ];
        for( int i=0; i < diff.length; i++ )
            diff[ i ] = arr[ i ] - arr[ i+1 ];
        for( int i=0; i < diff.length - 1; i++ )
            if ( diff[i] > 0 )
                diff[ i+1 ] += diff[ i ];
        for( int i=0; i < diff.length; i++ )
            if( diff[ i ] < 0 )
                diff[ i ] = 0;

        // calculate sum of operation times
        java.util.Arrays.sort( diff );
        long coins = 0L;

        int choseK = diff.length - 1;
        for( int i=0; i < diff.length - 1; i++ ) {
            coins += (long) ( choseK - i + 1 ) * ( diff[ i+1 ] - diff[ i ] );
        }
        return coins;
    }

}
