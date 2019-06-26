public class Homework4 {
// 4. Создать массив из 5 сотрудников:

    public static void main(String [] args) {
        System.out.println("1 часть домашней работы");
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

        System.out.println(" 2 часть домашней работы");
//9. Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.
        Animal cat1=new Cat(200,2,0);
        Animal dog1=new Dog(400, 0.5,10);//ограничение на бег 400
        Animal dog2=new Dog(600, 0.5,10);//Ограничение на бег 600
        System.out.println("Кошка 1");
        cat1.run(150);
        cat1.jump(1);
        cat1.swim(14);

        System.out.println("Собака 1");
        dog1.run(200);
        dog1.jump(0.4);
        dog1.swim(5);

        System.out.println("Собака 2");
        dog2.run(500);
        dog2.jump(0.4);
        dog2.swim(5);

    }
    }
