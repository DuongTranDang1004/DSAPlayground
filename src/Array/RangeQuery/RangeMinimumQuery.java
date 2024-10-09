package Array.RangeQuery;

public class RangeMinimumQuery {

    //redo it here
    public static class RangeMinimumQuerySolution {
            public static void main(String[] args) {
                int[] X = {3, 5, 9, 2, 6};
                int N = X.length;
                int minValue = 0;

                // Create a square (row = column = array length) 2D array to store the minimum values for each range,
                int[][] min = new int[N][N];

                // Initialize min[i][i] = X[i] for every i (minimum of a single element is the element itself), aka 2D Array Diagonal
                for (int i = 0; i < N; i++) {
                    min[i][i] = X[i];
                }

                // Fill the rest of the table using the precomputation algorithm
                //Printing mechanism: left => right, finish 1 row, then move to next row (column first, row later)
                for (int i = 0; i < N - 1; i++) { //outer loop print row
                    for (int j = i + 1; j < N; j++) {  //inner loop printing column (code run from here first)
                        //Question 0: why j = i + 1
                        //Answer: in the range [startIndex,endIndex] (min[i],[j]), end Index aka the column must always 1 unit larger
                        // when moving to the next column, the [startIndex,endIndex] of the range must be both increment by 1, so we can print the value of the next cell of 2D array
                        min[i][j] = Math.min(min[i][j - 1], X[j]); //ex: min[0][4] = Math.min(min[0][3], X[4]); // Math.min(2, 6) → min[0][4] = 2
                        //basicly the line above: compare previous min value (from 2D array cell) with current Orignal Array element at index j
                        //going from left to right,then top to down

                        minValue = min[i][j]; //return this one


                        // question 1:
    //                why not  min[i][j] = Math.min(min[i][i], X[j]);, I thought j is always 1 unit larger than i ?
                        //=> min[i][i] would always be the diagonal. Here we are trying to loop through the 2D Array's cell: from left to right (change columns), then from up to down (change rows)

                        //question 2:
                        //why not   min[i][j] = Math.min(min[i][j - 1], X[i]) ?
                        // => we want to compare with the end range, not start range 
                    }
                }

                System.out.println("Min Value of Array is " + minValue);
    //pro tips: make a lot of examples for better visualization and understanding the problem

            }
        }
}




