import java.lang.Math;

// import javax.swing.tree.TreeNode;
/*
 * RefBasedBinarySearchTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinarySearchTree extends RefBasedBinaryTree {

    public RefBasedBinarySearchTree() {
        super();
    }

    public void insert(Integer k) {
        if (root == null) {
            root = new TreeNode(k);
            
        } else {
            insertRec(root, k);
        }
    }

    private void insertRec(TreeNode cur, Integer k) {
        if (k < cur.getValue()) {
            if (cur.getLeft()!=null) {
                insertRec(cur.getLeft(), k);
            } else {
                TreeNode t = new TreeNode(k);
                cur.setLeft(t);
            }
        } else {
            if (cur.getRight()!=null) {
                insertRec(cur.getRight(), k);
            } else {
                TreeNode t = new TreeNode(k);
                cur.setRight(t);
            }
        }
    }

    

    public static void main(String[] args) {
        // use these trees to test the methods you will implement
        RefBasedBinarySearchTree emptyTree = new RefBasedBinarySearchTree();
        RefBasedBinarySearchTree myTree = new RefBasedBinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(0);
        myTree.insert(4);
        myTree.insert(6);
        
        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();
        
        System.out.println("toString\n" + myTree);

        int sum = myTree.sum();
        System.out.println(sum);

        boolean found = myTree.find(7);
        System.out.println(found);

        boolean found2 = myTree.find(10);
        System.out.println(found2);

        try {
            System.out.println(myTree.getMax());
        } catch (TreeEmptyException e) {
            System.out.println("tree not empty");
        }

        try {
            System.out.println(emptyTree.getMax());
        } catch (TreeEmptyException e) {
            System.out.println("tree empty");
        }
    }
    }

