package lambda;

public class Main {
    public static void main(String[] args) {
        System.out.println(addOperation(1, 4));

        Math lambda1 = (a, b) -> a + b;
        System.out.println(lambda1.Calc(1, 4));

        Math lambda2 = (a, b) -> a - b;
        System.out.println(lambda2.Calc(1, 4));
    }

    public static int addOperation(int a, int b) {
        return a + b;
    }

    @FunctionalInterface
    public interface Math {
        public int Calc(int first, int second);
    }
}
