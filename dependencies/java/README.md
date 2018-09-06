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
- There may be more than one solution to a given input.
- It can be assumed that the input does not contain circular dependencies.

# Code
Please provide the code in the `Solver` class, which currently simply returns a stub `Array<String>`.
You're welcome to use the provided (failing) test and add to it as needed, see `SolverTest` class.

# Run
Run the test using:
```
./gradlew test
```

Good luck! :)
