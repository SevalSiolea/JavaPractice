package Codeforces.Easy.E1000;

public class E1975B {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

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
            default:
                return false;
        }
    }

    // easiest solution by traversing array
    // examine whether they can all be divided by smallest two elements
    private static boolean solution1( int[] arr ) {

        java.util.Arrays.sort( arr );

        for( int i=0; i < arr.length; i++ )
            if( arr[ i ] % arr[ 0 ] != 0 && arr[ i ] % arr[ 1 ] != 0 )
                return false;

        return true;
    }

}
