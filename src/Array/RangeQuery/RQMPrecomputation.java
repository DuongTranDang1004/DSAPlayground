package Array.RangeQuery;

public class RQMPrecomputation {
    static int[] X = {3, 5, 9, 2, 1, 6};
    public static int RQM(int[]array){
        //initialze arrayMin value to return
        int arrayMin = 0;
        //intialize 2D Array Square with size = array length to store min value for all possible range
        int [][] min = new int[array.length][array.length];
        //initialize diagonal (start range = end range = array element) => this min = array element
        for (int i =0; i<array.length; i++){
           min[i][i] = array[i];
        }
        //fill the cell value of 2D array (use nested for loop):
        for (int i =0; i<array.length; i++){ //rows
            for (int j = i+1; j<array.length; j++){ //columns. Increment 1 for start range and end range for next cell
                //update(fill) the current looping cell value (min of range) based on comparision between previous cell value and current looping rows of array index
                min [i][j] = Math.min(min[i][j-1], array[j]);
                arrayMin = min[i][j];
            }
        }

        return arrayMin;
    }

    public static void main(String[] args) {
        int min = RQM(X);
        System.out.println("min = " + min);
    }
}
