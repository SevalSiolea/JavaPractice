package Codeforces;

public class Template {

    private enum Strategy { STRATEGY1, STRATEGY2, STRATEGY3 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        int testCount = scanner.nextInt();
        long[] results = new long[ testCount ];
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

    private static long solution( Strategy strategy, int[] arr ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( arr );
            case STRATEGY2:
                return solution2( arr );
            case STRATEGY3:
                return solution3( arr );
            default:
                return -1L;
        }
    }

    private static long solution1( int[] arr ) { return 0L; }

    private static long solution2( int[] arr ) { return 0L; }

    private static long solution3( int[] arr ) { return 0L; }

}