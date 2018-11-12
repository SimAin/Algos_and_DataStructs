//
public class ListNode {

    private ListNode next;
    private String data;

    public ListNode (ListNode next, String data) {
        this.next = next;
        this.data = data;
    }

    //TODO: write test method in testClass
    // Get data for current node.
    public String getData () {
        return data;
    }

    //TODO: write test method in testClass
    // Get next node.
    public ListNode getNext () {
        return next;
    }

    //TODO: write test method in testClass
    // Set vale of next node
    public void setNext (ListNode next) {
        this.next = next;
    }

    //TODO: write test method in testClass
    // Return data in node
    public String get (int i) {
        ListNode current = this;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == i) {
                return current.getData ();
            }
            currentIndex += 1;
            current = current.getNext ();
        }
        throw new ArrayIndexOutOfBoundsException (i); // <1>
    }

    //TODO: write test method in testClass
    // Set value in current node
    public void set (int i, String newData) {
        ListNode current = this;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == i) {
                current.data = newData;
            }
            currentIndex += 1;
            current = current.getNext ();
        }
        throw new ArrayIndexOutOfBoundsException (i); // <1>
    }

    //TODO: write test method in testClass
    // Inset node into list.
    public ListNode insert (String data, int index) {
        ListNode current = this;
        int currentIndex = 0;
        if (index < 0) { // check index is positive
            throw new ArrayIndexOutOfBoundsException (index);
        }

        if (index == 0) {
            return new ListNode (current, data);
        }

        while (current != null) {
            if (currentIndex+1 == index) {
                ListNode insertedNode = new ListNode (current.getNext(), data);
                current.next = insertedNode;
                return this;
            }
            currentIndex += 1;
            current = current.getNext ();
        }
        throw new ArrayIndexOutOfBoundsException (index);
    }

    //TODO: write test method in testClass
    // Delete node in list
    public ListNode delete (int index) {
        ListNode current = this;
        int currentIndex = 0;

        if (index == 0) {
            return next;
        }

        while (current != null) {
            if (currentIndex+1 == index) {
                current.setNext ( current.getNext().getNext());

                return this; // remember, the delete method was called on the first item
            }
            currentIndex += 1;
            current = current.getNext ();
        }
        throw new ArrayIndexOutOfBoundsException (index);
    }

    //TODO: write test method in testClass
    // Take data, create node and place it in last item
    public void join (String data) {
        ListNode current = this;

        // walk the list to find the last item
        while (current.getNext () != null) {
            current = current.getNext ();
        }

        // make a new node from data and place it in the lastItem
        current.setNext (new ListNode (null, data));
    }

    //TODO: write test method in testClass
    // Creates a printable string of the array.
    public String toString() throws ArrayIndexOutOfBoundsException {
        String result = "[" + this.getData() + ", ";
        while (this.next != null) {
            result = result + this.next.getData() + ", ";
            this.next = this.next.getNext ();   // <3>
        }
        result = result + "]";
        return result;
    }

    // Main method to run and demo methods.
    public static void main (String[] args){
        ListNode lastItem = new ListNode (null, "last item");
        //ListNode middleItem = new ListNode (lastItem, "middle item");
        //ListNode firstItem = new ListNode (middleItem, "first item");
        //ListNode.join("Frank");
        //ListNode current = firstItem;     // <1>

        /*while (current != null) {         // <2>
            System.out.println (current.getData ());

            current = current.getNext ();   // <3>
        }*/


        ListNode myList = lastItem;
        myList.join ("new last item");
        System.out.println ("New list: " + myList);

    }


}
