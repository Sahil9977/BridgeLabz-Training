package annotation;

class Animal {
    void makeSound() {
        System.out.println("Some generic sound...");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog says: Woof! Woof!");
    }
}

public class TestOverride {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.makeSound();
    }
}
