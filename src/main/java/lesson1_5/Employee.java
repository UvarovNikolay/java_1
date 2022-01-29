package lesson1_5;

public class Employee {

    private String fullName;
    private String position;
    private String email;
    private long phoneNumber;
    private int salary;
    private int age;

    //Constructor
    public Employee(String fullName, String position, String email, long phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Возраст: " + age);
        System.out.println("Должность: " + position);
        System.out.println("Зарплата: " + salary + "₽");
        System.out.println("email: " + email);
        System.out.println("Тel: " + phoneNumber);

    }
}
