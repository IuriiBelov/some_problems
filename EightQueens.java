import java.util.Scanner;

public class EightQueens {
    static class Queen {
        int x;
        int y;
    }

    static final int FIELD_SIZE = 8;

    public static void main(String[] args) {
        Queen[] queens = new Queen[FIELD_SIZE];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < FIELD_SIZE; ++i) {
            queens[i].x = scanner.nextInt();
            queens[i].y = scanner.nextInt();
        }
        scanner.close();

        boolean no = true;
        outer:
        for (int i = 0; i < FIELD_SIZE; ++i) {
            for (int j = i + 1; j < FIELD_SIZE; ++j) {
                if (queens[j].x == queens[i].x || queens[j].y == queens[i].y ||
                        Math.abs(queens[j].x - queens[i].x) == Math.abs(queens[j].y - queens[i].y)) {
                    no = false;
                    break outer;
                }
            }
        }

        if (no) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
