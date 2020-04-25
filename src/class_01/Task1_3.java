package class_01;

/**
 * This class prints all even numbers from 2 to 20 inclusively and greater than 10
 */
public class Task1_3 {
    public static void main(String[] args) {
        for (int i = 2; i <= 20; i+=2) {
            if(i>10)
                System.out.print(i + " ");
        }
    }
}
