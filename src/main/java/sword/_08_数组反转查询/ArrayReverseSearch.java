package sword._08_数组反转查询;

public class ArrayReverseSearch {

    public static int ArrayReverseSearch(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;

        while (array[left] >= array[right]) {
            if (right - left <= 1) {
                mid = right;
                break;
            }
            mid = (left + right) / 2;
            if (array[left] == array[mid] && array[mid] == array[right]) {
                if (array[left + 1] != array[right - 1]) {
                    mid = array[left + 1] < array[right - 1] ? left + 1 : right - 1;
                } else {
                    left++;
                    right--;
                }
            } else {
                if (array[left] <= array[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return array[mid];
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 6, 0, 1, 2};
        System.out.println(ArrayReverseSearch(array));
    }
}
