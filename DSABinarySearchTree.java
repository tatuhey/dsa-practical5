// all of these are from lecture05

import java.util.NoSuchElementException;

public class DSABinarySearchTree {
    private class TreeNode {
        private String m_key;
        private Object m_value;
        private TreeNode m_leftChild;
        private TreeNode m_rightChild;

        public TreeNode(String inKey, Object inVal) {
            if(inKey == null)
                throw new IllegalArgumentException("Key cannot be null");
            m_key = inKey;
            m_value = inVal;
            m_rightChild = null;
            m_leftChild = null;
        }

        //accessors
        public String getKey() {
            return m_key;
        }
        public Object getValue() {
            return m_value;
        }
        public TreeNode getLeft() {
            return m_leftChild;
        }
        public TreeNode getRight() {
            return m_rightChild;
        }

        //mutators
        public void setLeft(TreeNode newLeft) {
            m_leftChild = newLeft;
        }
        public void setRight(TreeNode newRight) {
            m_rightChild = newRight;
        }
    }

    private TreeNode m_root;

    public DSABinarySearchTree() {
        m_root = null; 
    }

    //accessors
    public Object find(String key) {
        return findRec(key, m_root);
    }

    private Object findRec(String key, TreeNode currNode) {
        Object value = null;
        if(currNode == null)
            System.out.println("Key " + key + " not found");
        else if(key.equals(currNode.getKey()))
            value = currNode.getValue();                                   // base case found
        else if(key.compareTo(currNode.getKey()) < 0)
            value = findRec(key, currNode.getLeft());
        else
            value = findRec(key, currNode.getRight());
        return value;
    }

    public void insert(String key, Object data) {
        m_root = insertRec(key, m_root, data);
    }

    private TreeNode insertRec(String key, TreeNode currNode, Object data) {
        if(currNode == null) {
            return new TreeNode(key, data);
        }
        else if(key.equals(currNode.getKey()))
            throw new IllegalArgumentException("Duplicate key " + key);
        else if(key.compareTo(currNode.getKey()) < 0)
            currNode.setLeft(insertRec(key, currNode.getLeft(), data));
        else
            currNode.setRight(insertRec(key, currNode.getRight(), data));
        return currNode;
    }

    public void delete(String key) {
        m_root = deleteRec(key, m_root);
    }

    private TreeNode deleteRec(String key, TreeNode currNode) {
        TreeNode updateNode = currNode;
        if(currNode == null)
            System.out.println("Tree is empty");
        else if(key.equals((currNode.getKey())))
            updateNode = deleteNode(key, currNode);
        else if(key.compareTo(currNode.getKey()) < 0)
            currNode.setLeft(deleteRec(key, currNode.getLeft()));
        else 
            currNode.setRight(deleteRec(key, currNode.getRight()));
        return updateNode;
    }

    private TreeNode deleteNode(String key, TreeNode delNode) {
        TreeNode updateNode = null;
        if(delNode.getLeft() == null && delNode.getRight() == null)
            updateNode = null;
        else if(delNode.getLeft() != null && delNode.getRight() == null)
            updateNode = delNode.getLeft();
        else if(delNode.getLeft() == null && delNode.getRight() != null)
            updateNode = delNode.getRight();
        else {
            updateNode = promoteSuccessor(delNode.getRight());
            if(updateNode != delNode.getRight())
                updateNode.setRight(delNode.getRight());
            updateNode.setLeft(delNode.getLeft());
        }
        return updateNode;
    }

    private TreeNode promoteSuccessor(TreeNode currNode) {
        TreeNode successor = currNode;
        if(currNode.getLeft() != null) {
            successor = promoteSuccessor(currNode.getLeft());
            if(successor == currNode.getLeft())
                currNode.setLeft(successor.getRight());
        }
        return successor;
    }

    // do min() max() height() and balance()
    // gonna do iterative for min max because it is preferred

    // public int min(TreeNode currNode) {
    //     int minKey;
    //     while (currNode.getLeft() != null)
    //         currNode = currNode.getLeft();
    //     minKey = Integer.parseInt(currNode.getKey());
    //     return minKey;
    // }

    public String min() {
        if(m_root == null)
            throw new NoSuchElementException("Tree is empty");
        TreeNode currNode = m_root;
        while(currNode.getLeft() != null)
            currNode = currNode.getLeft();
        return currNode.getKey();
    }

    // public int max(TreeNode currNode) {
    //     int maxKey;
    //     while (currNode.getRight() != null)
    //         currNode = currNode.getRight();
    //     maxKey = Integer.parseInt(currNode.getKey());
    //     return maxKey;
    // }

    public String max() {
        if(m_root == null)
            throw new NoSuchElementException("Tree is empty");
        TreeNode currNode = m_root;
        while(currNode.getRight() != null)
            currNode = currNode.getRight();
        return currNode.getKey();
    }

    public int height() {
        return heightRec(m_root);
    }

    public int heightRec(TreeNode currNode) {
        int htSoFar, iLeftHt, iRightHt;
        if(currNode == null)
            htSoFar = -1;
        else {
            iLeftHt = heightRec(currNode.getLeft());
            iRightHt = heightRec(currNode.getRight());
            if(iLeftHt > iRightHt)
                htSoFar = iLeftHt + 1;
            else
                htSoFar = iRightHt + 1;
        }
        return htSoFar;
    }

    // balance()

    // inOrder(), preOrder(), and postOrder()
    // https://www.w3schools.com/dsa/dsa_algo_binarytrees_inorder.php
    public void inOrder() {
        if(m_root == null) {
            System.out.println("Tree is empty");
            return;
        }
        inOrderRec(m_root);
        System.out.println();
    }

    public void inOrderRec(TreeNode currNode) {
        if(currNode == null)
            return; // best case. end of branch reached
        inOrderRec(currNode.getLeft());
        System.out.print(currNode.getKey() + ", ");
        inOrderRec(currNode.getRight());
    }

    // https://www.w3schools.com/dsa/dsa_algo_binarytrees_preorder.php
    public void preOrder() {
        if(m_root == null) {
            System.out.println("Tree is empty");
            return;
        }
        preOrderRec(m_root);
        System.out.println();
    }

    public void preOrderRec(TreeNode currNode) {
        if(currNode == null)
            return;
        System.out.print(currNode.getKey() + ", ");
        preOrderRec(currNode.getLeft());
        preOrderRec(currNode.getRight());
    }

    // https://www.w3schools.com/dsa/dsa_algo_binarytrees_postorder.php
    public void postOrder() {
        if(m_root == null) {
            System.out.println("Tree is empty");
            return;
        }
        postOrderRec(m_root);
        System.out.println();
    }

    public void postOrderRec(TreeNode currNode) {
        if(currNode == null)
            return;
        postOrderRec(currNode.getLeft());
        postOrderRec(currNode.getRight());
        System.out.print(currNode.getKey() + ", ");
    }

    // https://www.w3schools.com/dsa/dsa_data_binarytrees.php
    public void buildFixedTree() {
        TreeNode node70 = new TreeNode("70", null);
        TreeNode node30 = new TreeNode("30", null);
        TreeNode node50 = new TreeNode("50", null);
        TreeNode node10 = new TreeNode("10", null);
        TreeNode node20 = new TreeNode("20", null);
        TreeNode node40 = new TreeNode("40", null);
        TreeNode node60 = new TreeNode("60", null);

        node70.setLeft(node30);
        node70.setRight(node50);

        node30.setLeft(node10);
        node30.setRight(node20);

        node50.setLeft(node40);
        node50.setRight(node60);

        m_root = node70;
    }

    // TO BALANCE**
    // taken from https://en.wikipedia.org/wiki/Day%E2%80%93Stout%E2%80%93Warren_algorithm
    //        and https://www.geeksforgeeks.org/dsa/day-stout-warren-algorithm-to-balance-given-binary-search-tree/
    // public TreeNode balance() {
    //     TreeNode pseudoRoot = null;
    //     int size = treeToVine(pseudoRoot);
    //     vineToTree(pseudoRoot, size);
    //     m_root = pseudoRoot.getRight();
    // }

    // private int treeToVine(TreeNode root) {
    //     TreeNode tail = root;
    //     int count = 0;
    //     TreeNode rest = tail.getRight();
    //     while(rest != null){
    //         if(rest.getLeft() == null) {
    //             tail = rest;
    //             rest = rest.getRight();
    //             count++;
    //         } else {
    //             TreeNode temp = rest.getLeft();
    //             rest.setLeft(temp.getRight());
    //             temp.setRight(rest);
    //             rest = temp;
    //             tail.setRight(temp);
    //         }
    //     }
    //     return count;
    // }

    // private int log2(int n) {
    //     int result = (int)(Math.log(n) / Math.log(2));
    //     return result; 
    // }

    // private void compress(TreeNode root, int count) {

    // }

    // private vineToTree(TradeNode root, int size) {

    // }


}