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
            switch (each.getMovie().getPriceCode()){
                case Movie.REGULAR:
                    thisAmount += 2;
                    if(each.getDayRented() > 2){
                        thisAmount+=(each.getDayRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount+=each.getDayRented()*3;
                    break;
                    case Movie.CHILDRENS:
                        thisAmount+=1.5;
                        if(each.getDayRented() > 3){
                            thisAmount += (each.getDayRented() -3)*1.5;
                        }
                        break;
            }
            frequentRenterPoints ++;
            if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1){
                frequentRenterPoints ++;
            }
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        return result;
    }

    protected String getHeaderResult(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }


}
