import java.util.Scanner;

class Info {
    String name;
    int age;
    String add;
    int num;

    Info() {

    }

    Info(int a, int b, String n, String c) {
        name = n;
        age = a;
        add = c;
        num = b;
    }

    public void collect() {
        Scanner input = new Scanner(System.in);
        System.out.print("Your Name:");
        name = input.next();
        System.out.print("Your Age:");
        age = input.nextInt();
    }

    public void display() {
        System.out.printf("Name: %s\nAge: %d", name, age);
    }
}

public class Main {
    public static void main(String[] args) {
        Info obj = new Info();
        obj.collect();
        obj.display();
    }
}
