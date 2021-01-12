public class StringEncoding {
    public static void main(String[] args) {
        System.out.println(encode("aaaaaabbbbbaccccddeeeee"));
        System.out.println(encode("\n\n\n\n\n"));
        System.out.println(encode("f"));
        System.out.println(encode(""));
        System.out.println(encode(null));
    }

    private static String encode(String string) {
        if (string == null || string.length() < 2) {
            return string;
        }

        StringBuilder stringBuilder = new StringBuilder();
        char currentSymbol = string.charAt(0);
        int counter = 1;

        for (int i = 1; i < string.length(); ++i) {
            char c = string.charAt(i);

            if (c == currentSymbol) {
                ++counter;
            } else {
                addNewSymbol(stringBuilder, currentSymbol, counter);
                currentSymbol = c;
                counter = 1;
            }
        }
        addNewSymbol(stringBuilder, currentSymbol, counter);

        return new String(stringBuilder);
    }

    private static void addNewSymbol(StringBuilder stringBuilder, char currentSymbol, int counter) {
        stringBuilder.append(currentSymbol);
        stringBuilder.append(counter);
    }
}
