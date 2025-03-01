package constructor;

public class department {
    public String nameDepartment;
    public int id ;

    public department(){}

    public department(String nameDepartment) {
        this.nameDepartment = nameDepartment;
        this.id = 0;
    }

    @Override
    public String toString() {
        return "department{" +
                "nameDepartment='" + nameDepartment + '\'' +
                ", id=" + id +
                '}';
    }
}
