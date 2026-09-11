// all of these are from lecture05
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
        return findKey(key, m_root);
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

}