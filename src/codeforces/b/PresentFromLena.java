
import java.util.Scanner;

public class PresentFromLena {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int amountOfLevels = n * 2 + 1;
        String[] res = new String[amountOfLevels];
        for (int level = 0; level < n + 1; level++) {
            StringBuilder sb = new StringBuilder();
            for (int spaces = 0; spaces < (n - level); spaces++) {
                sb.append(" ");
            }
            if (level == 0) {
                sb.append(0);
            } else {
                for (int digit = 0; digit <= level; digit++) {
                    sb.append(digit);
                }
                for (int digit = level - 1; digit >= 0; digit--) {
                    sb.append(digit);
                }
            }
            res[level] = sb.toString();
        }

        for (int i = n - 1; i >= 0; i--) {
            res[n * 2 - i] = res[i];
        }

        for (int i = 0; i < amountOfLevels; i++) {
            System.out.println(res[i]);
        }
    }
}