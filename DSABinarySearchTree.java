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

    public void BinarySearchTree() {
        m_root = null; 
    }

    //accessors
    public Object find(String key) {
        return findRec(key, m_root);
    }

    private Object findRec(String key, TreeNode currNode) {
        Object value = null;
        if(currNode == null)
            throw new NoSuchElementException("Key " + key + " not found"); // base case not found
        else if(key.equals(currNode.getKey()))
            value = currNode.getValue();                                   // base case found
        else if(key.compareTo(currNode.getKey()) < 0)
            value = findRec(key, currNode.getLeft());
        else
            value = findRec(key, currNode.getRight());
        return value;
    }

    private TreeNode insertRec(String key, TreeNode currNode, Object data) {
        TreeNode updateNode = currNode;
        if(currNode == null) {
            TreeNode newNode = new TreeNode(key, data);
            updateNode = newNode;
        }
        else if(key.equals(currNode.getKey()))
            throw new IllegalArgumentException("Duplicate key " + key);
        else if(key.compareTo(currNode.getKey()) < 0)
            currNode.setLeft(insertRec(key, currNode.getLeft(), data));
        else
            currNode.setRight(insertRec(key, currNode.getRight(), data));
        return updateNode;
    }

    private TreeNode deleteRec(String key, TreeNode currNode) {
        TreeNode updateNode = currNode;
        if(currNode == null)
            throw new NoSuchElementException("Key " + key + " not found");
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

    public int min(TreeNode currNode) {
        int minKey;
        while (currNode.getLeft() != null)
            currNode = currNode.getLeft();
        minKey = Integer.parseInt(currNode.getKey());
        return minKey;
    }

    public int max(TreeNode currNode) {
        int maxKey;
        while (currNode.getRight() != null)
            currNode = currNode.getRight();
        maxKey = Integer.parseInt(currNode.getKey());
        return maxKey;
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
    // taken from https://en.wikipedia.org/wiki/Day%E2%80%93Stout%E2%80%93Warren_algorithm
    //        and https://www.geeksforgeeks.org/dsa/day-stout-warren-algorithm-to-balance-given-binary-search-tree/
    public TreeNode balance() {
        TreeNode pseudoRoot = null;
        int size = treeToVine(pseudoRoot);
        vineToTree(pseudoRoot, size);
        m_root = pseudoRoot.getRight();
    }

    private int treeToVine(TreeNode root) {
        TreeNode tail = root;
        int count = 0;
        TreeNode rest = tail.getRight();
        while(rest != null){
            if(rest.getLeft() == null) {
                tail = rest;
                rest = rest.getRight();
                count++;
            } else {
                TreeNode temp = rest.getLeft();
                rest.setLeft(temp.getRight());
                temp.setRight(rest);
                rest = temp;
                tail.setRight(temp);
            }
        }
        return count;
    }

    private int log2(int n) {
        int result = (int)(Math.log(n) / Math.log(2));
        return result; 
    }

    private void compress(TreeNode root, int count) {

    }

    private vineToTree(TradeNode root, int size) {

    }


}