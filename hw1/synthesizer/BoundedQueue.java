package synthesizer;

import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T>{
    /** Return size of the buffer. */
    int capacity();

    /** Return number of items currently in the buffer. */
    int fillCount();

    /** add item x to the end. */
    void enqueue(T x);

    /** Delete and return item from the front. */
    T dequeue();

    /**Return (but do not delete) item from the front. */
    T peek();

    /** Is the buffer empty (fillCount equals zero)? */
    default boolean isEmpty(){
        if(this.fillCount() == 0) return true;
        return false;
    }

    /** Is the buffer full (fillCount equals capacity)? */
    default boolean isFull(){
        if(this.fillCount() == this.capacity()) return true;
        return false;
    }

    @Override
    Iterator<T> iterator();
}
