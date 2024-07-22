package Codeforces.Easy.E1000;

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

    // constructive solution
    // note for every x > length / 2, there does not exist y such that x | y
    // just make sure for any neighboring pair of elements, there exist x > length / 2
    // then construct array = { 1, n, 2, n-1, ... }
    private static int[] solution1( int length ) {
        int[] arr = new int[ length ];
        for( int i=0; i < length; i++ )
            arr[ i ] = ( i % 2 == 0 ) ? ( i / 2 + 1 ) : ( length - i / 2 );
        return arr;
    }

}
