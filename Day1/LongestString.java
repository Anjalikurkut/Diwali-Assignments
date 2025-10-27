public class LongestString {
    public static void main(String[] args) {
        String[] arr = {"apple", "mango", "strawberry", "kiwi", "pineapple"};

        int maxLength = 0;
        for (String str : arr) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }

        System.out.println("Length of longest string in the array: " + maxLength);
    }
}