package basic;

public class Student {
    private int id;
    private String name;
    private ArrayList<String> subjects;
    private HashMap<String, Integer> marks;
    private Address address;

    public Student() {
        super();
    }

    public Student(int id, String name, ArrayList<String> subjects, HashMap<String, Integer> marks, Address address) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public HashMap<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(HashMap<String, Integer> marks) {
        this.marks = marks;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
