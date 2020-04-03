import java.util.Arrays;
import java.util.Comparator;

/**
 * findMinArrorShots
 */
public class findMinArrorShots {

    public int go (int[][] points){
        if(points.length==0)
            return 0;
        Arrays.sort(points,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]-o2[1];
			}
            
        });
        int arrorsNum=1;
        int firstEnd=points[0][1];
        for(int[] point:points){
            if(point[0]>firstEnd){
                arrorsNum++;
                firstEnd=point[1];
            }
        }
        return arrorsNum;
    }
}