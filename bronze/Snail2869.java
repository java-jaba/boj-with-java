import java.util.Scanner;
// 백준 2869. 달팽이는 올라가고 싶다
public class Snail2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int day = sc.nextInt();
        int night = sc.nextInt();
        int total = sc.nextInt();

        int count = (total-night)/(day-night);

        // 나머지가 있을 경우 (하나 더 올라가야 할 경우)
        if ((total - night) % (day - night) != 0) {
            count++;
        }

        System.out.println(count);
    }
}
