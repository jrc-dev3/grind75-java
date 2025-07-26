import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Trie {

    private class Node {

        Map<Character, Node> siblings;
        Character value = null;
        Boolean isTerminal = false;

        public Node(Character value) {
            this.siblings = new HashMap<>();
            this.value = value;

        }

        public void setIsTerminal(Boolean isTerminal) {
            this.isTerminal = isTerminal;
        }

        public Boolean getIsTerminal() {
            return this.isTerminal;
        }
    }

    Map<Character, Node> siblings;

    public Trie() {
        this.siblings = new HashMap<>();

    }

    public void insert(String word) {

        char[] wordChars = word.toCharArray();
        Map<Character, Node> sibs = this.siblings;
        Node chNode = null;

        for (char ch : wordChars) {
            

            if (sibs.containsKey(ch)) {
                chNode = sibs.get(ch);
                sibs = chNode.siblings;

            } else {
                chNode = new Node(ch);
                sibs.put(ch, chNode);
                sibs = chNode.siblings;
            }

        }

        chNode.setIsTerminal(true);

    }

    public boolean search(String word) {

        char[] wordChars = word.toCharArray();
        Map<Character, Node> sibs = this.siblings;
        Node chNode = null;

        for (char ch : wordChars) {

            if (sibs.containsKey(ch)) {
                chNode = sibs.get(ch);
                sibs = chNode.siblings;

            } else {
                return false;
            }

        }

        return chNode.getIsTerminal();

    }

    public boolean startsWith(String prefix) {
        char[] wordChars = prefix.toCharArray();
        Map<Character, Node> sibs = this.siblings;
        Node chNode = new Node(wordChars[0]);

        for (char ch : wordChars) {

            if (sibs.containsKey(ch)) {
                chNode = sibs.get(ch);
                sibs = chNode.siblings;

            } else {
                return false;
            }

        }

        return true;

    }

    public static void main(String[] args) {


        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
        
    }

}

/**
  Your Trie object will be instantiated and called as such:
  Trie obj = new Trie();
  obj.insert(word);
  boolean param_2 = obj.search(word);
  boolean param_3 = obj.startsWith(prefix);
 */