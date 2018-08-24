package rentalstore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void should_return_txt_statement_when_invoke_statement_function() {

        Customer customer=new Customer("howells");

        String result=  customer.statement();

        assertEquals("Rental Record for howells\n" +
                "Amount owed is0.0\n" +
                "You earned0 frequent renter points",result);
    }

    @Test
    public void should_return_txt_statement_when_invoke_html_statement_function() {

        Customer customer=new Customer("howells");

        String result=  customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>howells</EM></H1><P>\n" +
                "Roman Holiday: 3.0<BR>\n" +
                "Titanic: 3.0<BR>\n" +
                "<P>You owe<EM>6.0</EM><P>\n" +
                "On this rental you earned <EM>2</EM> frequent renter points<P>",result);
    }
}