public class OffByN implements CharacterComparator{

    public int temp;
    public OffByN(int N){
        temp = N;
    }

    @Override
    public boolean equalChars(char x, char y){
        if(Math.abs(x - y) == temp) return true;
        return false;
    }
}
