 /**
  * A DLList is a list of integers. Like SLList, it also hides the terrible
  * truth of the nakedness within, but with a few additional optimizations.
  */
public class DLList<myType> {
    private class Node {
        public Node prev;
        public myType item;
        public Node next;

        public Node(myType i, Node p, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private Node sentinel;
    private int size;

    /** Creates an empty DLList. */
    public DLList() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /** Returns a DLList consisting of the given values. */
    public static <myType> DLList of(myType... values) {
        DLList<myType> list = new DLList<>();
        for (myType value : values) {
            list.addLast(value);
        }
        return list;
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /** Adds item to the front of the list. */
    public void addFirst(myType item) {
        Node n = new Node(item, sentinel, sentinel.next);
        n.next.prev = n;
        n.prev.next = n;
        size += 1;
    }

    /** Adds item to the back of the list. */
    public void addLast(myType item) {
        Node n = new Node(item, sentinel.prev, sentinel);
        n.next.prev = n;
        n.prev.next = n;
        size += 1;
    }

    // 对于指针的理解要清晰!!!
    /** Adds item to the list at the specified index. */
    public void add(int index, myType item) {
        Node p = sentinel.next;
        if(index >= size){
            addLast(item);
            return;
        }
        for(int i = 0; i <= index; i++){
            if(i == index){
                p.prev.next = new Node(item, p.prev, p);
                p.prev = p.prev.next;
                break;
            }
            p = p.next;
        }
        size++;
    }

    /** Remove the first instance of item from this list. */
    public void remove(myType item) {
        Node p = sentinel.next;
        while(p.item != item){
            if(p == sentinel)
                return;
            p = p.next;
        }
        p.next.prev = p.prev;
        p.prev.next = p.next;
        size--;
    }

    @Override
    public String toString() {
        String result = "";
        Node p = sentinel.next;
        boolean first = true;
        while (p != sentinel) {
            if (first) {
                result += p.item.toString();
                first = false;
            } else {
                result += " " + p.item.toString();
            }
            p = p.next;
        }
        return result;
    }

    /** Returns whether this and the given list or object are equal. */
    public boolean equals(Object o) {
        DLList other = (DLList) o;
        if (size() != other.size()) {
            return false;
        }
        Node op = other.sentinel.next;
        for (Node p = sentinel.next; p != sentinel; p = p.next) {
            if (!(p.item.equals(op.item))) {
                return false;
            }
            op = op.next;
        }
        return true;
    }
}
