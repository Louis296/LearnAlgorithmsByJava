/**
 * test
 */
public class test {

    public static void main(String[] args) {
        // boolean result;
        // result=new canMeasureWater().go(2,6,5);
        // System.out.println(result);
        // System.out.print(new guessNum().go(2126753390));
        String[] deadends={"0201","0101","0102","1212","2002"};
        System.out.println(new openLock().go(deadends,"0202"));
                
    }
}