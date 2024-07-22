package Codeforces.Easy.E1000;

public class E1968C {

    private enum Strategy { strategy1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.strategy1;

        int testCount = scanner.nextInt();
        int[][] results = new int[ testCount ][];
        for( int i=0; i < testCount; i++ ) {
            int arrLength = scanner.nextInt();
            int[] arr = new int[ arrLength ];
            arr[ arrLength - 1 ] = 0;
            for( int j=0; j < arrLength - 1; j++ )
                arr[ j ] = scanner.nextInt();
            results[ i ] = solution( strategy, arr );
        }

        for( int i=0; i < testCount; i++ ) {
            for( int num : results[ i ] )
                System.out.print( num + " " );
            System.out.println();
        }

    }

    private static int[] solution( Strategy strategy, int[] arr ) {
        switch( strategy ) {
            case strategy1:
                return solution1( arr );
            default:
                return new int[] {};
        }
    }

    // easiest solution
    // result[ i ] = arr[ i-1 ] + result[ i-1 ] * k
    // k satisfy result[ i ] > arr[ i ]
    private static int[] solution1( int[] arr ) {

        int[] result = new int[ arr.length ];
        result[ 0 ] = arr[ 0 ] + 1;
        for( int i=1; i < arr.length; i++ ) {
            result[ i ] = arr[ i-1 ];
            while( result[ i ] <= arr[ i ] )
                result[ i ] += result[ i-1 ];
        }

        return result;
    }

}
