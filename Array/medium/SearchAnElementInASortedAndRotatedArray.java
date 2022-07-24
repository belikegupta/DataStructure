package Array.medium;

public class SearchAnElementInASortedAndRotatedArray {
    // Online Java Compiler
// Use this editor to write, compile and run your Java code online

    static int search(int A[], int l, int h, int key) {
        int pivot = 0;
        pivot = findPivot(A, l, h);
        if (pivot != -1 && A[l] <= key && key <= A[pivot])
            return binarySearch(A, l, pivot, key);
        else if (pivot != -1 && A[pivot + 1] < key && key <= A[h])
            return binarySearch(A, pivot + 1, h, key);
        else
            return binarySearch(A, l, h, key);
    }

    static int findPivot(int[] A, int s, int e) {
        if (s == e) return s;
        if (e < s) return -1;
        int mid = (s + e) / 2;
        if (mid < e && A[mid] > A[mid + 1]) return mid;
        if (mid > s && A[mid] < A[mid - 1]) return mid - 1;
        if (A[s] >= A[mid])
            return findPivot(A, s, mid - 1);
        return findPivot(A, mid + 1, e);

    }

    static int binarySearch(int[] A, int s, int e, int key) {
        while (s <= e) {
            int mid = (s + e) / 2;
            if (A[mid] == key) return mid;
            if (A[mid] < key) s = mid + 1;
            if (A[mid] > key) e = mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(search(arr, 0, 8, 3));
    }
}

//optimize solution TC=O(log n) and SC=O(1).

class solution {
    static int search(int arr[], int l, int h, int key) {
        if (l > h)
            return -1;
        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;
        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return search(arr, mid + 1, h, key);
        }
        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarray*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);
        return search(arr, l, mid - 1, key);
    }
}

