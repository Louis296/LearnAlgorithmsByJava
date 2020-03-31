import java.util.HashSet;

/**
 * firstUniqChar
 */
public class firstUniqChar {

    public int go(String s){
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
}