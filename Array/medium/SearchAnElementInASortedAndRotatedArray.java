package array.medium;

public class SearchAnElementInASortedAndRotatedArray {
    // Online Java Compiler
// Use this editor to write, compile and run your Java code online

    static int search(int A[], int l, int h, int key) {
        int pivot = 0;
        pivot = findPivot(A, l, h);
        if (pivot != -1 && A[l] < key && key < A[pivot])
            return binarySearch(A, l, pivot, key);
        else if (pivot != -1 && A[pivot + 1] < key && key < A[h])
            return binarySearch(A, pivot + 1, h, key);
        else
            return binarySearch(A, l, h, key);
    }

    static int findPivot(int[] A, int s, int e) {
        if (s == e) {
            if (e == 0) return -1;
            return s;
        }
        while (s < e) {
            int mid = (s + e) / 2;
            if (A[mid] > A[e]) findPivot(A, mid, e - 1);
            else findPivot(A, s, mid);
        }
        return -1;
    }

    static int binarySearch(int[] A, int s, int e, int key) {
        int mid = (s + e) / 2;
        if (A[mid] == key) return mid;
        while (s <= e) {
            if (A[mid] < key) binarySearch(A, mid + 1, e, key);
            if (A[mid] > key) binarySearch(A, s, mid, key);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(search(arr, 0, 8, 10));
    }
}

