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

    protected  double getEachAmount(double thisAmount, Rental each){
        if (each.getMovie().getPriceCode() == Movie.REGULAR) {
            thisAmount += 2;
            if (each.getDayRented() > 2) {
                thisAmount += (each.getDayRented() - 2) * 1.5;
            }
            return thisAmount;
        }
        if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE) {
            thisAmount += each.getDayRented() * 3;
            return thisAmount;
        }
        if (each.getMovie().getPriceCode() == Movie.CHILDRENS) {
            thisAmount += 1.5;
            if (each.getDayRented() > 3) {
                thisAmount += (each.getDayRented() - 3) * 1.5;
            }
            return thisAmount;
        }
        return thisAmount;
    };
}
