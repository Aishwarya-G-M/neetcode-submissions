class PrefixTree {
    class Node{
        Map<Character,Node> map;
        Boolean isWord;

        Node(){
            this.map = new HashMap<>();
            this.isWord = false;
        }
    }
    Node root;
    public PrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for(Character ch : word.toCharArray()){
            if(!current.map.containsKey(ch)){
                current.map.put(ch,new Node());   
            }
            current = current.map.get(ch);
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        Node current = root;
        for(Character ch : word.toCharArray()){
            if(!current.map.containsKey(ch))return false;
            current = current.map.get(ch);
        }
        
        return current.isWord ;
    }

    public boolean startsWith(String prefix) {
        Node current = root;
        for(Character ch : prefix.toCharArray()){
            if(!current.map.containsKey(ch))return false;
            current = current.map.get(ch);
        }
        return true;
    }
}
