import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * findContentChildren
 */
public class findContentChildren {

    public int go(int[] g,int[] s){
        if(g.length==0||s.length==0)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while(i!=g.length&&j!=s.length){
            if(g[i]<=s[j]){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return i;
    }
}