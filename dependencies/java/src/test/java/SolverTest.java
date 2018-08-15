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

        String[] expecteds = {"c", "b", "a"};
        String[] actuals = Solver.solve(dependencies);
        String failMsg = "expected " + Arrays.toString(actuals) + " to equal " + Arrays.toString(expecteds);

        assertArrayEquals(
                failMsg,
                expecteds,
                actuals
        );
    }

}
