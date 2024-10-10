package Array.RangeQuery;

//note: Dense Table still use precomputation, but is a huge space complexity improvement from Sparse Table
//As we skip alot of range
//Reason for using power of 2: beacuse any positive integer (representation of arrat length and indices)
// can be wirrten as sum of power of 2(because smallest power of 2 aka 2^0 = 1)


public class RMQSparseTable {
    static int[][] sparseTable;

    // Preprocess the input array to fill the sparse table
    static void preprocess(int[] array) {
        int n = array.length;
        int log = (int) Math.ceil(Math.log(n) / Math.log(2));
        sparseTable = new int[n][log + 1];

        // Initialize the first column of the sparse table
        for (int i = 0; i < n; i++) {
            sparseTable[i][0] = array[i];
        }

        // Fill the sparse table
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; (i + (1 << j) - 1) < n; i++) {
                sparseTable[i][j] = Math.min(sparseTable[i][j - 1], sparseTable[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // Function to find the minimum value in the range [L, R]
    static int rangeMinQuery(int L, int R) {
        int length = R - L + 1;
        int k = (int) (Math.log(length) / Math.log(2));

        return Math.min(sparseTable[L][k], sparseTable[R - (1 << k) + 1][k]);
    }

    // Driver code to test the function
    public static void main(String[] args) {
        int[] array = {3, 5, 9, 2, 1, 6};
        preprocess(array);
        int start = 1, end = 3;
        System.out.println("Minimum of [" + start + ", " + end + "] is " + rangeMinQuery(start, end));
    }



    //Question 1: Why the column size of sparse table is floor[logBase2(array.length())] + 1?

    //LogBase 2 then floor down: find the max power of 2 that can fit the array length

    // Then plus 1: We are counting from 0 for power of 2 (2^0 = 1) . So like add 1 extra counting unit at the beginning for power of 2

    //NOTE: The "counting from 0" refers to the powers of 2, not the starting index of the array.


    //Question 2: What is the meaning of cell value inside sparse table ?



    //wait, I could only find min among all element of array without doing the range-query yet , so please update the code for that


}
