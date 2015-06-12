class EscapeSpaces {

    public static void main(String... args) {
        System.out.println(escapeWhitespace(args[0]));
    }


    private static String escapeWhitespace(String input) {
        char[] chars = input.toCharArray();
        int length = chars.length;
        
        while (chars[length - 1] == ' ') {
            length--;
        }
        
        int spaces = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                spaces++;
            }
        }
        
        int newPosition = length + spaces*2 - 1;
        for (int i = length - 1; i >=0; i--) {
            if (chars[i] == ' ') {
                chars[newPosition--] = '0';
                chars[newPosition--] = '2';
                chars[newPosition--] = '%';
            } else {
                chars[newPosition--] = chars[i];
            }   
        }
        
        return new String(chars);
    }
}