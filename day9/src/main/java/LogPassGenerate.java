import java.util.Random;

class LogPassGenerate {
    private static final String UPPER_CASE="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE="abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS ="0123456789";
    private static final String CHARACTERS="!@#$%^&*_/?<>";

    static String generateLogin(){
        String fullLine = UPPER_CASE+LOWER_CASE+DIGITS;
        StringBuilder login = new StringBuilder();
        int loginLength = 5+(int)(Math.random()*5+1);
        Random random = new Random();
        for (int i = 0; i < loginLength; i++) {
            char symbol = fullLine.charAt(random.nextInt(fullLine.length()));
            login.append(symbol);
        }
        return login.toString();
    }

    static String generatePassword(){
        String fullLine = UPPER_CASE+LOWER_CASE+DIGITS+CHARACTERS;
        StringBuilder password = new StringBuilder();
        int passwordLength = 8+(int)(Math.random()*7+1);
        Random random = new Random();
        for (int i = 0; i < passwordLength; i++) {
            char symbol = fullLine.charAt(random.nextInt(fullLine.length()));
            password.append(symbol);
        }
        return password.toString();
    }
}
