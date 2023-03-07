
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1000000); // int uri generate pana la un milion
        int binaryNum = Integer.parseInt("10101", 2);
        int hexaNum = Integer.parseInt("FF", 16);

        n *= 3;
        n += binaryNum;
        n += hexaNum;
        n *=6;

        while (n >= 10) {
            int sum = 0;
            while (n > 0) {
                sum += (n % 10);
                n = n / 10;
            }
            n = sum;
        }


        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);

    }
}