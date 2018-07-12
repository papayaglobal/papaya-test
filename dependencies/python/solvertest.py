import unittest
from solver import *

class SolverTest(unittest.TestCase):
    def test_dependencies_resolved(self):
        self.assertEqual(solve([["a", "b"], ["b", "c"]]), ["c", "b", "a"])

if __name__ == '__main__':
    unittest.main()