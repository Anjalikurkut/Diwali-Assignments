public class DAY02_QuickSortStrings {
    public static void quickSort(String[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(String[] arr, int low, int high) {
        if (low >= high) return;
        int p = partition(arr, low, high);
        quickSort(arr, low, p - 1);
        quickSort(arr, p + 1, high);
    }

    private static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                String tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
            }
        }
        String tmp = arr[i+1]; arr[i+1] = arr[high]; arr[high] = tmp;
        return i+1;
    }

    public static void main(String[] args) {
        String[] arr = {"delta","alpha","charlie","bravo","echo"};
        quickSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
    }
}