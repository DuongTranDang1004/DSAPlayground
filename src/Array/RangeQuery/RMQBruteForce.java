package Array.RangeQuery;


//RQM: range minimum query
public class RMQBruteForce {
    static int[] X = {3, 5, 9, 4, 6,9,11,1,8};

    public static int returnMinByBruteForce(int []array){
        int min = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public static int RQMBruteForce(int[] array, int start, int end){
    int min = array[start]; //initialize min value to be first element of array
    for (int i = start ; i < array[end]; i++) {
        System.out.println("Current looping index " + array[i]);
        if (array[i] < min) {
            min = array[i];
        }
    }
    return min;
    }

    public static void main(String[] args) {
         int min = RQMBruteForce(X, 3, 7);
        System.out.println("min = " + min);
    }


    //wait, I could only find min among all element of array without doing the range-query yet , so please update the code for that
}
