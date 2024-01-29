package basic;

public class Address {
    private String hno;
    private String city;

    public Address() {
        super();
    }

    public Address(String hno, String city) {
        this.hno = hno;
        this.city = city;
    }

    public String getHno() {
        return hno;
    }

    public void setHno(String hno) {
        this.hno = hno;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "hno='" + hno + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
