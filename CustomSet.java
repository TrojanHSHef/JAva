public class CustomSet<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public CustomSet() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // Добавление элемента
    public boolean add(E element) {
        if (contains(element)) return false;
        
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    // Удаление элемента
    public boolean remove(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                fastRemove(i);
                return true;
            }
        }
        return false;
    }

    // Проверка наличия элемента
    public boolean contains(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // Получение текущего размера
    public int size() {
        return size;
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return size == 0;
    }

    // Очистка множества
    public void clear() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // Вспомогательные методы
    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index+1, elements, index, numMoved);
        }
        elements[--size] = null; // Очистка ссылки
    }

    // Реализация toString для удобного вывода
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size-1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Пример использования
    public static void main(String[] args) {
        CustomSet<String> cities = new CustomSet<>();
        
        cities.add("Москва");
        cities.add("Санкт-Петербург");
        cities.add("Новосибирск");
        cities.add("Москва"); // Дубликат не добавится
        
        System.out.println(cities); // [Москва, Санкт-Петербург, Новосибирск]
        
        cities.remove("Санкт-Петербург");
        System.out.println(cities); // [Москва, Новосибирск]
        
        System.out.println("Содержит Казань: " + cities.contains("Казань")); // false
        System.out.println("Размер множества: " + cities.size()); // 2
    }
}

