package Codeforces.Easy.E1000;

public class E1931C {

    private enum Strategy { STRATEGY1, STRATEGY2, STRATEGY3 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        int testCount = scanner.nextInt();
        int[] results = new int[ testCount ];
        for( int i=0; i < testCount; i++ ) {
            int arrLength = scanner.nextInt();
            int[] arr = new int[ arrLength ];
            for( int j=0; j < arrLength; j++ )
                arr[ j ] = scanner.nextInt();
            results[ i ] = solution( strategy, arr );
        }

        for( int i=0; i < testCount; i++ )
            System.out.println( results[ i ] );
    }

    private static int solution( Strategy strategy, int[] arr ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( arr );
            default:
                return -1;
        }
    }

    private static int solution1( int[] arr ) {

        int prefix = arr[ 0 ];
        int prefixNum = 1;
        while( prefixNum < arr.length && arr[ prefixNum - 1 ] == arr[ prefixNum ] )
            prefixNum++;

        int suffix = arr[ arr.length - 1 ];
        int suffixNum = 1;
        while( arr.length - suffixNum - 1 >= 0 && arr[ arr.length - suffixNum ] == arr[ arr.length - suffixNum - 1 ] )
            suffixNum++;

        if( prefix == suffix )
            return Math.max( arr.length - prefixNum - suffixNum, 0 );
        else if( prefixNum > suffixNum )
            return arr.length - prefixNum;
        else
            return arr.length - suffixNum;
    }

}
