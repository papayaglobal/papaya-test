import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolverTest {

    @Test
    public void shouldSolveTheGivenDependencies() {
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"}
        };

        assertArrayEquals(
                new String[]{"c", "b", "a"},
                Solver.solve(dependencies)
        );
    }

}
