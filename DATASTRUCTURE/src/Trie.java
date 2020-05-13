
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Trie
{
    private TrieNode root;
    public Trie(ArrayList<String> word)
    {
        this.root=new TrieNode();
        for(String s:word)
        {
            this.root.addWord(s);
            System.out.println("Adding Word to Trie");
        }
    }
    public Trie(String[] list)
    {
        this.root=new TrieNode();
        for(String s:list)
        {
            root.addWord(s);
        }
    }
    private boolean contains(String prefix,boolean exact)
    {
        TrieNode lastnode=root;
        for(int i=0;i<prefix.length();i++)
        {
            lastnode=lastnode.getChild(prefix.charAt(i));
            if(lastnode==null)
                return false;
        }
        return !exact||lastnode.terminates();
    }
    public boolean contains(String s)
    {
        return contains(s,false);
    }
    public void getRoot()
    {
        for(char c:root.children.keySet())
        {
            System.out.println(c);
        }
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> word=new ArrayList<String>();
        while(true)
        {
            String s=br.readLine();
            if(s.equals("-1"))
            {
                break;
            }
            else
                {
                    word.add(s);
                    System.out.println("Adding Word");
                }
        }
        System.out.println("Creating Trie");
        Trie trie=new Trie(word);
        trie.getRoot();
        while(true)
        {
            String s=br.readLine();
            if(s.equals("-1"))
                break;
            if(trie.contains(s))
            {
                System.out.println("True");
            }

        }
    }
}
class TrieNode
{
    public HashMap<Character, TrieNode> children;
    private boolean terminates=false;
    private char character;
    public TrieNode()
    {
        children=new HashMap<Character,TrieNode>();
    }
    public TrieNode(char character)
    {
        this();
        this.character=character;
    }
    public char getChar()
    {
        return character;
    }
    public void addWord(String word)
    {
        if(word==null || word.isEmpty())
        {
            return;
        }
        char first_character=word.charAt(0);
        TrieNode child=getChild(first_character);
        if(child==null)
        {
            child=new TrieNode(first_character);
            children.put(first_character,child);
        }
        if(word.length()>1)
        {
            child.addWord(word.substring(1));
        }
        else
            {
                child.setTerminates(true);
            }
    }
    public TrieNode getChild(char c)
    {
        return children.get(c);
    }
    public boolean terminates(){
        return terminates;
    }
    public void setTerminates(boolean val)
    {
        terminates=val;
    }
}