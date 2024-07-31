package Codeforces.Easy.E1200;

/**
 * Difficulty : E1200-hard<br>
 * Date : 2024.7.31<br>
 */
public class E1982C {

    private enum Strategy { STRATEGY1, STRATEGY2, STRATEGY3, STRATEGY4 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY4;

        int testCount = scanner.nextInt();
        int[] results = new int[ testCount ];
        for( int i=0; i < testCount; i++ ) {
            int arrLength = scanner.nextInt();
            int min = scanner.nextInt();
            int max = scanner.nextInt();
            int[] arr = new int[ arrLength ];
            for( int j=0; j < arrLength; j++ )
                arr[ j ] = scanner.nextInt();
            results[ i ] = solution( strategy, arr, min, max );
        }

        for( int i=0; i < testCount; i++ )
            System.out.println( results[ i ] );
    }

    private static int solution( Strategy strategy, int[] arr, int min, int max ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( arr, min, max );
            case STRATEGY2:
                return solution2( arr, min, max );
            case STRATEGY3:
                return solution3( arr, min, max );
            case STRATEGY4:
                return solution4( arr, min, max );
            default:
                return -1;
        }
    }

    private static int solution1( int[] arr, int min, int max ) {

        int round = 0;

        int start = 0;
        int end = 0;
        while( start < arr.length ) {
            int sum = arr[ start ];
            while( true ) {
                if( sum < min ) {
                    if( end < arr.length - 1 ) {
                        end++;
                        sum += arr[ end ];
                    } else
                        return round;
                } else if( sum > max ) {
                    start++;
                    sum -= arr[ start - 1 ];
                } else {
                    end++;
                    start = end;
                    round++;
                    break;
                }
            }
        }

        return round;

    }

    private static int solution2( int[] arr, int min, int max ) {

        int[] ends = new int[ arr.length ];
        java.util.Arrays.fill( ends, -1 );
        for( int i=0; i < arr.length; i++ ) {
            int sum = arr[ i ];
            int end = i;
            while( sum < min && end + 1 < arr.length )
                sum += arr[ ++end ];
            if( sum >= min && sum <= max )
                ends[ i ] = end;
        }

        int[] rounds = new int[ arr.length + 1 ];
        rounds[ rounds.length - 1 ] = 0;
        for( int i = rounds.length - 2; i >= 0; i-- )
            rounds[ i ] = ( ends[ i ] == -1 ) ? rounds[ i+1 ] : ( rounds[ ends[ i ] + 1 ] + 1 );

        return rounds[ 0 ];
    }

    private static int solution3( int[] arr, int min, int max ) {

        int[] rounds = new int[ arr.length + 1 ];
        rounds[ 0 ] = 0;

        for( int i=0; i < arr.length; i++ ) {
            int sum = arr[ i ];
            int end = i;
            while( sum < min && end + 1 < arr.length )
                sum += arr[ ++end ];
            if( sum >= min && sum <= max )
                rounds[ end + 1 ] = Math.max( rounds[ i ] + 1, rounds[ end + 1 ] );
            rounds[ i+1 ] = Math.max( rounds[ i ], rounds[ i+1 ] );
        }

        return rounds[ rounds.length - 1 ];
    }

    private static int solution4( int[] arr, int min, int max ) {

        int[] rounds = new int[ arr.length + 1 ];
        rounds[ 0 ] = 0;

        int sum = 0;
        int end = -1;
        for( int i=0; i < arr.length; i++ ) {
            rounds[ i+1 ] = Math.max( rounds[ i ], rounds[ i+1 ] );
            if( end < i ) {
                end = i;
                sum = 0;
            }
            while( end < arr.length && sum < min )
                sum += arr[ end++ ];
            if( sum >= min && sum <= max )
                rounds[ end ] = Math.max( rounds[ end], rounds[ i ] + 1 );
            sum -= arr[ i ];
        }

        return rounds[ rounds.length - 1 ];
    }

}
