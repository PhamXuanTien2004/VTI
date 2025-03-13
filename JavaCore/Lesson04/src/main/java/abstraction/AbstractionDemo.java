package abstraction;

import inheritence.Dog;

public class AbstractionDemo {
    public static void main(String[] args) {
    //Tính trừu tượng
    //abstract class: Không thể khởi tạo đối tượng
    Animal animal = new Animal() {
        @Override
        public void makeSound() {
            System.out.printf( "gau");
        }
    };
        animal.makeSound();
        animal.d();
    }
}
