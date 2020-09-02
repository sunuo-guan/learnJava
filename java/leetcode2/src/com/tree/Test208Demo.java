package com.tree;

public class Test208Demo {
	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("apple");
		trie.search("apple");   // 返回 true
		trie.search("app");     // 返回 false
		trie.startsWith("app"); // 返回 true
		trie.insert("app");   
		trie.search("app");     // 返回 true

	}
}

class Trie {

	private TrieNode root;
	
    /** Initialize your data structure here. */
    public Trie() {
    	root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode temp=root;
    	for(int i=0;i<word.length();i++) {
    		char key=word.charAt(i);
    		if(!temp.containsKey(key)) {
    			temp.put(key, new TrieNode());
    		}
    		temp=temp.get(key);
    	}
    	temp.setEnd();
    }
    
    private TrieNode searchPrefix(String word) {
    	TrieNode temp=root;
    	for (int i = 0; i < word.length(); i++) {
			char key=word.charAt(i);
			if(temp.containsKey(key)) {
				temp=temp.get(key);
			}else {
				return null;
			}
		}
    	
    	return temp;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode res=searchPrefix(word);
    	return res!=null&&res.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode res=searchPrefix(prefix);
    	return res!=null;
    }
}

class TrieNode{
	private TrieNode links[];
	private boolean isEnd;
	private final int R=26;
	
	public TrieNode() {
		links=new TrieNode[R];
	}
	
	public boolean containsKey(char key) {
		return links[key-'a']!=null;
	}
	
	public TrieNode get(char key) {
		return links[key-'a'];
	}
	
	public void put(char key,TrieNode node) {
		links[key-'a']=node;
	}
	
	public void setEnd() {
		isEnd=true;
	}
	
	public boolean isEnd() {
		return isEnd;
	}
	
}
