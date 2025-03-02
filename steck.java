// Класс Stack представляет структуру данных "Стек"
class Stack<T> {

    // Узел стека, содержащий данные и ссылку на следующий узел
    private static class Node<T> {
        T data; // Данные узла
        Node<T> next; // Ссылка на следующий узел

        Node(T data) {
            this.data = data; // Инициализация данных узла
        }
    }

    private Node<T> top; // Указатель на верхний элемент стека

    // Метод для добавления элемента на верх стека
    public void push(T item) {
        Node<T> newNode = new Node<>(item); // Создаем новый узел с данными
        newNode.next = top; // Указываем новому узлу ссылку на текущий верхний узел
        top = newNode; // Обновляем указатель на верхний элемент стека
    }

    // Метод для удаления и возвращения верхнего элемента стека
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Пусто"); // Генерация исключения, если стек пуст
        }
        T item = top.data; // Сохраняем данные верхнего элемента
        top = top.next; // Обновляем указатель на верхний элемент
        return item; // Возвращаем данные удаленного элемента
    }

    // Метод для просмотра верхнего элемента стека без его удаления
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Мимо"); // Генерация исключения, если стек пуст
        }
        return top.data; // Возвращаем данные верхнего элемента
    }

    // Метод для проверки, пустой ли стек
    public boolean isEmpty() {
        return top == null; // Возвращает true, если стек пуст
    }

    // Главный метод для тестирования стека
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(); // Создаем экземпляр стека

        stack.push(1); // Добавляем элемент 1
        stack.push(2); // Добавляем элемент 2
        stack.push(3); // Добавляем элемент 3

        System.out.println(stack.peek());  // Выводит: 3 (верхний элемент)
        System.out.println(stack.pop());   // Выводит: 3 (удаляем верхний элемент)
        System.out.println(stack.isEmpty()); // Выводит: false (стек не пуст)
    }
}
