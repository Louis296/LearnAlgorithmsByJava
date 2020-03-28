/**
 * getSum
 */
public class getSum {

    public int go(int a,int b){
        String a2=Integer.toBinaryString(a);
        String b2=Integer.toBinaryString(b);
        while(a2.length()<32){
            StringBuffer sa=new StringBuffer();
            sa.append("0").append(a2);
            a2=sa.toString();
        }
        while(b2.length()<32){
            StringBuffer sb=new StringBuffer();
            sb.append("0").append(b2);
            b2=sb.toString();
        }
        String res="";
        int up=0;
        int A,B;
        for(int i=31;i>=0;i--){
            A=Integer.parseInt(""+a2.charAt(i));
            B=Integer.parseInt(""+b2.charAt(i));
            int k=A^B^up;
            StringBuffer result=new StringBuffer();
            result.append(String.valueOf(k)).append(res);
            res=result.toString();
            if((A&B)==1||(A&up)==1||(B&up)==1)
                up=1;
            else
                up=0;
        }
        if(res.charAt(0)=='1'){
            StringBuffer result=new StringBuffer(res);
            for(int i=31;i>=0;i--){
                if(res.charAt(i)=='1')
                    result.setCharAt(i, '0');
                else
                    result.setCharAt(i, '1');
            }
            res=result.toString();
            return -1*(Integer.parseInt(res, 2)+1);
        }
        return Integer.parseInt(res,2);
    }
}