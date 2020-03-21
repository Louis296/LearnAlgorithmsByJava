/**
 * canMeasureWater
 */
public class canMeasureWater {

    public boolean go(int x,int y,int z){
        if(x+y<z)
            return false;
        if(x==0||y==0)
            return z==0||x+y==z;
        int gcd=0;
        int min=x>y?y:x;
        for(int i=min;i>0;i--){
            if(x%i==0&&y%i==0)
                gcd=i;
        }
        return z%gcd==0;
    }
}