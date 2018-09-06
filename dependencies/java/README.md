# Dependencies Exercise

Given a list of dependencies, e.g.:
```
[["a", "b"], ["b", "c"]]
```
Meaning:
- "a" depends on "b"
- "b" depends on "c"


The solver will produce a list of resolved dependencies where each item comes after its resolved dependencies.
For solution for the input above is:
```
["c", "b", "a"]
```

Explanation:
"a" depends on "b", so "b" must be resolved before "a"; And "b" depends on "c", so "c" is resolved before "b".

Note:
- Inputs are always provided as an Array of pairs of dependencies, just as described above.
- There may be more than one solution to a given input.
- It can be assumed that the input does not contain circular dependencies.

# Code
Please provide the code in the `Solver` class, which currently simply returns a stub `Array<String>`.
You're welcome to use the provided test and add to it as needed, see `SolverTest` class.
Please note that the provided test does not account for the potential complexity of all kinds of inputs.
The code should run and solve the given problem.

# Run
Run the test using:
```
./gradlew test
```

Good luck! :)
