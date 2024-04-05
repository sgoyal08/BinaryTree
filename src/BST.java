import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return helpSearch(val, this.root);
    }
    public boolean helpSearch(int val, BSTNode curNode)
    {
        if (curNode == null)
        {
            return false;
        }
        if (val < curNode.getVal())
        {
            return helpSearch(val, curNode.getLeft());
        }
        if (val > curNode.getVal())
        {
            return  helpSearch(val, curNode.getRight());
        }
        if (val == curNode.getVal())
        {
            return true;
        }
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> inOrder = new ArrayList<>();
        helpInOrder(this.root, inOrder);
        return inOrder;
    }
    public void helpInOrder(BSTNode curNode, ArrayList<BSTNode> inOrder)
    {
       if (curNode!= null) {
           helpInOrder(curNode.getLeft(), inOrder);
           inOrder.add(curNode);
           helpInOrder(curNode.getRight(), inOrder);
       }
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> preOrder = new ArrayList<>();
        helpPreOrder(this.root, preOrder);
        return preOrder;

    }
    public void helpPreOrder(BSTNode curNode, ArrayList<BSTNode> preOrder)
    {
        if (curNode!= null)
        {
            preOrder.add(curNode);
            helpPreOrder(curNode.getLeft(), preOrder);
            helpPreOrder(curNode.getRight(), preOrder);
        }
    }



    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> postOrder = new ArrayList<>();
        helpPreOrder(this.root, postOrder);
        return postOrder;
    }
    public void helpPostOrder(BSTNode curNode, ArrayList<BSTNode> postOrder)
    {
        if (curNode!= null)
        {
            helpPostOrder(curNode.getLeft(), postOrder);
            helpPostOrder(curNode.getRight(), postOrder);
            postOrder.add(curNode);
        }
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        this.root = helpInsert(val, this.root);
    }
    public BSTNode helpInsert (int val, BSTNode curNode)
    {
        if (curNode == null)
        {
            return new BSTNode(val);
        }
        if (val < curNode.getVal())
        {
            curNode.setLeft(helpInsert(val, curNode.getLeft()));
        }
        if (val > curNode.getVal())
        {
            curNode.setRight(helpInsert(val, curNode.getRight()));
        }
        return curNode;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
