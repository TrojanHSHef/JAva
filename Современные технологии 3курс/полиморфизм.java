abstract class Animal {
    abstract void sound();
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Гав-гав");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Мяу-мяу");
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Thread.sleep(1000); // Если нужен этот вызов
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.sound(); // Выведет: Гав-гав
        myCat.sound(); // Выведет: Мяу-мяу

        makeSound(myDog);
        makeSound(myCat);
    }

    public static void makeSound(Animal animal) {
        animal.sound();
    }
}

/* 
Польза:
Позволяет писать универсальный и масштабируемый код.
Упрощает добавление новых типов, не меняя существующий код.

Возможный вред:

Сложность понимания при слишком глубокой иерархии.
Риск неоптимальной производительности, если используется неправильно.
*/