class WordDictionary {
    class Node {
        Map<Character,Node> map;
        boolean isWord;

        Node(){
            this.map = new HashMap<>();
            this.isWord = false;
        }
    }
    Node root;
    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node current = root;
        for(Character ch : word.toCharArray()){
            if(!current.map.containsKey(ch)){
                current.map.put(ch, new Node());
            }
            current = current.map.get(ch);
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        Node current = root;
        return search(word,0,current);
    }

    private boolean search(String word,int pos,Node current){
        if (pos == word.length()) {
            return current.isWord;
        }
        char ch = word.charAt(pos);
        if(ch!='.' && !current.map.containsKey(ch))return false;

        if(ch!='.' && current.map.containsKey(ch)){
            return search(word,pos+1,current.map.get(ch));
        }

        for(Map.Entry<Character,Node> entry : current.map.entrySet()){
            if(search(word,pos+1,entry.getValue()))return true;
        }
        return false;
    }
}
