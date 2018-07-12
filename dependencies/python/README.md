# Dependencies Solver Exercise

Given a list of dependencies, e.g.:
```
[["a", "b"], ["b", "c"]]
```
meaning:
- "a" depends on "b"
- "b" depends on "c"

The solver will produce a list of resolved dependencies where each item comes after its resolved dependencies, e.g.:
```
["c", "b", "a"]
```

# Run the T ests
```
$ python solvertest.py
```