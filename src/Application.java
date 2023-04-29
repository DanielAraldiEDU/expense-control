import java.util.Date;

public class Application {
  public PaymentMethod[] paymentMethods;
  public SpendingType[] spendingTypes;
  private Spending[] spendings;

  public Application(SpendingType[] spendingTypes, PaymentMethod[] paymentMethods) {
    this.paymentMethods = paymentMethods;
    this.spendingTypes = spendingTypes;
    this.spendings = new Spending[9999];
  }

  public void addPaymentMethod(PaymentMethod paymentMethod) {
    for (int i = 0; i < this.paymentMethods.length; i++) {
      if (this.paymentMethods[i] == null) {
        this.paymentMethods[i] = paymentMethod;
        System.out.println("Payment method added.");
        return;
      }
    }

    System.out.println("Payment method not added. Try again.");
  }

  public void addSpendingType(SpendingType spendingType) {
    for (int i = 0; i < this.spendingTypes.length; i++) {
      if (this.spendingTypes[i] == null) {
        this.spendingTypes[i] = spendingType;
        System.out.println("Spending type added.");
        return;
      }
    }

    System.out.println("Spending type not added. Try again.");
  }

  public void listSpendings(int month, int year) {
    for (Spending spending : this.spendings) {
      if (spending == null) {
        break;
      }

      int currentYear = year - 1900;
      if (spending != null && spending.getDate().getMonth() == month && spending.getDate().getYear() == currentYear) {
        System.out.println(spending.getDescription());
      }
    }
  }

  public void newSpending(String description, Date date, double value, SpendingType spendingType,
      PaymentMethod paymentMethod) {
    for (int i = 0; i < this.spendings.length; i++) {
      if (spendings[i] == null) {
        System.out.println("New spending added.");
        spendings[i] = new Spending(date, description, value, spendingType, paymentMethod);
        return;
      }
    }

    System.out.println("New spending not added. Try again.");
  }
}