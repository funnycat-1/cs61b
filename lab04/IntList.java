/**
 * A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 *
 * This is a dummy implementation to allow IntListTest to compile. Replace this
 * file with your own IntList class.
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
        for (int i = 1; i < values.length; i += 1) {
            p.rest = new IntList(values[i], null);
            p = p.rest;
        }
        return front;
    }

    /** Returns the size of the list. */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + rest.size();
    }

    /** Returns [position]th value in this list. */
    public int get(int position) {
        if (position == 0) {
            return first;
        } else {
            return rest.get(position - 1);
        }
    }

    /** Adding value to the end of IntList. */
    public void add(int value) {
        IntList p = this;
        while(p != null)
            p = p.rest;
        p.rest = new IntList(value, null);
    }

    public int smallest() {
        int ans = this.first;
        while(this.rest != null)
            if (ans > this.rest.first)
                ans = this.rest.first;
            this.rest = this.rest.rest;
        return ans;
    }

    public int squaredSum() {
        int ans = this.first * this.first;
        while(this.rest != null){
            this.rest = this.rest.rest;
            ans += this.first * this.first;
        }
        return ans;
    }

    public static void dSquareList(IntList L) {
        while (L != null) {
            L.first = L.first * L.first;
            L = L.rest;
        }
    }

    public static IntList catenate(IntList A, IntList B) {
        if (A == null)
            return B;
        IntList ans = new IntList(A.first, null);
        IntList p = A;
        /* copy A to ans. */
        while(p.rest!= null){
            ans.rest = new IntList(p.rest.first, null);
            p = p.rest;
        }
        p = B;
        /* copy B to ans. */
        while(p.rest != null){
            ans.rest = new IntList(p.first, null);
            p = p.rest;
        }
        return ans;
    }

    public static IntList dcatenate(IntList A, IntList B) {
        /* If A is null then concatenate B to A. */
        if (A == null){
            IntList p1 = B;
            while (p1 != null) {
                A.rest = new IntList(p1.first, null);
                p1 = p1.rest;
            }
            return A;
        }
        IntList p2 = A;
        /* Moving through A to its end to get the last rest. */
        while(p2.rest!= null){
            p2 = p2.rest;
        }
        IntList p3 = B;
        /* Handling all B elements and copy them to A. */
        while(p3.rest != null){
            p2.rest = new IntList(p3.first, null);
            p2 = p2.rest;
        }
        return A;
    }

    /** Remove the odd index position nodes. */
    public static void removeOddPositonNode(IntList L){
        while(L != null && L.rest != null){
            L.rest = L.rest.rest;
            L = L.rest;
        }
    }

    public static IntList reverseIntList(IntList L){
        // If L is null then return null.
        if (L == null)
            return null;
        /* If L has only one element then return itself. */
        if (L.rest == null)
            return L;
        IntList secondElem = L.rest;
        // bug fix - need to unlink IntList from the rest or will get a circle.
        L.rest = null;
        IntList reversedIntList = reverseIntList(secondElem);
        secondElem.rest = L;
        return reversedIntList;
    }
}
