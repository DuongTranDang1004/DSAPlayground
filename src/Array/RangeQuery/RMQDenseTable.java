package Array.RangeQuery;

//note: Both Dense Table and Sparse Table approach use precomputation
//Precomputation: compute value of the current looping cell of 2D Array based on values of previous cells
//Dense Table: dense = all ranges are filled
//Dense Table create lots of space complexity:  (N^2) as N is array length, because we need N^2 new array, each represent a possible range.
//We got this number by calculating the 2D array's area (square area = size x size = size ^2, and square size = N = Array Length)
//Reason: Dense table try to calculate min for all possible range, without skipping any

public class RMQDenseTable {
    static int[] X = {3, 5, 9, 2, 1, 6};

    public static int returnMinByDenseTable(int [] array){
        return 0;
    }

    public static int RQMDenseTable(int[]array, int start, int end){
        //initialze arrayMin value to return
        int arrayMin = 0;
        int rangeLength = end - start + 1;
        //intialize 2D Array Square with size = array length to store min value for all possible range
        int [][] min = new int[rangeLength][rangeLength];
        //initialize diagonal (start range = end range = array element) => this min = array element
        for (int i =0; i<rangeLength; i++){
            min[i][i] = array[start + i]; // Use start index to refer to the original array
        }
        //fill the cell value of 2D array (use nested for loop):
        for (int i =0; i<rangeLength; i++){ //rows
            for (int j = i+1; j<rangeLength; j++){ //columns. Increment 1 for start range and end range for next cell
                //update(fill) the current looping cell value (min of range) based on comparision between previous cell value and current looping rows of array index
                min [i][j] = Math.min(min[i][j-1], array[start + j]);
                arrayMin = min[i][j];
            }
        }

        return arrayMin;
    }

    public static void main(String[] args) {
        int min = RQMDenseTable(X,0,2);
        System.out.println("min = " + min);
    }


    //wait, I could only find min among all element of array without doing the range-query yet , so please update the code for that
//current looping/current start: + with start
    //current end range: end -
}
