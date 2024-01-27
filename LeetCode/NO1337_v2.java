import java.util.Arrays;

public class NO1337_v2 {
    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            int[] output = new int[k];
            Row[] rows = new Row[mat.length];

            // For each row, insert row number and number of soldiers into the array
            for (int i = 0; i < mat.length; i++) {
                rows[i] = new Row(i, numSoldier(mat, i));
            }

            Arrays.sort(rows);

            // Output row numbers of the k weakest rows
            for (int i = 0; i < k; i++) {
                output[i] = rows[i].rowNum;
            }

            return output;
        }

        // This method returns the number of soldiers in a given row
        public int numSoldier(int[][] mat, int rowNum) {
            int low = 0;
            int high = mat[rowNum].length - 1;
            int mid;
        
            // Binary search for the first civilian (0)
            while (low <= high) {
                mid = (low + high) / 2;
                if (mat[rowNum][mid] == 0) {
                    if (mid == 0)
                        return 0;

                    if (mat[rowNum][mid - 1] == 1)
                        return mid;
                    
                    high = mid - 1;
                }
                else if (mid == mat[rowNum].length - 1)
                    return mat[rowNum].length;
                else 
                    low = mid + 1;
            }

            return -1; // error
        }
    }

    // Object that stores the row number and number of soldiers for a row
    // Implements the Comparable Interface so that Row[] can be sorted
    class Row implements Comparable<Row>{
        int rowNum;
        int numSoldier;

        public Row(int rowNum, int numSoldier) {
            this.rowNum = rowNum;
            this.numSoldier = numSoldier;
        }

        // Compare by number of soldiers and then row number
        @Override
        public int compareTo(Row compared) {
            if (this.numSoldier < compared.numSoldier)
                return -1;
            else if (this.numSoldier == compared.numSoldier && this.rowNum < compared.rowNum)
                return -1;
            else
                return 1;
        }
    }
}


