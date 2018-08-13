import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolverTest {

    @Test
    public void shouldSolveTheGivenDependencies() {
        String[] actual = Solver.solve(new String[][]{
                new String[]{"a", "b"},
                new String[]{"b", "c"}
        });

        String[] expected = {"c", "b", "a"};

        assertArrayEquals(
                expected,
                actual
        );
    }

}
