public class Homework4 {
// 4. Создать массив из 5 сотрудников:

    public static void main(String [] args) {
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Ivanov Ivan", "Engineer", " ivivan@mailbox.com ", "892312312", 30000, 30);
        persArray[1] = new Employee("Ivanov Igor", "cleaner", " ivivan@mailbox.com ", "892312312", 30000, 33);
        persArray[2] = new Employee("Sidorov Ivan", "teacher", " ivivan@mailbox.com ", "892312312", 30000, 45);
        persArray[3] = new Employee("Ivanov Sidor ", "manager", " ivivan@mailbox.com ", "892312312", 30000, 50);
        persArray[4] = new Employee("Ivanov Oleg ", "manager", " ivivan@mailbox.com ", "892312312", 30000, 24);

// С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) {
                persArray[i].employeeInfo();
            }
            }
        }
    }
