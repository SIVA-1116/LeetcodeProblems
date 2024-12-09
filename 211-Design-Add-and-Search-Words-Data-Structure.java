class WordDictionary {
    class Node{
        boolean eow=false;
        Node[] children=new Node[26];
    }Node root;

    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(node.children[ch-'a']==null){
                node.children[ch-'a']=new Node();
            }
            node=node.children[ch-'a'];
        }
        node.eow=true;
    }
    
    public boolean search(String word) {
        return helper(word,0,root);
    }
   public boolean helper(String word, int idx, Node node) {
    if (idx == word.length()) {
        return node.eow; 
    }
    
    char ch = word.charAt(idx);

    if (ch != '.') {
        Node child = node.children[ch - 'a'];
        if (child == null) {
            return false; 
        } else {
            return helper(word, idx + 1, child);
        }
    } else {
        for (char nch = 'a'; nch <= 'z'; nch++) {
            Node child = node.children[nch - 'a'];
            if (child != null) {
                if (helper(word, idx + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }
}


}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */