class BubbleSortMassive:
    # 1. Реализация сортировки пузырьком (Bubble Sort)
    def bubble_sort(arr):
        n = len(arr)
        for i in range(n):
            # flag для проверки, были ли перестановки
            swapped = False
            for j in range(0, n - i - 1):
                if arr[j] > arr[j + 1]:
                    arr[j], arr[j + 1] = arr[j + 1], arr[j]  # меняем местами
                    swapped = True
            if not swapped:
                break  # если за проход не было перестановок, значит, список отсортирован