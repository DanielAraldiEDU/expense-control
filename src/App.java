import java.util.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    SpendingType[] spendingTypes = new SpendingType[9999];
    PaymentMethod[] paymentMethods = new PaymentMethod[9999];
    Application application = new Application(spendingTypes, paymentMethods);

    int option;

    do {
      System.out.println("Select something:\n\n1 - Create payment method\n2 - Create spending type\n3 - List all spendings\n4 - Create new speding\n5 - Exit\n");

      Scanner scanner = new Scanner(System.in);
      option = scanner.nextInt();

      switch (option) {
        case 1: {
          System.out.print("Enter payment method name: ");

          scanner = new Scanner(System.in);
          String description = scanner.nextLine();

          PaymentMethod paymentMethod = new PaymentMethod(description);
          application.addPaymentMethod(paymentMethod);

          break;
        }
        case 2: {
          System.out.print("Enter spending type name: ");

          scanner = new Scanner(System.in);
          String description = scanner.nextLine();

          SpendingType spendingType = new SpendingType(description);
          application.addSpendingType(spendingType);

          break;
        }
        case 3: {
          System.out.println("List all spendings:");

          System.out.print("Enter month: (0 until 11) ");
          scanner = new Scanner(System.in);
          int month = scanner.nextInt();

          System.out.print("Enter year: ");
          scanner = new Scanner(System.in);
          int year = scanner.nextInt();

          application.listSpendings(month, year);

          break;
        }
        case 4: {
          System.out.println("Enter new spending:");

          System.out.print("Enter a description: ");
          scanner = new Scanner(System.in);
          String description = scanner.nextLine();

          System.out.print("Enter value of the spending: ");
          scanner = new Scanner(System.in);
          double value = scanner.nextDouble();

          System.out.println("Select a spending type:");
          int spendingTypesOption = 0;
          SpendingType spendingType = new SpendingType("");
          for (int index = 0; index < application.spendingTypes.length; index++) {
            if (application.spendingTypes[index] != null) {
              spendingTypesOption++;
              System.out.println((index + 1) + " - " + application.spendingTypes[index].getDescription());
            }
          }

          if (spendingTypesOption == 0) {
            System.out.println("Spending type ins't exists!");
            break;
          } else {
            System.out.print("Enter value of the spending: ");
            scanner = new Scanner(System.in);
            int spendingTypeIndex = scanner.nextInt();
            if (spendingTypesOption > (spendingTypeIndex - 1) && (spendingTypeIndex - 1) >= 0) {
              spendingType = application.spendingTypes[spendingTypeIndex - 1];
            } else {
              System.out.println("Invalid spending type!");
              break;
            }
          }

          System.out.println("Select a payment method:");
          int paymentMethodOption = 0;
          PaymentMethod paymentMethod = new PaymentMethod("");
          for (int index = 0; index < application.paymentMethods.length; index++) {
            if (application.paymentMethods[index] != null) {
              paymentMethodOption++;
              System.out.println((index + 1) + " - " + application.paymentMethods[index].getDescription());
            }
          }

          if (paymentMethodOption == 0) {
            System.out.println("Speding type ins't exists");
            break;
          } else {
            System.out.print("Enter value of the payment method: ");
            scanner = new Scanner(System.in);
            int paymentMethodIndex = scanner.nextInt();
            if (paymentMethodOption > (paymentMethodIndex - 1) && (paymentMethodIndex - 1) >= 0) {
              paymentMethod = application.paymentMethods[paymentMethodIndex - 1];
            } else {
              System.out.println("Invalid payment method!");
              break;
            }
          }

          application.newSpending(description, new Date(), value, spendingType, paymentMethod);

          break;
        }
        case 5: {
          System.out.println("You exited!");
          break;
        }
        default: {
          System.out.println("Invalid type entering!\n");
          break;
        }
      }
    } while (option != 5);
  }
}
