import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SolverTest {

    @Test
    public void shouldSolveTheGivenDependencies() {
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"}
        };

        String[] expected = {"c", "b", "a"};
        String[] actual = Solver.solve(dependencies);
        String failMsg = "expected " + Arrays.toString(actual) + " to equal " + Arrays.toString(expected);

        assertArrayEquals(
                failMsg,
                expected,
                actual
        );
    }

}
