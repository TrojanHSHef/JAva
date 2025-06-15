from BubbleSortMassiveClass import BubbleSortMassive
from MeasureTime import MeasureTime
import random

small_array = [random.randint(0, 1000) for _ in range(1000)]  # Массив из 1000 элементов
large_array = [random.randint(0, 1000) for _ in range(10000)]  # Массив из 10000 элементов

# Сортировка массива с использованием сортировки пузырьком
bubble_small_time = MeasureTime.measure_sorting_time(BubbleSortMassive.bubble_sort, small_array[:])  # Копируем массив для точности измерений
bubble_large_time = MeasureTime.measure_sorting_time(BubbleSortMassive.bubble_sort, large_array[:])

# Выводим результаты
print(f"Bubble Sort (1000 элементов): {bubble_small_time:.6f} секунд")
print(f"Bubble Sort (10000 элементов): {bubble_large_time:.6f} секунд")