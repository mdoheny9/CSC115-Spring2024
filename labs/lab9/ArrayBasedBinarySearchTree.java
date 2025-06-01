public class ArrayBasedBinarySearchTree extends ArrayBasedBinaryTree{

    public ArrayBasedBinarySearchTree() {
        super();
    }

    public void insert(Integer k) {
        if (data[0] == null) {
            data[0] = k;
        } else {
            insertRec(0, k);
        }
        size++;
    }

    private void insertRec(Integer i, Integer k) {
        if (k < data[i]) {
            if (data[getLeft(i)]!=null) {
                insertRec(getLeft(i), k);
            } else {
                data[getLeft(i)] = k;
            }
        } else {
            if (data[getRight(i)]!=null) {
                insertRec(getRight(i), k);
            } else {
                data[getRight(i)] = k;
            }
        }
    }

    
    public static void main(String[] args) {
        ArrayBasedBinarySearchTree emptyTree = new ArrayBasedBinarySearchTree();
        
        ArrayBasedBinarySearchTree myTree = new ArrayBasedBinarySearchTree();
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
    }

}
