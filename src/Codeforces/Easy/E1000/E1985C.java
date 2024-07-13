package Codeforces.Easy.E1000;

import java.util.Scanner;

public class E1985C {

    private enum solution { solution1, solution2 }

    public static void main( String[] args ) {

        Scanner scanner = new Scanner( System.in );

        int testCount = scanner.nextInt();
        int[] prefixes = new int[ testCount ];
        for( int i=0; i < testCount; i++ ) {
            int arrLength = scanner.nextInt();
            long[] arr = new long[ arrLength ];
            for( int j=0; j < arrLength; j++ )
                arr[ j ] = scanner.nextLong();
            prefixes[ i ] = solution( solution.solution2, arr );
        }

        for( int i=0; i < testCount; i++ )
            System.out.println( prefixes[ i ] );
    }

    private static int solution( solution solution, long[] arr ) {
        switch( solution ) {
            case solution1:
                return solution1( arr );
            case solution2:
                return solution2( arr );
            default:
                return -1;
        }
    }

    // easiest solution by traversing every prefix array
    private static int solution1( long[] arr ) {

        int prefix = 0;
        for( int i=0; i < arr.length; i++ ) {
            long max = 0;
            long sum = 0;
            for( int j=0; j <= i; j++ ) {
                sum += arr[ j ];
                if( max < arr[ j ] )
                    max = arr[ j ];
            }
            if( sum == 2 * max )
                prefix++;
        }

        return prefix;
    }

    // optimize based on easiest solution
    // loop nesting layers decrease from 2 to 1
    private static int solution2( long[] arr ) {

        int prefix = 0;
        long sum = 0;
        long max = 0;
        for( int i=0; i < arr.length; i++ ) {
            sum += arr[ i ];
            if( max < arr[ i ] )
                max = arr[ i ];

            if( sum == 2 * max )
                prefix++;
        }

        return prefix;
    }

}
