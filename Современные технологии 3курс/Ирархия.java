// В пакете zoo.animals
public abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void eat();
    public abstract void sleep();
}

public abstract class Mammal extends Animal {
    public Mammal(String name, int age) {
        super(name, age);
    }

    public abstract void nurseYoung();
}

public class Lion extends Mammal implements IMovable, ISoundable {
    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        // Логика питания льва
    }

    @Override
    public void sleep() {
        // Логика сна льва
    }

    @Override
    public void nurseYoung() {
        // Логика кормления потомства
    }

    @Override
    public void move() {
        // Логика перемещения
    }

    @Override
    public void makeSound() {
        // Звук льва
    }
}

// В пакете zoo.interfaces
public interface IMovable {
    void move();
}

public interface ISoundable {
    void makeSound();
}

// В пакете zoo.management
public class Zoo {
    private List<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
}
