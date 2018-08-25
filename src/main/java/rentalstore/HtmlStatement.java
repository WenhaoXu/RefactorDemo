package rentalstore;

import java.util.Enumeration;

import static java.lang.String.*;

public class HtmlStatement extends  Statement{
    protected String getEachItem(Enumeration rentals, String result) {
        while(rentals.hasMoreElements()){
            double thisAmount =0;
            Rental each = (Rental) rentals.nextElement();
            thisAmount = getEachAmount(thisAmount, each);
            frequentRenterPoints ++;
            if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1){
                frequentRenterPoints ++;
            }
            result = result + format("\t%s\t%s<BR>\n", each.getMovie().getTitle(), valueOf(thisAmount));
            totalAmount += thisAmount;
        }
        return result;
    }
    protected String getFooterResult(double totalAmount, int frequentRenterPoints) {
        return "<P>You owe<EM>" + valueOf(totalAmount) + "</EM><P>\n"+"On this rental you earned <EM>" + valueOf(frequentRenterPoints) + "</EM> frequent renter points<P>";
    }

    protected String getHeaderResult(Customer customer) {
        return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>\n";
    }
}
