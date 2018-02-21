import java.util.Iterator;

/**
* MinionList class.
* @author Heather
* @version 1
*/
public class MinionList implements Iterable<Minion>,
    MinionQueue, MinionStack {

    private Node head;


    /**
     * Node class.
     */
    private class Node {
        private Minion data;
        private Node next;

        public Node(Minion data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * MinionIterator class.
     */
    private class MinionIterator implements Iterator<Minion> {
        private int current = 0;
        private Node currentNode = head;


        /**
        * a method that returns true if the element has a next element.
        * @return true if a next element is present; false otherwise.
        */
        public boolean hasNext() {
            if (current < size()) {
                return true;
            }
            return false;
        }
        /**
        * a method that returns the next element.
        * @return next element in the list; null if the next element is
        * not present.
        */
        public Minion next() {
            if (!hasNext()) {
                return null;
            }
            return currentNode.next.data;
        }
    }
    /**
    * a method that call the iterator for MinionList.
    * @return MinionIterator which iterates through the list.
    */
    public Iterator<Minion> iterator() {
        return new MinionIterator();
    }

    /**
     * Checks if list is empty.
     * @return true if this list has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }


    //Use recursion for the rest of the code
    //FIFO
    /**
     * Add a Minion to the back of the queue.
     *
     * @param m the Minion to add.
     * @throws IllegalArgumentException if Minion is null
     */

    public void enqueue(Minion m) throws IllegalArgumentException {
        Node current = head;
        Node newNode = new Node(m, null);
        if (m == null) {
            throw new IllegalArgumentException("No such Minion exists!");
        }
        if (head == null) {
            head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode = current;
        }
    }




    /*/**
     * Remove a Minion from the queue.
     *
     * @return the Minion from the front of the queue.
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public Minion dequeue() throws java.util.NoSuchElementException {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("This queue is empty!");
        }
        Node temp = head;
        head = head.next;

        return temp.data;
    }

    //FILO
     /**
     * Push a Minion on to the stack.
     *
     * @param m the Minion to push.
     * @throws IllegalArgumentException if data is null.
     */
    public void push(Minion m) throws IllegalArgumentException {
        Node newNode = new Node(m, null);
        if (m == null) {
            throw new IllegalArgumentException("No such Minion exists!");
        }
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

    }

    /**
     * Pop from the stack.
     *
     * @return the Minion from the top of the stack
     * @throws java.util.NoSuchElementException if the stack is empty.
     */
    public Minion pop() throws java.util.NoSuchElementException {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("No such"
                + "element exists!");
        }
        Node temp = head;
        head = head.next;
        return temp.data;
    }

    //helper method that iterates through nodes to reach the one with index i.
    //used in get(i).
    //private int j = size;
    private Minion getHelper(int i, Node node) { // Helper Method

        if (i == 0) {
            return node.data;
        } else {
            return getHelper(i - 1, node.next);
        }
    }
    /**
    * a method that returns the element at the ith position in the MinionList.
    * @return getHelper method that takes in the ith index and a node to
    * return the element at the ith position.
    * @param i the index at which the element needs to be found.
    */
    public Minion get(int i) {
        if (head == null) {
            return null;
        } else {
            Node node = head;
            return getHelper(i, head);
        }
    }


    private String toStringHelper(Node node, String result) {

        if (node.next != null) {
            result += node.data.getName() + ",";
            return result + toStringHelper(node.next, "");
        } else {
            result += node.data.getName() + ",";
            return result + "]";
        }
    }

    /**
    * returns a String representation of the list in this format:
    * “[minion1,minion2,minion3,]”.
    * @return toStringHelper method that takes in a node and a string to return
    * a string representation of the MinionList
    */
    public String toString() {
        String result = "[";
        return toStringHelper(head, result);

    }

    private int sizeHelper(Node node, int counter) {

        if (node.next != null) {
            counter++;
            return sizeHelper(node.next, counter);
        } else {
            return counter++;
        }

    }
    /**
    * a method that returns the number of elements in the MinionList.
    * @return sizeHelper method that takes in a node and counter to count the
    * number of elements in the MinionList.
    */

    public int size() {
        int counter = 1;
        return sizeHelper(head, counter);

    }

    /*Returns a new MinionList with the same elements as
    this MinionList but whose elements are in reverse order
    from this MinionList.
    For example for the list [minion1, minion2, minion3]
    this method would return [minion3, minion2, minion1].*/
    private MinionList reverseHelper(Node node, MinionList list) {

        if (node.next != null) {
            list.push(node.data);
            reverseHelper(node.next, list);
        } else {
            list.push(node.data);
        }
        return list;
    }
    /**
    * Returns a new MinionList with the same elements as
    * this MinionList but whose elements are in reverse order
    * from this MinionList.
    * @return reverseHelper method that takes in a node and a minionlist to
    * reverse the number of elements in the MinionList.
    */
    public MinionList reverse() {
        MinionList list = new MinionList();
        return reverseHelper(head, list);
    }

}