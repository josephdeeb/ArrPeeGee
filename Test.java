

public class Test {
    public static void main(String[] args) {
        ObjectHandler test = new ObjectHandler();
        int[][] array = new int[2][2];
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                array[x][y] = 1;
            }
        }
        array[1][1] = 0;
        System.out.println(test.checkBounds(0, 0, 10, 10, array));
    }
}
