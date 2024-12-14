
public class trappedRainwater {
    public static int trappedWater(int height[], int width)
    {
        // Fetching for Size of height array
        int arraySize = height.length;

        int leftMax[] = new int[arraySize];
        leftMax[0] = height[0];
        // Looping
        for(int i = 1 ; i<arraySize; i++)
        {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        // Calculating right max boundary
        int rightMax[] = new int [arraySize];
        rightMax[arraySize-1] = height[arraySize-1];
        for(int i = arraySize-2; i>=0; i--)
        {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        for(int i=0; i<arraySize; i++){

            //waterlevel = min(leftmax boundary, rightmax boundary)
            int waterlevel = Math.min(leftMax[i], rightMax[i]);

            //trapped water = (waterlevel - height) * width
            trappedWater += (waterlevel - height[i]) * width;
        }

        System.out.println(trappedWater);


        // return
        return trappedWater;

    }

    public static void main(String args[]){

        int height[] = {4, 2, 0, 6, 3, 2, 5};
        int width = 1;

        System.out.println(trappedWater(height, width));
    }
}
