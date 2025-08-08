import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MyException extends Exception {
    public MyException(String string) {
        super(string);
    }
}

class A {
    public void show() {
        try {
            Class.forName("ca");
        } catch (ClassNotFoundException e) {
            System.out.println("Not found class");
        }
    }
}

class B {
    public void scan() throws IOException {
        try (BufferedReader bd = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(bd.readLine());
            System.out.println(num);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        int i = 0;
        int j = 0;
        int[] arr = new int[5];

        try {
            j = 23 / i;
            if (i == 0) {
                throw new ArithmeticException("Number should no be zero");
            }

        } catch (ArithmeticException e) {
            j = 23 / 1;
            System.out.println("Default value");
        }

        try {
            System.out.println(arr[5]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Array exceeds its limit");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }

        System.out.println(j);

        BufferedReader bf = null;
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            bf = new BufferedReader(in);

            int sum = Integer.parseInt(bf.readLine());
            System.out.println(sum);
        } catch (IOException e) {
            System.out.println("Error");
        } finally {
            System.out.println("Everthing done..!!");
        }

        A obj = new A();
        obj.show();

        B obj2 = new B();
        try {
            obj2.scan();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (i == 0) {
                throw new MyException("Number should no be zero");
            }
            j = 23 / i;

        } catch (MyException e) {
            j = 23 / 1;
            System.out.println("Default value..");
        }
    }
}