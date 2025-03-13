package accessmodifier;

import constructor.Dog;

public class AccessModifierDemo {
    public static void main(String[] args) {
        //Phạm vi truy cập
        // Dùng cho: class, method, property
        // public

//        Cat cat = new Cat();
//        System.out.println("Name Cat: " + cat.name);
//        Dog dog = new Dog("ABC", 20);
//        System.out.println(dog);

        // protected: có thể truy cp trong cùng package
        // default: có thể truy cp trong cùng package
//        System.out.println("dog.name = " + dog.name);


        // private: chỉ dùng trong class đó
//        System.out.println("cat.age = " + cat.age);


    }
}
