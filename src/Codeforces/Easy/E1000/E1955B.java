package Codeforces.Easy.E1000;

public class E1955B {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        int testCount = scanner.nextInt();
        boolean[] results = new boolean[ testCount ];
        for( int i=0; i < testCount; i++ ) {
            int arrLength = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int[] arr = new int[ arrLength * arrLength ];
            for( int j=0; j < arrLength * arrLength; j++ )
                arr[ j ] = scanner.nextInt();
            results[ i ] = solution( strategy, arr, arrLength, x, y );
        }

        for( int i=0; i < testCount; i++ )
            System.out.println( results[ i ] ? "YES" : "NO" );
    }

    private static boolean solution( Strategy strategy, int[] arr, int length, int x, int y ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( arr, length, x, y );
            default:
                return false;
        }
    }

    // easiest solution
    // firstly construct progressive square using length, x, y, and min of arr as a[1][1]
    // then compare the square with the given array
    private static boolean solution1( int[] arr, int length, int x, int y ) {

        int min = Integer.MAX_VALUE;
        for( int i=0; i < arr.length; i++ )
            if( arr[ i ] < min )
                min = arr[ i ];

        int[] newArr = new int[ length * length ];
        for( int i=0; i < length; i++ )
            for( int j=0; j < length; j++ )
                newArr[ i * length + j ] = min + i * x + j * y;

        java.util.Arrays.sort( arr );
        java.util.Arrays.sort( newArr );

        for( int i=0; i < arr.length; i++ )
            if( arr[ i ] != newArr[ i ] )
                return false;

        return true;
    }

}
