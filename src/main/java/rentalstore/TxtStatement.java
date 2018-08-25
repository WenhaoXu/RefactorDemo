package rentalstore;

import java.util.Enumeration;


public class TxtStatement extends  Statement{
    protected String getFooterResult(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is" + String.valueOf(totalAmount) + "\n"+"You earned" + String.valueOf(frequentRenterPoints) + " frequent renter points";
    }
    protected String getEachItem(Enumeration rentals, String result) {
        while(rentals.hasMoreElements()){
            double thisAmount =0;
            Rental each = (Rental) rentals.nextElement();
            thisAmount = getEachAmount(thisAmount, each);
            frequentRenterPoints ++;
            if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1){
                frequentRenterPoints ++;
            }
            result += String.format("\t%s\t%s\n", each.getMovie().getTitle(), String.valueOf(thisAmount));
            totalAmount += thisAmount;
        }
        return result;
    }

    protected String getHeaderResult(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }
}
