package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    public int capacity(){
        return capacity;
    }

    public int fillCount(){
        return fillCount;
    }

    @Override
    public boolean isEmpty(){
        if(capacity == 0) return true;
        return false;
    }

    @Override
    public boolean isFull(){
        if(capacity == fillCount) return true;
        return false;
    }

    public abstract T peek();

    public abstract T dequeue();

    public abstract void enqueue(T x);
}
