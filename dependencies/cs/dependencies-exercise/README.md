# dependencies exercise

## The Problem
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

## General Requirements
- Code should be runnable and solve the problem
- Add tests as you see fit
- Note that there may be mutliple correct solution to a given input
- Can assume that the input does not contain circular dependencies

## Run
Run the unit tests by going to the "Run" menu -> "Run Unit Tests".
See test results by navigating to the "Test Results" tab at the bottom.