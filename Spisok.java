class TreeNode {
    int value; // значение узла
    TreeNode left; // ссылка на левое поддерево
    TreeNode right; // ссылка на правое поддерево

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    TreeNode root; // корень дерева

    BinaryTree() {
        this.root = null; // при создании дерева корень равен null
    }

    // Метод для вставки нового значения в дерево
    void insert(int value) {
        root = insertRec(root, value);
    }

    // Рекурсивный метод для вставки значения
    TreeNode insertRec(TreeNode root, int value) {
        // Если текущий узел пуст, создаем новый узел
        if (root == null) {
            return new TreeNode(value);
        }

        // Рекурсивно вставляем в левое или правое поддерево
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root; // возвращаем (неизменившийся) узел
    }

    // Метод для симметричного обхода дерева (in-order traversal)
    void inorder() {
        inorderRec(root);
    }

    // Рекурсивный метод для симметричного обхода
    void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left); // посещаем левое поддерево
            System.out.print(root.value + " "); // выводим значение узла
            inorderRec(root.right); // посещаем правое поддерево
        }
    }

    // Метод для поиска значения в дереве
    boolean search(int value) {
        return searchRec(root, value);
    }

    // Рекурсивный метод для поиска
    boolean searchRec(TreeNode root, int value) {
        // Если узел пуст, значение не найдено
        if (root == null) {
            return false;
        }
        // Если значение совпадает с текущим узлом
        if (value == root.value) {
            return true;
        }
        // Рекурсивно ищем в левом или правом поддереве
        return (value < root.value) ? searchRec(root.left, value) : searchRec(root.right, value);
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Вставка значений в дерево
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Симметричный обход дерева
        System.out.println("Симметричный обход дерева:");
        tree.inorder(); // Вывод: 20 30 40 50 60 70 80

        // Поиск значений в дереве
        System.out.println("\nПоиск значения 40: " + tree.search(40)); // Вывод: true
        System.out.println("Поиск значения 90: " + tree.search(90)); // Вывод: false
    }
}
