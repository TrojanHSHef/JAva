import java.util.Scanner;

public class CompoundInterestCalculator {

    // Метод вычисления итоговой суммы со сложным процентом
    public static double calculateAmount(double principal, double rate, int periods) {
        return principal * Math.pow(1 + rate, periods);
    }

    // Метод нахождения ставки процента по исходным и итоговым значениям и количеству периодов
    public static double calculateRate(double principal, double amount, int periods) {
        return Math.pow(amount / principal, 1.0 / periods) - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите операцию: ");
        System.out.println("1 - Вычислить сложный процент");
        System.out.println("2 - Найти процентную ставку");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Введите исходное число (P): ");
            double principal = scanner.nextDouble();

            System.out.print("Введите процентную ставку (в %): ");
            double ratePercent = scanner.nextDouble();
            double rate = ratePercent / 100;

            System.out.print("Введите количество периодов (n): ");
            int periods = scanner.nextInt();

            double amount = calculateAmount(principal, rate, periods);
            System.out.printf("Итоговая сумма: %.4f\n", amount);

        } else if (choice == 2) {
            System.out.print("Введите исходное число (P): ");
            double principal = scanner.nextDouble();

            System.out.print("Введите итоговое число (A): ");
            double amount = scanner.nextDouble();

            System.out.print("Введите количество периодов (n): ");
            int periods = scanner.nextInt();

            double rate = calculateRate(principal, amount, periods);
            System.out.printf("Необходимая процентная ставка: %.4f%%\n", rate * 100);

        } else {
            System.out.println("Некорректный выбор операции.");
        }

        scanner.close();
    }
}
