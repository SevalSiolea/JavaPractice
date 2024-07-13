package Codeforces;

import java.util.Scanner;

public class Template {

    private enum solution { solution1, solution2, solution3 }

    public static void main( String[] args ) {

        Scanner scanner = new Scanner( System.in );

        int testCount = scanner.nextInt();
        int[] results = new int[ testCount ];
        for( int i=0; i < testCount; i++ ) {
            int arrLength = scanner.nextInt();
            int[] arr = new int[ arrLength ];
            for( int j=0; j < arrLength; j++ )
                arr[ j ] = scanner.nextInt();
            results[ i ] = solution( solution.solution1 );
        }

        for( int i=0; i < testCount; i++ )
            System.out.print( results[ i ] );
    }

    private static int solution( solution solution ) {
        switch( solution ) {
            case solution1:
                return solution1();
            case solution2:
                return solution2();
            case solution3:
                return solution3();
            default:
                return -1;
        }
    }

    private static int solution1() { return 0; }

    private static int solution2() { return 0; }

    private static int solution3() { return 0; }

}