import java.util.Date;

public class Spending {
  private Date date;
  private String description;
  private double value;
  private SpendingType spendingType;
  private PaymentMethod paymentMethod;

  public Spending(Date date, String description, double value, SpendingType spendingType, PaymentMethod paymentMethod) {
    this.date = date;
    this.description = description;
    this.value = value;
    this.spendingType = spendingType;
    this.paymentMethod = paymentMethod;
  }

  public String getDescription() {
    return "Payment method: " + this.paymentMethod.getDescription() + " | Description: "
        + this.spendingType.getDescription() + " | Value: U$" + this.value;
  }

  public Date getDate() {
    return this.date;
  }
}