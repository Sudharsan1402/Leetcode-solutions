import java.util.AbstractList;

class Solution {
    private void print(String[] words) {
        for(int i=0; i < words.length; ++i) {
            System.out.println(words[i]);
        }
    }
    private boolean wordBreak(Trie trie, String s) {
        boolean[] dp = new boolean[s.length()];
        for(int i=0; i<s.length(); ++i) {
            if (i == 0 || dp[i-1]) {
                Node curr = null;
                for(int j=i; j < s.length(); ++j) {
                    char c = s.charAt(j);
                    curr = trie.traverse(c, curr);
                    if (curr == null) break;
                    if (curr.isWord) dp[j] = true;
                }
            }
        }
        return dp[s.length()-1];
    }
    private List<String> process(String[] words) {
        List res = new ArrayList<String>();
        Trie trie = new Trie();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        trie.insert(words[0]);
        for(int i=1; i < words.length; ++i) {
            if (wordBreak(trie, words[i])) res.add(words[i]);
            trie.insert(words[i]);
        }
        return res;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        return new AbstractList<String> () {
            private List<String> res;
            private void init() {
                if (res == null) res = process(words);
            }

            @Override
            public int size() {
                init();
                return res.size();
            }
            @Override
            public String get(int index) {
                init();
                return res.get(index);
            }
        };
    }
}

class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }
    public void insert(String s) {
        Node curr = root;
        for(int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            Node child = curr.childs.getOrDefault(c, new Node());
            curr.childs.put(c, child);
            curr = child;
        }
        curr.isWord = true;
    }

    public Node traverse(char c, Node r) {
        if (r == null) r = root;
        return r.childs.getOrDefault(c, null);
    }
}

class Node {
    public Map<Character, Node> childs;
    public boolean isWord;
    public Node() {
        childs = new HashMap<>();
    }
}