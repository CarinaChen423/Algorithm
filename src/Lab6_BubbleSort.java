import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Lab6_BubbleSort {

    // Bubble Sort Method with comparison and swap count
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        int comparisonCount = 0;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Count the comparison
                comparisonCount++;

                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Count the swap
                    swapCount++;
                }
            }
        }

        System.out.println("Comparisons: " + comparisonCount);
        System.out.println("Swaps: " + swapCount);
        return arr;
    }

    // Main method to test the bubble sort with different types of arrays
    public static void main(String[] args) {
        Random random = new Random();

        // Create and sort an array of 50 random elements
        int[] randomArray = random.ints(50, 0, 100).toArray();
        System.out.println("Random Array: " + Arrays.toString(randomArray));
        bubbleSort(randomArray.clone());

        // Create and sort an array of 50 sorted elements
        int[] sortedArray = Arrays.stream(randomArray).sorted().toArray();
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        bubbleSort(sortedArray.clone());

        // Create and sort an array of 50 elements sorted in reverse order
        int[] reverseSortedArray = Arrays.stream(sortedArray).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("Reverse Sorted Array: " + Arrays.toString(reverseSortedArray));
        bubbleSort(reverseSortedArray.clone());
    }
}
//Conclusion:
//For the array of 50 random elements, the number of comparisons will be consistent because it depends on the size of the array, but the number of swaps will vary depending on the initial order of the elements.
//For the array of 50 sorted elements, the number of comparisons will remain the same as in the previous case, but the number of swaps will be minimal (possibly zero) because the array is already sorted.
//For the array of 50 elements sorted in reverse order, both the number of comparisons and the number of swaps will be maximal since every element will need to be moved to its correct position.
