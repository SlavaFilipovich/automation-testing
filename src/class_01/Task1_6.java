package class_01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * This class converts existing array to Collection and outputs sorted elements using Stream
 */
public class Task1_6 {
    private static int sizeOfArray;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // User enter the number of elements
        sizeOfArray = sc.nextInt();
        System.out.println("Typed size of array is: "+sizeOfArray);
        int[] array = new int[sizeOfArray];
        System.out.println("\nInitial array:");
        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = (int) Math.round(Math.random()*100);
            System.out.print(array[i]+" ");
        }
        List<Integer> collection = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println("\nResult after handling:");
        collection.stream().filter(num -> num%2 == 0 && num<=20 && num > 10).sorted().forEach(Task1_6::printFormat);
    }

    private static void printFormat(int i){
        System.out.printf("%d ",i);
    }

}
