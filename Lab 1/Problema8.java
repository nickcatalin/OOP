import java.util.Arrays;


public class Problema8 {


    public static void main(String[] args)
    {

        double[] arr = new double[5];
        for(int i=0;i<5;i++)
            arr[i]=Math.random();

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr,arr[1]));
        System.out.println(Arrays.binarySearch(arr,2));
    }
}