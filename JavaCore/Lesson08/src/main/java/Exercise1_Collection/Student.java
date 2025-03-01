package Exercise1_Collection;

public class Student {

    private int id;
    private String name;
    private static int COUNT =0;

    public Student() {
    }

    public Student( String name) {
        this.id = ++ COUNT;
        this.name = name;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
