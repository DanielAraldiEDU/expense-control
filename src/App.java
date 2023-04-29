import java.util.Date;

public class App {
  public static void main(String[] args) throws Exception {
    SpendingType[] spendingTypes = new SpendingType[9999];
    PaymentMethod[] paymentMethods = new PaymentMethod[9999];
    Application application = new Application(spendingTypes, paymentMethods);

    PaymentMethod paymentMethod = new PaymentMethod("Credit Card");
    SpendingType spendingType = new SpendingType("Food");

    application.addPaymentMethod(paymentMethod);
    application.addSpendingType(spendingType);
    application.newSpending("Food", new Date(), 25, spendingType, paymentMethod);
    application.listSpendings(3, 2023);
  }
}
