/**
 * A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 */
public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Returns an IntList consisting of the given values. */
    public static IntList of(int... values) {
        if (values.length == 0) {
            return null;
        }
        IntList p = new IntList(values[0], null);
        IntList front = p;
        for (int i = 1; i < values.length; i++) {
            p.rest = new IntList(values[i], null);
            p = p.rest;
        }
        return front;
    }

    /** Returns the size of the list. */
    /* Exercise: You might wonder why we don't do something like if (this == null) return 0;. Why wouldn't this work?

     Answer: Think about what happens when you call size. You are calling it on an object, for example L.size().
     If L were null, then you would get a NullPointer error!*/
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + rest.size();
    }

    /** Returns [position]th value in this list. */
    public int get(int position) {
        // If position less than 0 than return first.
        // If position large than length of the IntList, then return -1.
        int ans = this.first;
        IntList p = this.rest;
        for(int i = 0; i < position; i++){
            if(p == null){
                return -1;
            }
            ans = p.first;
            p = p.rest;
        }
        return ans;
    }

    /** Returns the string representation of the list. */
    public String toString() {
        String ans = "" + this.first;
        IntList p = this.rest;
        while(p != null){
            ans += " " + p.first;
            p = p.rest;
        }
        return ans;
    }

    /** Returns whether this and the given list or object are equal. */
    public boolean equals(Object o) {
        IntList other = (IntList) o;
        // TODO: YOUR CODE HERE
        IntList p = this;
        while(p.rest != null && other.rest != null){
            if (p.first == other.first){
                p.rest = p.rest.rest;
                other.rest = other.rest.rest;
            }
            else
                return false;
        }
        return (p.rest == null || other.rest != null) && (p.rest != null || other.rest == null);
    }
}
