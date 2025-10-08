/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author student
 */
public class инкапсуляция {
 public class BankAccount {
  private double balance; // не доступно снаружи

  public BankAccount(double initialBalance) {
    balance = initialBalance;
  }

  public void Deposit(double amount) {
    if (amount > 0) balance += amount;
  }

  public void Withdraw(double amount) {
    if (amount > 0 && amount <= balance) balance -= amount;
  }

  public double GetBalance() {
    return balance;
  }
}
   
}
/*
*Польза инкапсуляции
*Защита данных от неконтролируемого доступа и изменения.
*Сокрытие сложности реализации от пользователя класса.
*Облегчение поддержки и изменения кода без нарушения внешнего интерфейса.
*Улучшение модульности и структуры программы.
*Повышение безопасности и предотвращение ошибок.
*
*Возможный вред
*Сложность доступа к данным, когда требуется частый и прямой доступ.
*Чрезмерное усложнение интерфейса из-за излишней "защищённости".
*Может увеличить количество вспомогательных методов, усложняя код.
*/
