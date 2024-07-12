package Codeforces.Easy.E1000;

import java.util.Scanner;

public class E1987B {

    private enum solution { solution1 }

    public static void main( String[] args ) {

        Scanner scanner = new Scanner( System.in );

        int testCount = scanner.nextInt();
        int[] coins = new int[ testCount ];
        for( int i=0; i < testCount; i++ ) {
            int arrLength = scanner.nextInt();
            int[] arr = new int[ arrLength ];
            for( int j=0; j < arrLength; j++ )
                arr[ j ] = scanner.nextInt();
            coins[ i ] = solution( solution.solution1, arr );
        }

        for( int i=0; i < testCount; i++ )
            System.out.println( coins[ i ] );
    }

    private static int solution( solution solution, int[] arr ) {
        switch( solution ) {
            case solution1:
                return solution1( arr );
            default:
                return 0;
        }
    }

    // simulate solution
    // simulate the process of pay coins and non-decrease array
    private static int solution1( int[] arr ) {

        int coin = 0;

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

}
