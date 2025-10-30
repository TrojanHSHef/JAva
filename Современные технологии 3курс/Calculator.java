import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение (например, 2 * 6.5): ");
        String input = scanner.nextLine();

        // Разбиваем строку на части по пробелам
        String[] parts = input.trim().split(" ");
        if (parts.length != 3) {
            System.out.println("Неверный формат ввода. Ожидается: число оператор число");
            return;
        }

        try {
            double num1 = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double num2 = Double.parseDouble(parts[2]);

            double result;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Ошибка: деление на ноль");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Ошибка: неподдерживаемый оператор");
                    return;
            }

            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введены некорректные числа");
        }
    }
}
