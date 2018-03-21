public class Palindrome{
    public Deque<Character> wordToDeque(String word){
        Deque<Character> d = new LinkedListDeque<Character>();
        for(int i = 0; i < word.length(); i++){
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word){
        if(word.length() == 0 || word.length() == 1) {
            return true;
        }
        String str = "";
        for(int i = word.length() - 1; i >= 0; i --){
            char ch = word.charAt(i);
            str += ch;
        }
        if(str.equals(word)){
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        boolean temp = true;
        for(int i = 0; i < word.length() / 2; i ++){
            temp = temp && cc.equalChars(word.charAt(i), word.charAt(word.length() - i - 1));
        }
        return temp;
    }

    public boolean isPalindrome(String word, OffByN offbyn) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        boolean temp = true;
        for(int i = 0; i < word.length() / 2; i ++){
            temp = temp && offbyn.equalChars(word.charAt(i), word.charAt(word.length() - i - 1));
        }
        return temp;
    }
}
