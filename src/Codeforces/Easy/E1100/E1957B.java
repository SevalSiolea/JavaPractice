package Codeforces.Easy.E1100;

public class E1957B {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        int testCount = scanner.nextInt();
        int[][] results = new int[ testCount ][];
        for( int i=0; i < testCount; i++ ) {
            int length = scanner.nextInt();
            int sum = scanner.nextInt();
            results[ i ] = solution( strategy, length, sum );
        }

        for( int i=0; i < testCount; i++ ) {
            for ( int num : results[ i ] )
                System.out.print( num + " " );
            System.out.println();
        }
    }

    private static int[] solution( Strategy strategy, int length, int sum ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( length, sum );
            default:
                return new int[] {};
        }
    }

    private static int[] solution1( int length, int sum ) {

        if( length == 1 )
            return new int[] { sum };

        java.util.ArrayList<Integer> sumArrayList = new java.util.ArrayList<>();
        while( sum != 0 ) {
            sumArrayList.add( 0, sum % 2 );
            sum /= 2;
        }
        int[] sumBits = new int[ sumArrayList.size() ];
        for( int i=0; i < sumArrayList.size(); i++ )
            sumBits[ i ] = sumArrayList.get( i );


        int[] numBits1 = new int[ sumBits.length ];
        int[] numBits2 = new int[ sumBits.length ];
        boolean meetZero = false;
        for( int i = sumBits.length - 1; i >= 0; i-- )
            if( !meetZero ) {
                if ( sumBits[ i ] == 1 ) {
                    numBits1[ i ] = 0;
                    numBits2[ i ] = 1;
                } else {
                    numBits1[ i ] = 1;
                    numBits2[ i ] = 1;
                    meetZero = true;
                }
            } else {
                if( sumBits[ i ] == 0 ) {
                    numBits1[ i ] = 0;
                    numBits2[ i ] = 1;
                } else {
                    if( i == 0 ) {
                        numBits1[ i ] = 0;
                        numBits2[ i ] = 0;
                    } else {
                        numBits1[ i ] = 1;
                        numBits2[ i ] = 1;
                    }
                }
            }

        int[] result = new int[ length ];
        java.util.Arrays.fill( result, 0 );
        result[ 0 ] = countNum( numBits1 );
        result[ 1 ] = countNum( numBits2 );
        return result;
    }

    private static int countNum( int[] bitArr ) {
        int num = 0;
        for( int i=0; i < bitArr.length; i++ ) {
            num += bitArr[ i ];
            num <<= 1;
        }
        num >>= 1;
        return num;
    }

}
