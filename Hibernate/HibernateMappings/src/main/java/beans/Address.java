package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
    @Id
    @Column(name = "Id")
    private int id;
    @Column(name = "HouseNo")
    private int hNo;
    @Column(name="Ward")
    private String ward;
    @Column(name="City")
    private String city;
    @Column(name="State")
    private String state;
    @Column(name="Country")
    private String country;
    @Column(name="PinCode")
    private int pincode;
    @OneToOne(mappedBy = "address")
    private Employee emp;


    public Address() {
    }

    public Address(int id,int hNo, String ward, String city, String state, String country, int pincode,Employee emp) {
        this.id=id;
        this.hNo = hNo;
        this.ward = ward;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.emp=emp;
    }

    public void sethNo(int hNo) {
        this.hNo = hNo;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int gethNo() {
        return hNo;
    }

    public String getWard() {
        return ward;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public int getPincode() {
        return pincode;
    }

    public Employee getEmp() {
        return emp;
    }

    @Override
    public String toString() {
        return "Address{" +
                "hNo=" + hNo +
                ", ward='" + ward + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pincode=" + pincode +
                ", emp=" + emp +
                '}';
    }
}
