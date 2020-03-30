import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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

    public boolean goByBFS(int x,int y,int z){
        int[] initialState={0,0};
        
        HashSet<String> haveSeen=new HashSet<>();
        haveSeen.add(stateToString(initialState));

        Queue<int[]> queue=new LinkedList<>();
        queue.offer(initialState);
        queue.offer(null);

        int depth=0;

        while(!queue.isEmpty()){
            int[] currentState=queue.poll();
            if(currentState==null){
                depth++;
                if(queue.peek()!=null)
                    queue.offer(null);
            }
            else if(currentState[0]+currentState[1]==z){
                System.out.println(depth);
                return true;
            }
            else{
                if(!haveSeen.contains(stateToString(emptyX(currentState)))){
                    queue.offer(emptyX(currentState));
                    haveSeen.add(stateToString(emptyX(currentState)));
                }
                if(!haveSeen.contains(stateToString(emptyY(currentState)))){
                    queue.offer(emptyY(currentState));
                    haveSeen.add(stateToString(emptyY(currentState)));
                }
                if(!haveSeen.contains(stateToString(fillX(currentState, x)))){
                    queue.offer(fillX(currentState, x));
                    haveSeen.add(stateToString(fillX(currentState, y)));
                }
                if(!haveSeen.contains(stateToString(fillY(currentState, y)))){
                    queue.offer(fillY(currentState, y));
                    haveSeen.add(stateToString(fillY(currentState, y)));
                }
                if(!haveSeen.contains(stateToString(doXToY(currentState, y)))){
                    queue.offer(doXToY(currentState, y));
                    haveSeen.add(stateToString(doXToY(currentState, y)));
                }
                if(!haveSeen.contains(stateToString(doYToX(currentState, x)))){
                    queue.offer(doYToX(currentState, x));
                    haveSeen.add(stateToString(doYToX(currentState, x)));
                }
            }
        }
        return false;
    }

    private int[] emptyX(int[] currentState){
        int[] nextState=currentState.clone();
        nextState[0]=0;
        return nextState;
    }

    private int[] emptyY(int[] currentState){
        int[] nextState=currentState.clone();
        nextState[1]=0;
        return nextState;
    }

    private int[] fillX(int[] currentState,int x){
        int[] nextState=currentState.clone();
        nextState[0]=x;
        return nextState;
    }

    private int[] fillY(int[] currentState,int y){
        int[] nextState=currentState.clone();
        nextState[1]=y;
        return nextState;
    }

    private int[] doXToY(int[] currentState,int y){
        int[] nextState=currentState.clone();
        if((y-nextState[1])>=nextState[0]){
            nextState[1]+=nextState[0];
            nextState[0]=0;
        }
        else{
            nextState[0]-=(y-nextState[1]);
            nextState[1]=y;
        }
        return nextState;
    }

    private int[] doYToX(int[] currentState,int x){
        int[] nextState=currentState.clone();
        if((x-nextState[0])>=nextState[1]){
            nextState[0]+=nextState[1];
            nextState[1]=0;
        }
        else{
            nextState[1]-=(x-nextState[0]);
            nextState[0]=x;
        }
        return nextState;
    }

    private String stateToString(int[] state){
        return ""+state[0]+","+state[1];
    }
}