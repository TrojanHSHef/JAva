import java.util.Scanner;

public class LeapYearChecker {
    public static boolean isLeapYear(int year) {
        // Год високосный, если он кратен 400 или если кратен 4, но не кратен 100
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год: ");

        try {
            String input = scanner.nextLine();
            int year = Integer.parseInt(input);  // Может выбросить NumberFormatException
            
            if (year <= 0) {
                throw new IllegalArgumentException("Год должен быть положительным числом.");
            }

            if (isLeapYear(year)) {
                System.out.println(year + " — високосный год.");
            } else {
                System.out.println(year + " — не високосный год.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено не число.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
