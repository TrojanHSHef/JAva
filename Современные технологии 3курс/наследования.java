class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    String breed;

    Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Woof!");
    }

    void fetch() {
        System.out.println("Fetching the ball!");
    }
}

class Cat extends Animal {
    String furColor;

    Cat(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
    }

    @Override
    void makeSound() {
        System.out.println("Meow!");
    }

    void purr() {
        System.out.println("Purring...");
    }
}
/*
 * Такой подход позволяет избежать дублирования кода, используя общий функционал Animal в классах Dog и Cat. 
 * Кроме того, подклассы могут расширять или переопределять поведение с учетом своих особенностей. 
 * 
 * Если наследование применяется без разбора, оно может привести к излишней связанности классов и сложностям в изменениях. 
 * Например, если подкласс становится слишком «тяжёлым», наследуя много ненужных свойств или методов, или если дерево наследования становится слишком глубоким, 
 * то такая структура затрудняет понимание и поддержку.
 */