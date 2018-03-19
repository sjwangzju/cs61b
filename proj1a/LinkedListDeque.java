public class LinkedListDeque<T>{

    private IntNode Sentinel;
    private int size;

    public class IntNode{
        public IntNode prev;
        public T item;
        public IntNode next;

        public IntNode(IntNode p1, T x, IntNode p2){
            prev = p1;
            item = x;
            next = p2;
        }
    }

    public LinkedListDeque(){
        Sentinel = new IntNode(null, null, null);
        Sentinel.next = Sentinel;
        Sentinel.prev = Sentinel;
        size = 0;
    }

    public int size(){
        return size;
    }

    public void addFirst(T item){
        IntNode node = new IntNode(Sentinel, item, Sentinel.next);
        Sentinel.next.prev = node;
        Sentinel.next = node;
        size ++;
    }

    public void addLast(T item){
        IntNode node = new IntNode(Sentinel.prev, item, Sentinel);
        Sentinel.prev.next = node;
        Sentinel.prev = node;
        size ++;
    }

    public T removeFirst(){
        if(Sentinel.next == Sentinel) return null;
        T item = Sentinel.next.item;
        Sentinel.next.next.prev = Sentinel;
        Sentinel.next = Sentinel.next.next;
        size --;
        return item;
    }

    public T removeLast(){
        if(Sentinel.next == Sentinel) return null;
        T item = Sentinel.prev.item;
        Sentinel.prev.prev.next = Sentinel;
        Sentinel.prev = Sentinel.prev.prev;
        size --;
        return item;
    }

    public T get(int index){
        if((index + 1) > this.size()) return null;
        IntNode p = Sentinel;
        for(int i = 0; i < (index + 1); i ++){
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index){
        if((index + 1) > this.size()) return null;
        if(index == 0){
            return Sentinel.next.item;
        }
        else{
            Sentinel = Sentinel.next;
            return getRecursive(index - 1);
        }
    }

    public void printDeque(){
        IntNode p = Sentinel;
        while(p.next != Sentinel){
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }

    public static void main(String[] args){
        LinkedListDeque<Integer> list = new LinkedListDeque<>();
        list.addLast(5);
        System.out.println("size is " + list.size() + ", first item is " + list.Sentinel.next.item);
        System.out.println("size is " + list.size() + ", last item is " + list.Sentinel.prev.item);
        list.addLast(4);
        list.addLast(3);
        list.addFirst(6);
        list.removeFirst();
        list.removeLast();
        System.out.println("size is " + list.size() + ", first item is " + list.Sentinel.next.item);
        System.out.println("size is " + list.size() + ", last item is " + list.Sentinel.prev.item);
        System.out.println(list.getRecursive(2));
        list.printDeque();
        System.out.println(list.isEmpty());
    }
}