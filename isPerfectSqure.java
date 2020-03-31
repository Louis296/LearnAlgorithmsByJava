/**
 * isPerfectSqure
 */
public class isPerfectSqure {

    public boolean go(int num){
        float res=44000;
        while(true){
            float sq=res*res;
            res=res-((res*res-num)/(2*res));
            if(sq-res*res<0.1&&sq-res*res>-0.1)
                break;
        }
        int ans=(int) res;
        return ans*ans-num==0;
    }
}