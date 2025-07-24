public class isSorted {
    public static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;  
        }

        if (arr[index] > arr[index + 1]) {
            return false;
        }

        return isSorted(arr, index + 1);
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println( arrayToString(arr));
        System.out.println(": " + isSorted(arr, 0));  

        int[] arr2 = {1, 3, 2, 4, 5};
        System.out.println( arrayToString(arr2));
        System.out.println(": " + isSorted(arr2, 0));  
    }
}
