public class SolutionMissingElement {

    // takes an array and +1 of the length of array, and finds the missing element of the array

    int missingNumber(int array[], int n) {
        int summeOfElements = 0;
        for ( int i = 0 ; i < array.length ; i++ ) {
            summeOfElements += array[i];
        }
        int sumOfArrayLen = (n*(n+1)) / 2;
        return sumOfArrayLen - summeOfElements;
    }
}
