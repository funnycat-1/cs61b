 /**
  * An SLList is a list of integers, which hides the terrible truth of the
  * nakedness within.
  */
public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;

    /** Default constructor creates an empty SLList. */
    public SLList() {
        sentinel = new IntNode(0, null);
        size = 0;
    }

    /** The constructor with parameter. */
    public SLList(int x) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Returns an SLList consisting of the given values. */
    public static SLList of(int... values) {
        SLList list = new SLList();
        // adding node to list from the last of the values so that the list is
        // the same sequence as values.
        for (int i = values.length - 1; i >= 0; i--) {
            list.addFirst(values[i]);
        }
        return list;
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Returns the first item in the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Return the value at the given index. */
    public int get(int index) {
        IntNode p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p.item;
    }

    /** Adds x to the end of the list. */
    public void addLast(int x) {
        size += 1;
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /** Adds x to the list at the specified index. */
    public void add(int index, int x) {
        if (index < 0 || index > size){
            //System.out.println("Index out of border.");
            return;
        }
        IntNode p = sentinel.next;
        for(int i = 0; i <= index; i++){
            if(p.next != null)
                p = p.next;
            else if(i == size) {
                p.next = new IntNode(x, null);
                size++;
                return ;
            }
            else {
                //System.out.println("Index out of border.");
                return;
            }
        }
        p.next = new IntNode(x, p.next);
        size++;
    }

    /** Returns the reverse of this list. This method is destructive. */
    public void reverse() {
        IntNode p = sentinel;
        SLList q = new SLList(p.item);
        if (p != null && p.next != null){
            while(p.next != null){
                q.addFirst(p.next.item);
                p = p.next;
            }
        }
        sentinel = q.sentinel;
    }
}
