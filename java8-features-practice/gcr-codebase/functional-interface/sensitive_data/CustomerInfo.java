package functional_interface.sensitive_data;

public class CustomerInfo  {
    private String name;
    private String ssn;

    public CustomerInfo(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "CustomerInfo{name='" + name + "', ssn='" + ssn + "'}";
    }
}
