public class ArrayDeque<T> implements Deque<T>{
    private static int REFACTOR = 10;
    private int size;
    private AList items;
    private int nextFirst;
    private int nextLast;

    public class AList{
        public T[] t;

        public AList(){
            t = (T[]) new Object[8];
        }
    }

    public ArrayDeque(){
        items = new AList();
        size = 0;
        nextFirst = 1;
        nextLast = 2;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void addFirst(T item){
        if(size == items.t.length){
            this.resize(size + REFACTOR);
        }
        items.t[nextFirst] = item;
        nextFirst --;
        if(nextFirst < 0){
            nextFirst = items.t.length - 1;
        }
        size ++;
    }

    @Override
    public void addLast(T item){
        if(size == items.t.length){
            this.resize(size + REFACTOR);
        }
        items.t[nextLast] = item;
        nextLast ++;
        if(nextLast == items.t.length){
            nextLast = 0;
        }
        size ++;
    }

    public void resize(int size){
        T[] s = (T[]) new Object[size];
        System.arraycopy(items.t, 0, s, 0, this.size());
        items.t = s;
        this.nextLast = this.size();
        this.nextFirst = items.t.length - 1;
    }

    @Override
    public T get(int index){
        return items.t[index];
    }

    @Override
    public T removeFirst(){
        if(nextFirst == items.t.length - 1){
            nextFirst = 0;
        }
        else{
            nextFirst ++;
        }
        T t = items.t[nextFirst];
        items.t[nextFirst] = null;
        return t;
    }

    @Override
    public T removeLast(){
        if(nextLast == 0){
            nextLast = items.t.length - 1;
        }
        else{
            nextLast --;
        }
        T t = items.t[nextLast];
        items.t[nextLast] = null;
        return t;
    }

    @Override
    public void printDeque(){
        for(int i = 0; i < items.t.length; i ++){
            System.out.print(this.items.t[i] + " ");
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        Deque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(1);
        ad.addFirst(0);
        ad.addFirst(7);
        ad.addFirst(6);
        ad.addFirst(5);
        ad.addFirst(4);

        ad.addLast(2);
        ad.addLast(3);

        ad.addLast(8);
        ad.addFirst(17);
        ad.addFirst(16);
        ad.addLast(9);

        ad.removeFirst();
        ad.removeFirst();
        ad.removeFirst();
        ad.removeLast();
        System.out.println(ad.size());
        ad.printDeque();
    }
}
