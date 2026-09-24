# Binary Search Tree (BST)

This project features a custom Java implementation of a Binary Search Tree (BST) data structure. It includes a robust set of tree operations and an interactive command-line interface (CLI) to manually build, manipulate, and analyze the tree.

## Features

* **Core BST Operations (`DSABinarySearchTree`)**:
  * **Insert & Delete:** Add new key-value pairs or remove existing ones (handles leaf node deletion, single-child deletion, and two-child deletion by promoting the successor).
  * **Search/Find:** Traverse the tree to find a specific node by its String key.
  * **Min & Max:** Iteratively discover the smallest and largest keys currently in the tree.
  * **Tree Metrics:** Calculate the current maximum height of the tree.
  * **Traversals:** Print the tree's contents using Depth-First Search (DFS) strategies:
    * In-order (Left, Root, Right)
    * Pre-order (Root, Left, Right)
    * Post-order (Left, Right, Root)
  * **Balance Calculation:** Computes a unique "balance percentage" score by comparing the actual number of nodes against the theoretical maximum number of nodes possible at the current tree height.

* **Interactive CLI (`main.java`)**:
  * A user-friendly menu to test all tree operations.
  * Includes a "Build fixed-tree" option that automatically populates the tree with a pre-configured, perfectly balanced set of nodes (keys: 10, 20, 30, 40, 50, 60, 70) for quick testing and visualization.
  * Robust error handling for invalid inputs and empty tree states.

## File Overview

* `DSABinarySearchTree.java`: The core data structure containing the `TreeNode` inner class and all recursive/iterative tree logic.
* `main.java` *(provided as main_2.java)*: The interactive test harness and menu system.
* `.gitignore_3`: Ignore file configuration to prevent compiled `.class` files from being tracked by version control.

## How to Run

1. Ensure the Java Development Kit (JDK) is installed.
2. Open a terminal and navigate to the project directory.
3. **Compile the program:**
   ```bash
   javac *.java
   ```
4. **Run the interactive menu:**
   ```bash
   java main
   ```
5. Follow the on-screen menu (options 1-9) to interact with the Binary Search Tree, or select `0` to exit.