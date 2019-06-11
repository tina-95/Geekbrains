import java.util.Arrays;

public class homework2 {
    public static void main(String[] args) {
        /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        */
        int [] doOne = {1,1,0,0,1,0,1,1,0,0};
        for(int i=0; i<doOne.length; i++){
            if (doOne[i]==0) {
                doOne[i]=1;}
            else {
                doOne[i]=0;

            }
        }
        System.out.println("Задание 1: " + Arrays.toString(doOne));

        /* 2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
         */

        int [] doTwo = new int [8];
        for (int i=0; i<doTwo.length; i++){
            doTwo[i]=i*3;
        }
        System.out.println("Задание 2: " + Arrays.toString(doTwo));


        /*3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом,
        и числа, меньшие 6, умножить на 2;
         */

        int [] doThree ={1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i=0; i<doThree.length; i++){
            if(doThree[i]<6){
                doThree[i]=doThree[i]*2;
            }
        }
        System.out.println("Задание 3: " + Arrays.toString(doThree));

        /*4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
         */

        int [][] doFour=new int [3][3];
        for (int i = 0; i < doFour.length; i++) {
            for (int j = 0; j < doFour.length; j++)
                if ((i == j) || (i == doFour.length - 1 - j)) {
                    doFour[i][j] = 1;
                }
        }
        System.out.println("Задание 4: ");
        printArr(doFour);


        /* 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);*/
        int [] doFive = {1,2,3,4,5,6,7,8,9};
        int min = doFive[0];
        int max = doFive[0];
        System.out.println("Задание 5: ");

        for (int i = 0; i < doFive.length; i++) {
            min = (min < doFive[i]) ? min : doFive[i];
            max = (max > doFive[i]) ? max : doFive[i];
        }
        System.out.println("минималный элемент - " + min + " ,максимальный элемент - " + max);

         /* 6.Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        если в массиве есть место, в котором сумма левой и правой части массива равны.
        Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
        checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят;
         */

        System.out.println("Задание 6: "+ doSix(new int[]{1,1,2,3,1})); // сам метод в конце файла находится

        /* 7.*Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или отрицательным),
        при этом метод должен сместить все элементы массива на n позиций. Нельзя пользоваться вспомогательными массивами.
         */
        System.out.println("Задание 7: ");
        doSeven(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, -2); // меод расписан в конце файла



    }



        public static void printArr(int [][] arr){
            for (int i=0; i<arr.length;i++){
                for (int j=0; j<arr[i].length;j++){
                    System.out.print (arr[i][j]+"\t");
                }
                System.out.println();
            }
        }
    /* 6.Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
           если в массиве есть место, в котором сумма левой и правой части массива равны.
           Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
           checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят;
            */
    static boolean doSix ( int [] arr){
        int rSum= 0;
        int lSum = 0;
        for (int i = 0; i < arr.length + 1; i++) {
            lSum = 0;
            rSum = 0;

            for (int j = 0; j < i; j++) {
                lSum += arr[j];
            }

            for (int j = i; j < arr.length; j++) {
                rSum += arr[j];
            }

            if (lSum == rSum) return true;
        }
        return false;


    }

    /* 7.*Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или отрицательным),
       при этом метод должен сместить все элементы массива на n позиций. Нельзя пользоваться вспомогательными массивами.
        */
    static void doSeven(int[] arr, int n) {

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                // Право
                int tmp = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = tmp;
            }
        } else if (n < 0) {
            for (int i = 0; i < n * (-1); i++) {
                // Лево
                int tmp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = tmp;
            }
        }
        
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    
}
