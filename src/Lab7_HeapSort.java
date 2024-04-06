public class Lab7_HeapSort {
    private static int comparisonCount;
    private static int swapCount;

    public static void heapSort(int[] arr) {
        comparisonCount = 0;
        swapCount = 0;

        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(arr, 0, i);

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n) {
            comparisonCount++;
            if (arr[left] > arr[largest])
                largest = left;
        }

        // If right child is larger than largest so far
        if (right < n) {
            comparisonCount++;
            if (arr[right] > arr[largest])
                largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
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

        // Heap Sort random array
        heapSort(randomArray);
        System.out.println("Heap Sort for Random Array:");
        printArray(randomArray);
        System.out.println("Comparisons: " + comparisonCount);
        System.out.println("Swaps: " + swapCount);

        // Heap Sort ascending array
        heapSort(ascendingArray);
        System.out.println("\nHeap Sort for Ascending Array:");
        printArray(ascendingArray);
        System.out.println("Comparisons: " + comparisonCount);
        System.out.println("Swaps: " + swapCount);

        // Heap Sort descending array
        heapSort(descendingArray);
        System.out.println("\nHeap Sort for Descending Array:");
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
//Heap Sort's performance is affected by the initial order of the elements.
//For random arrays, Heap Sort generally performs well with an average time complexity of O(n log n).arrays. This is because the pivot selection strategy in Quick Sort doesn't work optimally for sorted arrays, leading to more comparisons and swaps.
////For ascending arrays, Quick Sort performs more comparisons and swaps compared to descending arrays.
//For already sorted arrays (either ascending or descending), the number of comparisons is significantly higher compared to random arrays.
