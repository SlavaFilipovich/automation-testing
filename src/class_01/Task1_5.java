package class_01;

import java.util.Scanner;

/**
 * This class shifts all the elements of array to the right by 2 positions
 */
public class Task1_5 {
    private static int delta = 2;
    private static int[] rightPart = new int[delta];
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
        shiftOfArray(array);
        System.out.println("\nResult array:");
        for (int i : array) {
            System.out.print(i+" ");
        }
    }

    private static void shiftOfArray(int[] array) {
        int j=0;
        for (int i = sizeOfArray-delta; i < sizeOfArray; i++) {
            rightPart[j] = array[i];
            j++;
        }
        if (sizeOfArray - delta >= 0) {
            System.arraycopy(array, 0, array, delta, sizeOfArray - delta);
        }
        System.arraycopy(rightPart, 0, array, 0, delta);
    }
}
