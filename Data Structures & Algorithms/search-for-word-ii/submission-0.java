class Solution {
    class Trie{
        Map<Character,Trie> map = new HashMap<>();
        boolean isWord = false;
        Trie(){}
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> resultList = new ArrayList<>();
          // construct prefix tree of the words we want to search for
        Trie prefixTreeRoot = new Trie();
        constructPrefixTree(words,prefixTreeRoot);

        // traverse the board and check if any of the words exist
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(prefixTreeRoot.map.containsKey(board[i][j])){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    traverseBoard(board,i,j,prefixTreeRoot,visited, new StringBuilder(),resultList);
                }
            }
        }
        return resultList;
    }

    private void traverseBoard(char[][] board,int i,int j,Trie trie,boolean[][] visited,StringBuilder word,List<String> resultList){
        if(i<0 || j<0 || i>= board.length || j>=board[0].length)return;
        char ch = board[i][j];
        if(!trie.map.containsKey(ch))return;
        if(visited[i][j])return;
        
        visited[i][j] = true;
        trie = trie.map.get(ch);
        word.append(ch);
        
        if(trie.isWord){
            resultList.add(word.toString());
            trie.isWord = false;
        }

        traverseBoard(board,i+1,j,trie,visited,word,resultList);
        traverseBoard(board,i-1,j,trie,visited,word,resultList);
        traverseBoard(board,i,j+1,trie,visited,word,resultList);
        traverseBoard(board,i,j-1,trie,visited,word,resultList);
        
        visited[i][j] = false;
        word.deleteCharAt(word.length() - 1);
    }

    private void constructPrefixTree(String[] words, Trie root){
        for(String word: words){
            Trie current = root;
            for(Character ch : word.toCharArray()){
                if(!current.map.containsKey(ch)){
                    Trie child = new Trie();
                    current.map.put(ch,child);
                }
                current = current.map.get(ch);
            }
            current.isWord = true;
        }
    }
}
