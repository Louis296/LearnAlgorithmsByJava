import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * openLock
 */
public class openLock {
    //BFS算法解决
    public int go(String[] deadends,String target){
        HashSet<String> dead=new HashSet<>();
        for(String i:deadends){
            dead.add(i);
        }
        
        Queue<String> queue=new LinkedList<>();
        queue.offer("0000");
        queue.offer(null);

        HashSet<String> haveSeen=new HashSet<>();
        haveSeen.add("0000");

        int depth=0;

        while(!queue.isEmpty()){
            String currentNode=queue.poll();
            if(currentNode==null){
                depth++;
                if(queue.peek()!=null)
                    queue.offer(null);
            }
            else if(currentNode.equals(target))
                return depth;
            else if(!dead.contains(currentNode)){
                for(int i=0;i<4;i++){
                    for(int d=-1;d<2;d+=2){
                        int key=((currentNode.charAt(i)-'0')+d+10)%10;
                        String newNode=currentNode.substring(0, i)+(""+key)+currentNode.substring(i+1);
                        if(!haveSeen.contains(newNode)){
                            haveSeen.add(newNode);
                            queue.offer(newNode);
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    
    public String move(String current,int location,int direct){
        location--;
        StringBuffer sb=new StringBuffer(current);
        int key=Integer.parseInt(""+sb.charAt(location));
        if(direct==1)
            key=key+1;
        else
            key=key-1;
        if(key==10)
            key=0;
        if(key==-1)
            key=9;
        sb.setCharAt(location, String.valueOf(key).charAt(0));
        return sb.toString();
    }
}