import java.util.Random;

public class LogPassGenerate {
    private static final String UPPER_CASE="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE="abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS ="0123456789";
    private static final String CHARACTERS_FULL="!@#$%^&*_=+-/.?<>()";
    private static final String CHARACTERS_SHORT="!@#$";

    static String generateLogin(){
        String fullLine = UPPER_CASE+LOWER_CASE+DIGITS+CHARACTERS_SHORT;
        StringBuilder login = new StringBuilder("");
        int loginLength = 5+(int)(Math.random()*10+1);
        Random random = new Random();
        for (int i = 0; i < loginLength; i++) {
            char symbol = fullLine.charAt(random.nextInt(fullLine.length()));
            login.append(symbol);
        }
        return login.toString();
    }

    static String generatePassword(){
        String fullLine = UPPER_CASE+LOWER_CASE+DIGITS+CHARACTERS_FULL;
        StringBuilder password = new StringBuilder("");
        int passwordLength = 8+(int)(Math.random()*10+1);
        Random random = new Random();
        for (int i = 0; i < passwordLength; i++) {
            char symbol = fullLine.charAt(random.nextInt(fullLine.length()));
            password.append(symbol);
        }
        return password.toString();
    }
}
