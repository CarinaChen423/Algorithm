public class Lab6_InsertionSort {
    private int comparisonCount = 0;
    private int swapCount = 0;

    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                comparisonCount++;
                array[j + 1] = array[j];
                j = j - 1;
                swapCount++;
            }
            array[j + 1] = key;
        }
        return array;
    }

    public int getComparisonCount() {
        return comparisonCount;
    }

    public int getSwapCount() {
        return swapCount;
    }

    public static void main(String[] args) {
        Lab6_InsertionSort insertionSort = new Lab6_InsertionSort();

        // Test case 1: Array of 50 random elements
        int[] randomArray = new int[50];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int)(Math.random() * 50 + 1);
        }
        insertionSort.sort(randomArray);
        System.out.println("Number of comparisons in random array: " + insertionSort.getComparisonCount());
        System.out.println("Number of swaps in random array: " + insertionSort.getSwapCount());

        // Test case 2: Array of 50 sorted elements
        insertionSort = new Lab6_InsertionSort();
        int[] sortedArray = new int[50];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = i;
        }
        insertionSort.sort(sortedArray);
        System.out.println("Number of comparisons in sorted array: " + insertionSort.getComparisonCount());
        System.out.println("Number of swaps in sorted array: " + insertionSort.getSwapCount());

        // Test case 3: Array of 50 elements sorted in reverse order
        insertionSort = new Lab6_InsertionSort();
        int[] reverseSortedArray = new int[50];
        for (int i = 0; i < reverseSortedArray.length; i++) {
            reverseSortedArray[i] = 50 - i;
        }
        insertionSort.sort(reverseSortedArray);
        System.out.println("Number of comparisons in reverse sorted array: " + insertionSort.getComparisonCount());
        System.out.println("Number of swaps in reverse sorted array: " + insertionSort.getSwapCount());
    }
//Conclusion:
    //1. For a random array, the number of comparisons and swaps can vary but are likely to be high.
    //2. For a sorted array, the number of comparisons is maximum while the number of swaps is minimum (0), as the elements are already in order.
    //3. For a reverse sorted array, both the number of comparisons and swaps are maximum, as every element needs to be moved to its correct position.
}
