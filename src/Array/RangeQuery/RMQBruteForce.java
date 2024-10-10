package Array.RangeQuery;


//RQM: range minimum query
public class RMQBruteForce {
    static int[] X = {3, 5, 9, 2, 6};
    public static int RQM(int[] array){
    int min = array[0]; //intialize min value to be first element of array
    for (int i = 0 ; i < array.length; i++) {
        System.out.println("Current looping index " + array[i]);
        if (array[i] < min) {
            min = array[i];
        }
    }
    return min;
    }

    public static void main(String[] args) {
         int min = RQM(X);
        System.out.println("min = " + min);
    }
}
