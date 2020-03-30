/**
 * guessNum
 */
public class guessNum {
    int answer=1702766719;
    public int go (int n){
        long left=0,right=n;
        int res=n;
        while(guess(res)!=0){
            long sum=right+left;
            res=(int)(sum/2);
            if(guess(res)==1)
                right=res;
            if(guess(res)==-1)
                left=res;
        }

        return res;
    }

    public int guess(int res){
        if(res==answer)
            return 0;
        if(res>answer)
            return 1;
        
        return -1;
        
    }
}