package Codeforces;

import java.util.Scanner;

public class Template {

    private enum solution { solution1, solution2, solution3 }

    public static void main( String[] args ) {

        Scanner scanner = new Scanner( System.in );

        int testCount = scanner.nextInt();
        long[] results = new long[ testCount ];
        for( int i=0; i < testCount; i++ ) {
            int arrLength = scanner.nextInt();
            int[] arr = new int[ arrLength ];
            for( int j=0; j < arrLength; j++ )
                arr[ j ] = scanner.nextInt();
            results[ i ] = solution( solution.solution1, arr );
        }

        for( int i=0; i < testCount; i++ )
            System.out.print( results[ i ] );
    }

    private static long solution( solution solution, int[] arr ) {
        switch( solution ) {
            case solution1:
                return solution1( arr );
            case solution2:
                return solution2( arr );
            case solution3:
                return solution3( arr );
            default:
                return -1L;
        }
    }

    private static long solution1( int[] arr ) { return 0L; }

    private static long solution2( int[] arr ) { return 0L; }

    private static long solution3( int[] arr ) { return 0L; }

}