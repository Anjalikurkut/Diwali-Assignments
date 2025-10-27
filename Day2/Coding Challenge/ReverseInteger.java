public class ReverseInteger {
    public static int reverse(int n) {
        long res = 0;
        int num = Math.abs(n);
        while (num > 0) {
            res = res * 10 + (num % 10);
            num /= 10;
            // guard against overflow
            if (res > Integer.MAX_VALUE) return 0;
        }
        return (int) (n < 0 ? -res : res);
    }

    public static void main(String[] args) {
        int[] tests = {12345, -1200, 1000, 0, -1};
        for (int t : tests) {
            System.out.println(t + " -> " + reverse(t));
        }
    }
}