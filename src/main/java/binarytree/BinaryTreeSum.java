package binarytree;
// TreeNode class
class TreeNode {
    int value; // Value of the node
    int sumBelow; // Sum of all nodes below this node
    TreeNode left; // Left child
    TreeNode right; // Right child

    // Constructor
    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.sumBelow = 0; // Initial sum below is 0
    }

    // Method to calculate the sum of all nodes below this node (excluding this node)
    int calculateSumBelow() {
        // Calculate sum of left and right subtrees
        int leftSum = (left != null) ? left.calculateSumBelow() + left.value : 0;
        int rightSum = (right != null) ? right.calculateSumBelow() + right.value : 0;

        // Update sumBelow for this node
        sumBelow = leftSum + rightSum;
        return sumBelow;
    }

    // Method to calculate the sum of all nodes below this node
    int calculateSumBelow2() {
        // Calculate sum of left and right subtrees
        int leftSum = (left != null) ? left.calculateSumBelow() : 0;
        int rightSum = (right != null) ? right.calculateSumBelow() : 0;

        // Update sumBelow for this node
        sumBelow = value + leftSum + rightSum;
        return sumBelow;
    }
}

// Main class
public class BinaryTreeSum {
    public static void main(String[] args) {
        // Create nodes
        TreeNode root = new TreeNode(1);
        TreeNode leftChild = new TreeNode(2);
        TreeNode rightChild = new TreeNode(3);
        TreeNode leftLeftChild = new TreeNode(4);
        TreeNode leftRightChild = new TreeNode(5);
//        TreeNode rightLeftChild = new TreeNode(0);
        TreeNode rightRightChild = new TreeNode(6);

        // Link nodes to form the tree
        root.left = leftChild;
        root.right = rightChild;
        leftChild.left = leftLeftChild;
        leftChild.right = leftRightChild;
//        rightChild.left = rightLeftChild;
        rightChild.right = rightRightChild;

        // Calculate the sum of nodes below each node
        root.calculateSumBelow();

        // Print the sum of nodes below each node
        printTree(root);
    }

    // Method to print the tree and sums
    static void printTree(TreeNode node) {
        if (node != null) {
            System.out.println("Node value: " + node.value + ", Sum below: " + node.sumBelow);
            printTree(node.left);
            printTree(node.right);
        }
    }
}
