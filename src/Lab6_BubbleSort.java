public class Lab6_BubbleSort {
    static int bubbleSort(int[] arr){
        int n = arr.length;
        int temp;
        int count = 0;
        for(int i=0; i < n; i++){
            for(int j =1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        int arr[] = {3,60,35,2,45,320,5};
        System.out.println("Array before bubble sort: ");
        for(int i= 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
        bubbleSort(arr);
        System.out.println("Array after bubble sort: ");
        for(int i=0;i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
    }
}
