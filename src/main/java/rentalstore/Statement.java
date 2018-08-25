package rentalstore;

import java.util.Enumeration;

public abstract class  Statement {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    public String statement(Customer customer) {
        Enumeration rentals = customer.getRentals().elements();
        String result = getHeaderResult(customer);
        result = getEachItem(rentals, result);
        result += getFooterResult(totalAmount, frequentRenterPoints);
        return result;
    }
    protected abstract String getFooterResult(double totalAmount, int frequentRenterPoints);

    protected abstract String getEachItem(Enumeration rentals, String result);

    protected abstract String getHeaderResult(Customer customer);

}
