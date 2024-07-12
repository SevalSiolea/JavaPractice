package Codeforces;

public class Template {

    private enum solution { solution1, solution2, solution3 }

    public static void main( String[] args ) {
        solution( solution.solution1 );
    }

    private static void solution( solution solution ) {
        switch( solution ) {
            case solution1:
                solution1();
                break;
            case solution2:
                solution2();
                break;
            case solution3:
                solution3();
                break;
        }
    }

    private static void solution1() {}

    private static void solution2() {}

    private static void solution3() {}

}