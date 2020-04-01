import java.util.HashMap;
import java.util.HashSet;

/**
 * firstUniqChar
 */
public class firstUniqChar {

    public int goByHashSet(String s){
        HashSet<Character> set=new HashSet<>();
        if(s.length()==1)
            return 0;
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){ 
                if(i==s.length()-1)
                    return i;       
                for(int j=i+1;j<s.length();j++){
                    if(s.charAt(j)==s.charAt(i)){
                        set.add(s.charAt(i));
                        break;
                    }
                    if(j==s.length()-1)
                        return i;
                }
            }
        }
        return -1;
    }

    public int goByHashMap(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }

    //最快的方法
    public int go(String s){
        int n=s.length();
        for(int i='a';i<='z';i++){
            int start=s.indexOf(i);
            int end=s.lastIndexOf(i);
            if(start==end&&start!=-1)
                n=Math.min(start, n);
        }

        if(n==s.length())
            return -1;
        else
            return n;
    }
}