package rentalstore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void statement() {

        Customer customer=new Customer("howells");

        String result=  customer.statement();

        assertEquals("Rental Record for howells\n" +
                "Amount owed is0.0\n" +
                "You earned0 frequent renter points",result);
    }
}