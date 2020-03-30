package class_01;

import java.util.Scanner;

/**
 * This class swaps every two neighbor elements of array
 */
public class Task1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // User enter the number of elements
        int sizeOfArray = sc.nextInt();
        System.out.println("Typed size of array is: "+sizeOfArray);
        int[] array = new int[sizeOfArray];
        System.out.println("\nInitial array:");
        for (int i = 0; i < sizeOfArray;i++) {
            array[i] = (int) Math.round(Math.random()*100);
            System.out.print(array[i]+" ");
        }

        for (int i = 0; i < array.length; i+=2) {
            int temp = array[i];
            array[i] = array[i+1];
            array[i+1] = temp;
        }
        System.out.println("\nResult array:");
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}