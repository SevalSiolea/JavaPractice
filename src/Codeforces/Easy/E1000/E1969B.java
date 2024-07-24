package Codeforces.Easy.E1000;

/**
 * Difficulty : E1000-hard<br>
 * Algorithm : simulate, math<br>
 * Feature : a clever math algorithm in solution2<br>
 * Solution : solution2<br>
 * Date : 2024.7.24<br>
 * <p>
 * solution2 : a clever math algorithm<br>
 */
public class E1969B {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        int testCount = scanner.nextInt();
        long[] results = new long[ testCount ];
        for( int i=0; i < testCount; i++ ) {
            String str = scanner.next();
            results[ i ] = solution( strategy, str );
        }

        for( int i=0; i < testCount; i++ )
            System.out.println( results[ i ] );
    }

    private static long solution( Strategy strategy, String str ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( str );
            default:
                return -1L;
        }
    }

    /**
     * Description : simple solution, simulate solution<br>
     * Complexity : time O( N ), space O( 1 )<br>
     * Idea : select the substring of many 1's and single 0
     * Idea : cyclically shift the substring, then increase the end
     * Idea : when increasing, skip over all 1's until the first 0
     *
     * @param str given binary string
     * @return result
     */
    private static long solution1( String str ) {

        String[] strs = str.split( "" );

        int prePoint = 0;
        while( prePoint < strs.length && strs[ prePoint ].equals( "0" ) )
            prePoint++;
        int sufPoint = prePoint;
        while( sufPoint < strs.length && strs[ sufPoint ].equals( "1" ) )
            sufPoint++;

        long cost = 0L;
        while( sufPoint < strs.length ) {
            cost += sufPoint - prePoint + 1;
            prePoint++;
            sufPoint++;
            while( sufPoint < strs.length && strs[ sufPoint ].equals( "1" ) )
                sufPoint++;
        }

        return cost;
    }

}
