package constructor;

public class Dog {
    public String name;
    int age;

    public Dog(String name){
        this.age = 21;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
