import java.util.HashMap;

/**
 * canConstruct
 */
public class canConstruct {

    public boolean go(String ransomNote,String magazine){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            char c=magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(int i=0;i<ransomNote.length();i++){
            char c1=ransomNote.charAt(i);
            if(!map.containsKey(c1)||map.get(c1)==0)
                return false;
            else
                map.put(c1, map.get(c1)-1);
        }
        return true;
    }
}