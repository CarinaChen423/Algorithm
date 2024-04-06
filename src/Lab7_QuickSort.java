public class Lab7_QuickSort {
    private static int comparisonCount;
    private static int swapCount;

    public static void quickSort(int[] arr) {
        comparisonCount = 0;
        swapCount = 0;

        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisonCount++;
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        swapCount++;
    }

    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(50);
        int[] ascendingArray = generateAscendingArray(50);
        int[] descendingArray = generateDescendingArray(50);

        // Quick Sort random array
        quickSort(randomArray);
        System.out.println("Quick Sort for Random Array:");
        printArray(randomArray);
        System.out.println("Comparisons: " + comparisonCount);
        System.out.println("Swaps: " + swapCount);

        // Quick Sort ascending array
        quickSort(ascendingArray);
        System.out.println("\nQuick Sort for Ascending Array:");
        printArray(ascendingArray);
        System.out.println("Comparisons: " + comparisonCount);
        System.out.println("Swaps: " + swapCount);

        // Quick Sort descending array
        quickSort(descendingArray);
        System.out.println("\nQuick Sort for Descending Array:");
        printArray(descendingArray);
        System.out.println("Comparisons: " + comparisonCount);
        System.out.println("Swaps: " + swapCount);
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100); // Generating random integers between 0 to 99
        }
        return arr;
    }

    private static int[] generateAscendingArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private static int[] generateDescendingArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i - 1;
        }
        return arr;
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
//Conclusion:
//Quick Sort's performance is affected by the initial order of the elements.
//For random arrays, Quick Sort generally performs well with an average time complexity of O(n log n).
//For already sorted arrays (either ascending or descending), the number of comparisons is significantly higher compared to random arrays. This is because the pivot selection strategy in Quick Sort doesn't work optimally for sorted arrays, leading to more comparisons and swaps.
//For ascending arrays, Quick Sort performs more comparisons and swaps compared to descending arrays. This is because in ascending arrays, the pivot is selected from the highest element and then moved to the end, leading to more swaps.
