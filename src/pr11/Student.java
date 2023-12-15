package pr11;

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getID() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int compareTo(Student otherStudent) {
        return Integer.compare(this.getID(), otherStudent.getID());
    }
    @Override
    public String toString() {
        return "Cтудент: " +
                "Номер в списке: " + id +
                "; Имя: " + name;
    }
}
