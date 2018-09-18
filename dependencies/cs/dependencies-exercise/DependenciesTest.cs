using Xunit;

namespace dependencies_exercise
{
    public class DependenciesTest
    {
        [Fact]
        public void ShouldSolveTheGivenDependencies()
        {
            string[,] dependencies = { { "a", "b" }, { "b", "c" } };

            string[] actual = Dependencies.Solve(dependencies);

            string[] expected = { "c", "b", "a" };

            Assert.Equal(expected, actual);
        }
    }
}
