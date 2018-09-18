using System.Linq;

namespace dependencies_exercise
{
    static class Dependencies
    {
        internal static string[] Solve(string[,] dependencies)
        {
            return dependencies.Cast<string>().ToArray();
        }
    }
}