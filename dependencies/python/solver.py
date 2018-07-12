flatten = lambda l: [item for sublist in l for item in sublist]

def solve(dependencies):
    return flatten(dependencies)