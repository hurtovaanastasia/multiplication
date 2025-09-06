import java.util.Scanner;

public class Main {

    public static int Addition(int a, int b) {
        int result = 0;
        int times = Math.abs(b);

        for (int i = 0; i < times; i++) {
            result += a;
        }

        if (b < 0) {
            result = -result;
        }
        return result;
    }

    public static int Shifts(int a, int b) {
        int result = 0;
        boolean bool = false;

        if (a < 0) {
            a = -a;
            bool = !bool;
        }
        if (b < 0) {
            b = -b;
            bool = !bool;
        }

        while (b > 0) {
            if ((b & 1) == 1) {
                result += a;
            }
            a <<= 1;
            b >>= 1;
        }

        return bool ? -result : result;
    }
    public static int Recursive(int a, int b) {
        if (b == 0) return 0;
        if (b > 0) {
            int half = Recursive(a, b / 2);
            if (b % 2 == 0) {
                return half + half;
            } else {
                return half + half + a;
            }
        }
        return -Recursive(a, -b);
    }
    public static int Logs(int a, int b) {
        if (a == 0 || b == 0) return 0;
        boolean bool = (a < 0) ^ (b < 0);
        a = Math.abs(a);
        b = Math.abs(b);
        int result = (int)Math.round(Math.exp(Math.log(a) + Math.log(b)));
        return bool ? -result : result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();

        System.out.println("Выберите метод умножения:");
        System.out.println("1 - через сложение");
        System.out.println("2 - через сдвиги");
        System.out.println("3 - через рекурсию");
        System.out.println("4 - через логарифмы");
        System.out.print("Ваш выбор: ");
        int choice = scanner.nextInt();
        int result;
        if (choice == 1) {
            result = Addition(a, b);
        } else if (choice == 2) {
            result = Shifts(a, b);
        } else if (choice == 3) {
            result = Recursive(a, b);
        } else if (choice == 4) {
            result = Logs(a, b);
        } else {
            System.out.println("Такого нет!");
            scanner.close();
            return;
        }
        System.out.println("Результат: " + result);
        scanner.close();
    }
}
