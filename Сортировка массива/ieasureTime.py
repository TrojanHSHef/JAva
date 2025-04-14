import time

class MeasureTime:
    def measure_sorting_time(sort_function, arr):
        start_time = time.time()  # Запоминаем время до сортировки
        sort_function(arr)  # Выполняем сортировку
        end_time = time.time()  # Запоминаем время после сортировки
        return end_time - start_time  # Возвращаем разницу времени