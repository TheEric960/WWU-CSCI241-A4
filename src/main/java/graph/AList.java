package heap;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/** An ArrayList-like dynamic array class that allocates
 * new memory when needed */
public class AList<T> {

    protected int size; // number of elements in the AList
    protected T[] a; // the backing array storage

    public int size() {
        return size;
    }

    protected int getCap() {
        return a.length;
    }

    /** constructor: create an AList with a default capacity of 8 */
    public AList() {
        a = createArray(8);
        size = 0;
    }

    /** constructor: create an AList with the given capacity */
    public AList(int capacity) {
        a = createArray(capacity);
        size = 0;
    }

    /* Grow a if newSize exceeds a's capacity. Do nothing if newSize < a.length.
     * Grow the array by allocating a new array and copying the old array's
     * contents into the new one. This does *not* change the AList's size. */
    protected void growIfNeeded(int newSize) {
        // don't grow if not needed
        if (newSize < a.length) {
            return;
        }

        // calculate new size
        int newCap = a.length;
        while (newCap < newSize) {
            newCap *= 2;
        }

        // create a bigger array and copy the existing elements (a[0..size])
        T[] newA = createArray(newCap);
        System.arraycopy(a, 0, newA, 0, size);
        a = newA;
    }

    /** Resize the AList.
     *  this *does* modify the size, and may modify the size of a. */
    public void resize(int newsize) {
        growIfNeeded(newsize);
        size = newsize;
    }

    /** get element i from AList.
     * @throws ArrayIndexOutOfBoundsException if 0 <= i < size does not hold */
    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return a[i];
    }

    /** set element i to value.
     * @throws ArrayIndexOutOfBoundsException if 0 <= i < size does not hold */
    public void put(int i, T value) {
        if (i < 0 || i >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        a[i] = value;
    }

    /** Append value at the end of the AList, increasing size by 1.
     * grows the array if needed to fit the appended value */
    public void append(T value) {
        growIfNeeded(size+1);
        a[size] = value;
        size += 1;
    }

    /** Remove and return the value at the end of the AList.
     *  this *does* modify size and cannot modify the size of a
     *  @throws NoSuchElementException if size == 0*/
    public T pop() {
        size -= 1;
        return a[size];
    }


    /*  Create and return a T[] of size n.
     *  This is necessary because generics and arrays don't play well together.*/
    @SuppressWarnings("unchecked")
    protected T[] createArray(int size) {
        return (T[]) new Object[size];
    }

}
