import java.util.Arrays;
import java.util.stream.Stream;

final class Solver {

    static String[] solve(String[][] dependencies) {
        return incorrectlySolve(dependencies);
    }

    private static String[] incorrectlySolve(String[][] dependencies) {
        return flatten(dependencies)
                .distinct()
                .toArray(String[]::new);
    }

    private static <T> Stream<T> flatten(T[][] twoDArray) {
        return Arrays
                .stream(twoDArray)
                .flatMap(Arrays::stream);
    }

}
