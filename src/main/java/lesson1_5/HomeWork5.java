package lesson1_5;

public class HomeWork5 {

    public static void main(String[] args) {

        String[] names = new String[]{"Ivan", "Petr", "Vasiliy", "Semen", "Pavel"};
        String[] surnames = new String[]{"Ivanov", "Petrov", "Vasilev", "Semenov", "Pavlov"};
        String[] patronymics = new String[]{"Ivanovich", "Petrovich", "Vasilevich", "Semenovich", "Pavlovich"};

        Employee[] employees = new Employee[5];

        for (int i = 0; i < employees.length; i++) {
            String name = getName(names);
            String surname = getName(surnames);
            String patronic = getName(patronymics);
            employees[i] = new Employee(surname + " " + name + " " + patronic, "programmer", name + "." + surname + "@company.com", getPhoneNumber(), getRandom(100000) + 30000, getRandom(40) + 20);
            System.out.println();
            employees[i].printInfo();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printInfo();
                System.out.println();
            }
        }
    }

    public static String getName (String[] name) {
        return name[getRandom(name.length - 1)];
    }

    public static long getPhoneNumber () {
        String phone = "8916" + Integer.toString(getRandom(9999999));
        long phoneNumber = Long.parseLong(phone);
        return phoneNumber;
    }

    public static int getRandom (int max) {
        return (int) Math.round(Math.random() * max);
    }
}
