

public class Test {
    public static void main(String[] args) {
        int[][] array = new int[2][2];
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                array[x][y] = 1;
            }
        }
        array[1][1] = 0;
    }
}
