import java.util.Scanner;

public class Main {
    static int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b, a%b);
    }
    static void commonDiv(int a, int b){
        int g = gcd(a,b);
        int result = 1;
        for(int i = 1; i <= g; i++){
            if ( g % i == 0){
                    result = g / i;
                System.out.println(result);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Please input first positive integer: ");
        Scanner sc1 = new Scanner(System.in);
        String s1 = sc1.nextLine();
        int a = Integer.parseInt(s1);
        System.out.println("Please input second positive integer: ");
        Scanner sc2 = new Scanner(System.in);
        String s2 = sc2.nextLine();
        int b = Integer.parseInt(s2);
        System.out.println("All common divisors of these two integers: ");
        commonDiv(a,b);
    }
}