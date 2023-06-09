
import java.time.LocalTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // task1();
        // task11();
        // task2();
        // task3();

        task4();

    }

    private static int findPfx(String[] lines) {
        int res = 0;
        boolean pfxExst = true;

        do {
            res++;
            for (int i = 0; i < lines.length - 1; i++) {
                if (res < lines[i].length() && res < lines[i + 1].length()) {

                    if (lines[i].substring(0, res).compareTo(lines[i + 1].substring(0, res)) != 0) {
                        pfxExst = false;
                        res--;
                    }
                }
            }

        } while (pfxExst);

        return res;
    }

    private static void task4() {
        /*
         * Напишите метод, который находит самую длинную строку общего
         * префикса среди массива строк.
         * Если общего префикса нет, вернуть пустую строку "".
         */

        String[] lines = { "dom", "domovoy", "domashniy" };

        System.out.printf("Prefix length: %d", findPfx(lines));
    }

    private static void task3() {
        /*
         * Дан массив nums = [3,2,2,3] и число val = 3.
         * Если в массиве есть числа, равные заданному, нужно перенести
         * эти элементы в конец массива.
         * Таким образом, первые несколько (или все) элементов массива
         * должны быть отличны от заданного, а остальные - равны ему.
         */

        int[] nums = { 1, 1, 0, 3, 1, 3, 0, 1, 0, 3 };
        int[] newNums = new int[nums.length];
        int count = 0;
        int index = 0;

        Scanner iScanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int val = iScanner.nextInt();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                newNums[index++] = nums[i];
            } else {
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            newNums[index++] = val;
        }

        for (int itemNums : nums) {
            System.out.printf("%d\t", itemNums);
        }

        System.out.println();

        for (int itemNewNums : newNums) {
            System.out.printf("%d\t", itemNewNums);
        }

    }

    private static void task2() {
        /*
         * Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести
         * максимальное количество подряд идущих 1.
         */

        int[] arr = { 1, 1, 0, 1, 1, 1 };
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            } else if (count > maxCount) {
                maxCount = count;
                count = 0;
            }
        }
        if (count > maxCount) {
            maxCount = count;

        }

        System.out.printf("Maximum numbers of 1: %s\n", maxCount);

    }

    private static void task11(String name) {
        /*
         * В консоли запросить имя пользователя. В зависимости от
         * текущего времени, вывести приветствие вида
         * "Доброе утро, <Имя>!", если время от 05:00 до 11:59
         * "Добрый день, <Имя>!", если время от 12:00 до 17:59;
         * "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
         * "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
         */

        // Scanner iScanner = new Scanner(System.in);
        LocalTime TimeOfDay = LocalTime.now();

        // System.out.print("Enter your name: ");
        // String name = iScanner.nextLine();

        if (TimeOfDay.getHour() >= 5 && TimeOfDay.getHour() < 12) {
            System.out.printf("Good morning, %s!\n", name);
        } else if (TimeOfDay.getHour() >= 12 && TimeOfDay.getHour() < 18) {
            System.out.printf("Good day, %s!\n", name);
        } else if (TimeOfDay.getHour() >= 18 && TimeOfDay.getHour() < 23) {
            System.out.printf("Good evening, %s!\n", name);
        } else if (TimeOfDay.getHour() >= 23 && TimeOfDay.getHour() < 5) {
            System.out.printf("Good nignt, %s!\n", name);
        }
    }

    private static void task1() {
        /*
         * Написать программу, которая запросит пользователя ввести <Имя> в консоли.
         * Получит введенную строку и выведет в консоль мообщение "Привет, мир!"
         */

        Scanner iScanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = iScanner.nextLine();

        task11(name);
        // System.out.printf("Hello, %s!\n", name);
    }
}
