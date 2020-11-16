

/*
Implementation of peak finding problem using Divide and Conquer Algorithm combining with Binary Search technique.
 */
class OneDPeakFinding {

    public static void main(String[] args) {
        int input[] = {1, 4, 8, 5, 6, 2};
        int size = input.length;
        int peakElement = findPeakElement(input, 0, size - 1, size);
        System.out.println("Peak Element is ::" + peakElement);
    }


    static int findPeakElement(int input[], int start, int end, int size) {
        //Index of middle element
        int middle = start + (end - start) / 2;

        //compare middle element with the element towards its left & right.
        if ((middle == 0 || input[middle - 1] <= input[middle]) && (middle == size - 1 || input[middle + 1] <= input[middle])) {
            return input[middle];

            //if middle element is not peak but element towards its left is greater. iterate the left half of the set with same approach. i.e., left set from middle.
        } else if (middle > 0 && input[middle - 1] > input[middle]) {
            return findPeakElement(input, start, (middle - 1), size);

            //if middle element is not peak but element towards its right is greater. iterate the second half of the set with same approach. i.e., right set from middle
        } else {
            return findPeakElement(input, middle + 1, end, size);
        }
    }
}
