public class Rand {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args) throws Exception {
        boolean doWhileLoop = true;

        while (doWhileLoop == true) {
            int rand = getRandomNumber(1, 100);

            System.out.println("Value: " + rand + "\n");
            if (rand <= 50) {
                System.out.println("Cara.");
            } else {
                System.out.println("Cruz.");
            }
            Thread.sleep(3000);
        }
    }
}