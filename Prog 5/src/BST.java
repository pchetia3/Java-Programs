import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Your implementation of a binary search tree.
 *
 * @author Pallavi Chetia
 * @version 1.0
 * @userid pchetia3
 * @GTID 903139601
 */
public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES.
    private BSTNode<T> root;
    private int size;

    /**
     * A no-argument constructor that should initialize an empty BST.
     * DO NOT IMPLEMENT THIS CONSTRUCTOR!
     */
    public BST() {
    }

    /**
     * Initializes the BST with the data in the Collection. The data
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws IllegalArgumentException if data or any element in data is null
     */
    public BST(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("The data is null."
                    + " Please enter a valid data.");
        }
        size = 0;
        for (T each : data) {
            if (each == null) {
                throw new IllegalArgumentException("The data is null."
                        + " Please enter a valid data.");
            }
            add(each);
        }


    }

    @Override
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data is null."
                    + " Please enter a valid data.");
        }
        if (root == null) {
            root = new BSTNode<T>(data);
            size++;
        } else {
            add(data, root);
        }
    }

    /**
     * recursively finds the correct location of the data to be added
     * and adds it to the tree
     * @param data     data to add
     * @param thisRoot the root node of the subtree
     */
    private void add(T data, BSTNode<T> thisRoot) {
        int compare = data.compareTo(thisRoot.getData());
        if (compare > 0) {
            if (thisRoot.getRight() == null) {
                thisRoot.setRight(new BSTNode<T>(data));
                size++;
            } else {
                add(data, thisRoot.getRight());
            }
        } else if (compare < 0) {
            if (thisRoot.getLeft() == null) {
                thisRoot.setLeft(new BSTNode<T>(data));
                size++;
            } else {
                add(data, thisRoot.getLeft());
            }
        }
    }


    @Override
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data is empty. "
                    + "Please enter a valid data.");
        } else {
            BSTNode<T> dummy = new BSTNode<>(null);
            root = removeData(data, root, dummy);
            return dummy.getData();
        }

    }

    /**
     * removes the data and replaces it with its child if not a leaf
     * @param data the data to be removed
     * @param thisRoot the root of the subtree
     * @param dummy the dummy node that stores data to be removed
     * @return the node we replace thisRoot with
     */
    private BSTNode<T> removeData(T data,
                                  BSTNode<T> thisRoot, BSTNode<T> dummy) {

        if (thisRoot == null) {
            throw new java.util.NoSuchElementException("The data has not "
                    + "been found in the tree.");
        }

        int compare = data.compareTo(thisRoot.getData());

        if (compare < 0) {
            thisRoot.setLeft(removeData(data, thisRoot.getLeft(), dummy));
        } else if (compare > 0) {
            thisRoot.setRight(removeData(data, thisRoot.getRight(), dummy));
        } else {
            dummy.setData(thisRoot.getData());
            //if node is leaf
            if (thisRoot.getLeft() == null && thisRoot.getRight() == null) {
                size--;
                return null;
                //one child
            } else if (thisRoot.getLeft() == null
                    && thisRoot.getRight() != null) {
                size--;
                return thisRoot.getRight();

            } else if (thisRoot.getRight() == null
                    && thisRoot.getLeft() != null) {

                size--;
                return thisRoot.getLeft();
                // two child
            } else {
                //find Predecessor
                BSTNode<T> dummy1 = new BSTNode<>(null);
                BSTNode<T> node
                        = removeLargest(thisRoot.getLeft(), dummy1);
                thisRoot.setLeft(node);
                thisRoot.setData(dummy1.getData());
                size--;
            }
        }
        return thisRoot;
    }



    /**
     * finds the predecessor of the data to be removed
     * @param thisRoot the root of the subtree where
     *                 you want to find the predecessor
     * @param dummy the dummy node that stores the predecessor
     * @return root node of the new subtree with the predecessor removed
     */
    private BSTNode<T> removeLargest(BSTNode<T> thisRoot, BSTNode<T> dummy) {
        if (thisRoot.getRight() == null) {
            dummy.setData(thisRoot.getData());
            return thisRoot.getLeft();
        }
        thisRoot.setRight(removeLargest(thisRoot.getRight(), dummy));
        return thisRoot;
    }


    @Override
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data is null. "
                    + "Please enter a valid data that is not empty. ");
        }
        if (root == null) {
            throw new java.util.NoSuchElementException("The data has not "
                    + "been found in the tree.");
        }
        return getData(root, data);
    }

    /**
     * recursively finds the data in the tree
     * @param thisRoot the root of the subtree
     * @param data the data to be found
     * @return the data to be found and returned
     */
    private T getData(BSTNode<T> thisRoot, T data) {
        if (thisRoot == null) {
            throw new java.util.NoSuchElementException("The data has not "
                    + "been found in the tree.");
        }
        int compare = data.compareTo(thisRoot.getData());
        if (compare < 0) {
            if (thisRoot.getLeft() != null) {
                return getData(thisRoot.getLeft(), data);
            } else {
                throw new java.util.NoSuchElementException("The data has not "
                        + "been found in the tree.");
            }
        } else if (compare > 0) {
            if (thisRoot.getRight() != null) {
                return getData(thisRoot.getRight(), data);
            } else {
                throw new java.util.NoSuchElementException("The data has not "
                        + "been found in the tree.");
            }
        }
        return thisRoot.getData();
    }

    @Override
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data is empty. "
                    + "Please enter a valid data that is not empty.");
        }
        if (size == 0) {
            return false;
        }
        return containsData(root, data);

    }

    /**
     * a method that returns true if the tree contains the data
     * @param thisRoot the root of the subtree
     * @param data the data to be checked for
     * @return a boolean that is true if the tree contains the data
     */
    private boolean containsData(BSTNode<T> thisRoot, T data) {
        int compare = data.compareTo(thisRoot.getData());
        if (compare < 0) {
            if (thisRoot.getLeft() != null) {
                return containsData(thisRoot.getLeft(), data);
            } else {
                return false;
            }
        } else if (compare > 0) {
            if (thisRoot.getRight() != null) {
                return containsData(thisRoot.getRight(), data);
            } else {
                return false;
            }
        }
        return true;
    }


    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD
        return size;
    }

    @Override
    public List<T> preorder() {
        List<T> preTraversalList = new ArrayList<T>(size);
        if (root != null) {
            preTraversalList.add(root.getData());
            preOTraversal(preTraversalList, root);
        }
        return preTraversalList;

    }

    /**
     * traverses the tree in preorder
     * @param preTraversalList the list of elements in preorder
     * @param thisRoot the root of the subtree
     */
    private void preOTraversal(List<T> preTraversalList,
                               BSTNode<T> thisRoot) {

        if (thisRoot.getLeft() != null) {
            preTraversalList.add(thisRoot.getLeft().getData());
            preOTraversal(preTraversalList, thisRoot.getLeft());
        }
        if (thisRoot.getRight() != null) {
            preTraversalList.add(thisRoot.getRight().getData());
            preOTraversal(preTraversalList, thisRoot.getRight());
        }
    }

    @Override
    public List<T> postorder() {
        List<T> postTraversalList = new ArrayList<T>();
        if (root != null) {
            postOTraversal(postTraversalList, root);
        }
        return postTraversalList;

    }

    /**
     * traverses the tree in postorder
     * @param postTraversalList the list of elements
     * @param thisRoot the root of the subtree that needs to be traversed
     */
    private void postOTraversal(List<T> postTraversalList,
                                BSTNode<T> thisRoot) {

        if (thisRoot.getLeft() != null) {
            postOTraversal(postTraversalList, thisRoot.getLeft());
        }
        if (thisRoot.getRight() != null) {
            postOTraversal(postTraversalList, thisRoot.getRight());
        }
        postTraversalList.add(thisRoot.getData());
    }

    @Override
    public List<T> inorder() {
        List<T> inTraversalList = new ArrayList<T>();
        if (root != null) {
            inOTraversal(inTraversalList, root);
        }
        return inTraversalList;

    }

    /**
     * traverses the tree in inorder
     * @param inTraversalList the list of elements
     * @param thisRoot        the root of the subtree to be traversed
     */
    private void inOTraversal(List<T> inTraversalList, BSTNode<T> thisRoot) {

        if (thisRoot.getLeft() != null) {
            inOTraversal(inTraversalList, thisRoot.getLeft());
        }
        inTraversalList.add(thisRoot.getData());

        if (thisRoot.getRight() != null) {
            inOTraversal(inTraversalList, thisRoot.getRight());
        }

    }


    @Override
    public List<T> levelorder() {
        ArrayList<T> list = new ArrayList<T>();
        Queue<BSTNode<T>> levelQ = new LinkedList<BSTNode<T>>();
        if (root != null) {
            levelQ.add(root);
            levelorder(list, levelQ);
        }
        return list;
    }

    /**
     * a level ordered traversal
     * @param list   list of elements
     * @param levelQ queue of nodes
     */
    private void levelorder(List<T> list, Queue<BSTNode<T>> levelQ) {
        BSTNode<T> thisNode = levelQ.poll();
        if (thisNode != null) {
            list.add(thisNode.getData());
            if (thisNode.getLeft() != null) {
                levelQ.add(thisNode.getLeft());
            }
            if (thisNode.getRight() != null) {
                levelQ.add(thisNode.getRight());
            }
            levelorder(list, levelQ);
        }
    }

    @Override
    public List<T> listLeavesDescending() {
        List<T> leavesList = new ArrayList<>();
        return leaves(root, leavesList);
    }

    /**
     * returns a list of leaf nodes in decreasing order
     * @param thisRoot   the root of the subtree
     * @param leavesList the list containing all the data in the leaf nodes
     * @return a list containing the data in leaves in decreasing order.
     */
    private List<T> leaves(BSTNode<T> thisRoot, List<T> leavesList) {
        if (thisRoot != null) {
            if (thisRoot.getLeft() == null && thisRoot.getRight() == null) {
                leavesList.add(thisRoot.getData());
            }
            leaves(thisRoot.getRight(), leavesList);
            leaves(thisRoot.getLeft(), leavesList);
        }
        return leavesList;
    }


    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public int height() {
        return treeHeight(root);
    }

    /**
     * returns the height of the tree
     * @param thisNode the root of the subtree whose
     *                 height has to be calculate
     * @return an int that represents the height of the tree
     */
    private int treeHeight(BSTNode<T> thisNode) {
        if (thisNode == null) {
            return -1;
        } else {
            return Math.max(treeHeight(thisNode.getLeft()),
                    treeHeight(thisNode.getRight())) + 1;
        }

    }


    @Override
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }
}
