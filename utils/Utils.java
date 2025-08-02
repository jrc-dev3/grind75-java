package utils;

public class Utils {

    public void quickSort(int[] arr, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int pivot = arr[end - 1];
        int lptr = start;
        int rptr = end - 1;

        // when ptrs meet, lptr reached first element bigger or equal to pivot
        while (lptr < rptr) {

            // while less, keeping pushing forward till we find first element bigger than
            // pivot
            while (arr[lptr] < pivot && lptr < rptr) {
                lptr++;
            }

            // while greater, push back till we find first element smaller or equal to pivot
            while (arr[rptr] >= pivot && lptr < rptr) {
                rptr--;
            }

            // swap pointer values as first biggest should be to right of pivot and
            // vice-versa
            int temp = arr[lptr];
            arr[lptr] = arr[rptr];
            arr[rptr] = temp;
        }

        // lptr is bigger than pivot at this point, so swap lptr with pivot since pivot
        // <= lptr at this point

        int temp = pivot;
        arr[end - 1] = arr[lptr];
        arr[lptr] = temp;

        quickSort(arr, start, lptr);
        quickSort(arr, lptr + 1, end);

    }

    public int bs(int[] nums, int target) {

        int lptr = 0;
        int rptr = nums.length - 1;

        while (lptr <= rptr) {

            int mid = ((rptr - lptr) / 2) + lptr;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                lptr = mid + 1;
                continue;
            }

            rptr = mid - 1;
        }

        return -1;

    }

}
