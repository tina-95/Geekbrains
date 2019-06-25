public class Employee {


    //1.  Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;

    private String FIO;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    //2. Конструктор класса должен заполнять эти поля при создании объекта;
    public Employee(String _FIO, String _position, String _email, String _phone, int _salary, int _age) {
        this.FIO = _FIO;
        this.position = _position;
        this.email = _email;
        this.phone = _phone;
        this.salary = _salary;
        this.age = _age;
    }
    public int getAge() {
        return age;
    }

//3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    public void employeeInfo() {
        System.out.println ("Имя:" +FIO + " Должность: "+position + " Почта: "+email +" Телефон: "+phone +" Зарплата: "+salary +" Возраст: "+age );
    }
}

