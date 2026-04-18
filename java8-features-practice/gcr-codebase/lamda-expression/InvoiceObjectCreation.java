package lamda_expression;

import java.util.*;
import java.util.function.Function;

class Invoice {
    String id;
    Invoice(String id) {
        this.id = id;
    }
    
    public String toString() {
		return id;
    	
    }
}

public class InvoiceObjectCreation  {
    public static void main(String[] args) {
        List<String> ids = Arrays.asList("1001", "1002", "1003");

        Function<String, Invoice> invoiceCreator = Invoice::new; 

        ids.stream().map(invoiceCreator).forEach(System.out::println);
    }
}
