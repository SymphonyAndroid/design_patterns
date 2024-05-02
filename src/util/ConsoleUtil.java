package util;

import java.util.Scanner;

public class ConsoleUtil {

    public static int printMenu(String... array) {
        for (String s : array) System.out.println(s);
        try
        {
            int it = new Scanner(System.in).nextInt();
            if (it >= 0 && it <= array.length) return it;
            System.out.println("Помилка вводу! Спробуйте ще раз");
            return printMenu(array);
        } catch (Exception e) {
            System.out.println("Помилка вводу! Спробуйте ще раз");
        }
        return printMenu(array);
    }

    public static int scanInt() {
        return scanInt(0, Integer.MAX_VALUE);
    }

    public static int scanInt(int min, int max) {
        try {
            int it = new Scanner(System.in).nextInt();
            if (it >= min && it <= max) return it;
            System.out.println("Помилка вводу! Спробуйте ще раз");
            return scanInt();
        } catch (Exception e) {
            System.out.println("Помилка вводу! Спробуйте ще раз");
            return scanInt();
        }
    }

    public static float scanFloat() {
        try {
            return new Scanner(System.in).nextFloat();
        } catch (Exception e) {
            System.out.println("Помилка вводу! Спробуйте ще раз");
            return scanFloat();
        }
    }

}
