import java.util.ArrayList;
import java.util.List;

// Композиция: "Часть" зависит от "Целого" и создается внутри него
class Car {
    private List<Wheel> wheels;

    public Car() {
        wheels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            wheels.add(new Wheel("Колесо " + (i + 1)));
        }
    }

    public void showWheels() {
        for (Wheel wheel : wheels) {
            System.out.println(wheel.getName());
        }
    }
}

class Wheel {
    private String name;

    public Wheel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Агрегация: "Часть" существует отдельно и передается в "Целое"
class University {
    private List<Student> students;

    public University() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Основной класс с методом main
public class CompositionAggregation {
    public static void main(String[] args) {
        // Композиция: колеса создаются внутри машины и принадлежат только ей
        Car car = new Car();
        car.showWheels();

        // Агрегация: студенты создаются отдельно и потом добавляются в университет
        Student student1 = new Student("Иван");
        Student student2 = new Student("Мария");

        University university = new University();
        university.addStudent(student1);
        university.addStudent(student2);

        university.showStudents();

        // Тут студенты могут существовать сами по себе вне университета
    }
}
/*В композиции связь между объектами является жесткой: "целое" полностью управляет "частью", 
и часть создается и уничтожается вместе с целым. Например, колёса машины не существуют отдельно от самой машины.

В агрегации связь более мягкая: часть может существовать самостоятельно, независимо от целого, 
и жизненный цикл части не зависит от целого. Например, студенты могут существовать вне университета, а университет просто ссылается на них. */