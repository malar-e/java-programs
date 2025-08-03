public class InterfaceDemo {
    public static void main(String[] args) {
        Refund r1 = new Order(101, "Shoes", 1499.0);
        Refund r2 = new Subscription("Amazon Prime", 1);

        r1.processRefund();
        r1.showRefundPolicy();

        r2.processRefund();
        r2.showRefundPolicy();
    }
}

interface Refund {
    void processRefund();

    default void showRefundPolicy() {
        System.out.println("Standard refund policy: Refund within 7 working days.");
    }
}

class Order implements Refund {
    int orderId;
    String item;
    double amount;

    Order(int orderId, String item, double amount) {
        this.orderId = orderId;
        this.item = item;
        this.amount = amount;
    }

    @Override
    public void processRefund() {
        System.out.println("Refunding ₹" + amount + " for Order #" + orderId + " - " + item);
    }

    @Override
    public void showRefundPolicy() {
        System.out.println("Order refund policy: Refund available within 10 days of delivery.");
    }
}

class Subscription implements Refund {
    String serviceName;
    int monthsRemaining;

    Subscription(String serviceName, int monthsRemaining) {
        this.serviceName = serviceName;
        this.monthsRemaining = monthsRemaining;
    }

    @Override
    public void processRefund() {
        System.out.println("Cancelling subscription to " + serviceName +
                           " and refunding for " + monthsRemaining + " remaining month(s)");
    }

    // Not overriding showRefundPolicy(), uses default version
}
