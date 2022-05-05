package sort;

public class BubbleSort {

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]= temp;
    }

    void sort(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n-1; i ++) {
            for(int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    void print(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        BubbleSort ob = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 100, 22, 11, 90};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.print(arr);
    }
}
