package sort;

public class SelectionSort {

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]= temp;
    }

    void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if(arr[j] < arr[i]) {
                    swap(arr, i, j);
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

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int arr[] = {64, 25, 12, 22, 11};
        ss.sort(arr);

        System.out.println("Sorted array");
        ss.print(arr);
    }
}
