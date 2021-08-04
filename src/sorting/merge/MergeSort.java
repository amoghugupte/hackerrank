package sorting.merge;

public class MergeSort {
    static void mergeSort (int [] arr) {
        mergeSort(arr, new int [arr.length], 0, arr.length -1);
    }

    private static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd)
            return;

        int middle = (leftStart + rightEnd)/2;
        mergeSort(arr, temp, leftStart, middle);
        mergeSort(arr, temp, middle + 1, rightEnd);
        merge (arr, temp, leftStart, rightEnd);
    }

    private static void merge(int[] arr, int []temp,  int leftStart, int rightEnd) {
        int middle = (leftStart + rightEnd)/2;
        int left = leftStart;
        int right = middle + 1;
        int size = rightEnd - leftStart + 1;
        int index = leftStart;

        while (left <= middle && right <= rightEnd) {
            if (arr [left] <= arr[right]) {
                 temp [index] = arr[left];
                 left++;
            } else {
                temp [index] = arr[right];
                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, middle - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);
    }


    public static void main(String[] args) {
        int arr [] = new int[] {2, 1, 3, 1, 2};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
