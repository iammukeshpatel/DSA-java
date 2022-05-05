package search;

public class BinarySearch {

    int search(int arr[], int left, int right, int x) {

        if (right >= left) {
            int mid = left + (right - left) / 2;
            System.out.print("Left: - " + left);
            System.out.print(" Right: - " + right);
            System.out.print(" mid: - " + mid);
            System.out.println(" val: - " + arr[mid]);

            if (arr[mid] == x) {
                System.out.println(arr[mid]);
                return mid;
            }

            if (arr[mid] > x) {
                return search(arr, left, mid - 1, x);
            }

            return search(arr, mid + 1, right, x);
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 15, 20, 40, 100};
        int n = arr.length;
        int x = 40;

        BinarySearch bs = new BinarySearch();

        int result = bs.search(arr, 0, n - 1, x);

        System.out.println(result);
    }
}
