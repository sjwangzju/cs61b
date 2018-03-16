
public class SLList {

    public class IntNode{
        int first;
        IntNode next;
        public IntNode(int x, IntNode node){
            first = x;
            next = node;
        }
    }

    private IntNode sn;
    private int size;

    public SLList(int x){
        sn = new IntNode(0, null);
        sn.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x){
        sn.next = new IntNode(x, sn.next);
        size += 1;
    }

    public void addLast(int x){
        while(sn.next != null){
            sn = sn.next;
        }
        sn.next = new IntNode(x, null);
        size += 1;
    }

    public int size(){
        return size;
    }


    public static void main(String args[]){
        SLList s = new SLList(5);
        s.addFirst(4);
        s.addLast(3);
        System.out.println("size: " + s.size());
    }
}
