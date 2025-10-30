public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;  // Флаг для отслеживания, были ли обмены на этой итерации
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Обмен элементов
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Если не было обменов, массив уже отсортирован
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 2};
        System.out.println("Массив до сортировки:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        bubbleSort(array);

        System.out.println("Массив после сортировки:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
