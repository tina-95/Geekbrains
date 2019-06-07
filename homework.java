
public class Homework {
    public static void main(String[] args) {

System.out.println ("Задание 3: " + taskThree(1,2,6,3) );
System.out.println ("Задание 4: "+ taskFour (5,5));
        taskFive (1);
        System.out.println("Задание 6: "+ taskSix(2));
     taskSeven ("герой");
     taskEight (2018);


    }
//2 Создать переменные всех пройденных типов данных, и инициализировать их значения;

      static void taskTwo(){ byte y = 0;
        short s = 0;
        char h = 'c';
        int i = 0;
        long l = 0L;
        float f = 0.0f;
        double ou = 0.0;
        boolean boo = false;
        String word ="Hello";}

/* 3  Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    где a, b, c, d – входные параметры этого метода;*/
    static int taskThree (int a, int b, int c, int d) {
        return a * (b + (c / d));

    }
    /* 4 Написать метод, принимающий на вход два числа, и проверяющий,
    что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false;*/
     static boolean taskFour (int x, int y){

         if (x+y >=10 && x+y<=20) {return true;}
         else
         {return false;}
     }

     /* 5 Написать метод, которому в качестве параметра передается целое число,
     метод должен напечатать в консоль положительное число передали или отрицательное (Замечание: ноль считаем положительным числом.);
      */
     static void taskFive (int q){
         if (q>=0){ System.out.println("Задание 5: Число положительное");}
         else{
         System.out.println("Задание 5: Число отрицательное");}

     }
     /* 6 Написать метод, которому в качестве параметра передается целое число,
     метод должен вернуть true, если число отрицательное;
      */
     static boolean taskSix (int z){
         if (z<0) return true;
         return false;
     }

     /* 7 Написать метод, которому в качестве параметра передается строка,
     обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
      */

     static void taskSeven (String name){
         System.out.println("Задание 7: Привет, "+ name);

     }

     /* 8 Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
     Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
      */
     static void taskEight (int year){
         if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0))) System.out.println("Задание 8: "+year + " не високосный");
         else System.out.println("Задание 8: "+ year + " високосный");
     }

}
