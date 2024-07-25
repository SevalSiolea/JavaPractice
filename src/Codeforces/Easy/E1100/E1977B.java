package Codeforces.Easy.E1100;

public class E1977B {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        int testCount = scanner.nextInt();
        int[][] results = new int[ testCount ][];
        for( int i=0; i < testCount; i++ )
            results[ i ] = solution( strategy, scanner.nextInt() );

        for( int i=0; i < testCount; i++ ) {
            System.out.println( results[ i ].length );
            for( int digit : results[ i ] )
                System.out.print( digit + " " );
            System.out.println();
        }
    }

    private static int[] solution( Strategy strategy, int num ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( num );
            default:
                return new int[] {};
        }
    }

    private static int[] solution1( int num ) {

        int[] numCos = new int[ 16 ];
        for( int i = 15; i >= 0; i-- ) {
            numCos[ i ] = num % 4;
            num >>= 2;
        }

        for( int i = 15; i > 0; i-- ) {
            if ( numCos[ i ] == 2 && ( numCos[ i - 1 ] == -1 || numCos[ i - 1 ] == 1 || numCos[ i - 1 ] == 3 ) ) {
                numCos[ i ] = -2;
                numCos[ i - 1 ] += 1;
            }
            if ( numCos[ i ] == 3 ) {
                numCos[ i ] = -1;
                numCos[ i - 1 ] += 1;
            }
            if( numCos[ i ] == 4 ) {
                numCos[ i ] = 0;
                numCos[ i - 1 ] += 1;
            }
        }

        int[] bitNumCos = new int[ 32 ];
        java.util.Arrays.fill( bitNumCos, 0 );
        for( int i = 0; i < numCos.length; i++ )
            switch( numCos[ i ] ) {
                case -2:
                    bitNumCos[ 2 * i ] = -1;
                    bitNumCos[ 2 * i + 1 ] = 0;
                    break;
                case -1:
                    bitNumCos[ 2 * i ] = 0;
                    bitNumCos[ 2 * i + 1 ] = -1;
                    break;
                case 0:
                    bitNumCos[ 2 * i ] = 0;
                    bitNumCos[ 2 * i + 1 ] = 0;
                    break;
                case 1:
                    bitNumCos[ 2 * i ] = 0;
                    bitNumCos[ 2 * i + 1 ] = 1;
                    break;
                case 2:
                    bitNumCos[ 2 * i ] = 1;
                    bitNumCos[ 2 * i + 1 ] = 0;
                    break;
            }

        int length = 0;
        for( int i=0; i < bitNumCos.length; i++)
            if( bitNumCos[ i ] != 0 ) {
                length = 32 - i;
                break;
            }

        int[] result = new int[ length ];
        for( int i = 0; i < length; i++ )
            result[ i ] = bitNumCos[ 31 - i ];

        return result;
    }

}
