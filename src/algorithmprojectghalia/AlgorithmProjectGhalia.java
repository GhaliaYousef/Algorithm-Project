package algorithmprojectghalia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class AlgorithmProjectGhalia {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("--------------------------------");
        System.out.println("1- insertion sort");
        System.out.println("2- selection sort");
        System.out.println("3- bubble sort");
        System.out.println("Please enter the way you want to sort your doucument :");
        Scanner input0 = new Scanner(System.in);
        int sort_type = input0.nextInt();
        if (sort_type == 1) {
            long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long startTime = System.currentTimeMillis();
            selectionSort(menu(input0));
            long stopTime = System.currentTimeMillis();
            // calcutate time
            long elapsedTime = stopTime - startTime;
            long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            // calculate memory usage 
            long actualMemUsed = afterUsedMem - beforeUsedMem;
            System.out.println("elapsed time for Selection sort: " + elapsedTime + " msec");
            System.out.println("memory usage for selection sort: " + actualMemUsed + " bytes");
        } else if (sort_type == 2) {
            long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long startTime = System.currentTimeMillis();
            insertionSort(menu(input0));
            long stopTime = System.currentTimeMillis();
            // calculate time
            long elapsedTime = stopTime - startTime;
            long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            // calculate memory usage 
            long actualMemUsed = afterUsedMem - beforeUsedMem;
            System.out.println("elapsed time for Selection sort: " + elapsedTime + " msec");
            System.out.println("memory usage for selection sort: " + actualMemUsed + " bytes");
        } else if (sort_type == 3) {
            long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long startTime = System.currentTimeMillis();
            bubbleSort(menu(input0));
            long stopTime = System.currentTimeMillis();
            // calculate time
            long elapsedTime = stopTime - startTime;
             long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            // calculate memory usage 
            long actualMemUsed = afterUsedMem - beforeUsedMem;
            System.out.println("elapsed time for Selection sort: " + elapsedTime + " msec");
            System.out.println("memory usage for selection sort: " + actualMemUsed + " bytes");
        } else {
            System.out.println("you entered a wrong number ");
        }

    } // end of main

    public static void selectionSort(ArrayList a) {
        // outer for loop to pick one element at a time
        // e.g if list is 20,12,3,4,5,6,98----this loop will first pick 20
        for (int i = 0; i < a.size(); i++) {
            
            int min = (int) a.get(i);
            int minIndex = i;
            // Go over the rest of the list and compare minimum by rest of list. If number smaller than min is found, then it is assigned as new min
            // So go over list starting from 12 and comparing 20 with each of them and finding the new min, in this case it will be  3
            for (int j = i + 1; j < a.size(); j++) {
                if ((int) a.get(j) < min) {
                    min = (int) a.get(j);
                    minIndex = j;
                  
                }
            }
            if (i != minIndex) {
                Collections.swap(a, i, minIndex);
            }
         
        }
        
    }

    public static void insertionSort(ArrayList a) {
        for (int i = 1; i < a.size(); i++) {
            int temp = (int) a.get(i);
            int j = i - 1;
            while (j >= 0 && (int) a.get(j) > temp) {
                a.set(j + 1, a.get(j));
                j = j - 1;

            }
            a.set(j + 1, temp);
        }
    }

    public static void bubbleSort(ArrayList a) {
        int n = a.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((int) a.get(j) > (int) a.get(j + 1)) {
                    // swap temp and arr[i]
                    int temp = (int) a.get(j);
                    a.set(j, a.get(j + 1));
                    a.set(j + 1, temp);
                }
            }
        }
    }

    public static ArrayList menu(Scanner input) throws FileNotFoundException {
        System.out.println("------------------------");
        System.out.println("1 - best case ");
        System.out.println("2- average case");
        System.out.println("3- worst case");
        System.out.println(" Please enter the case you want ");
        int Case = input.nextInt();
        //        creating an array list 
        ArrayList<Integer> a = new ArrayList<Integer>();
        if (Case == 1) {
            File file = new File("bestCase.txt");
            Scanner input1 = new Scanner(file);
            while (input1.hasNext()) {
                a.add(input1.nextInt());
            }
        } else if (Case == 2) {

            File file = new File("averageCase3.txt");
            Scanner input1 = new Scanner(file);
            while (input1.hasNext()) {
                a.add(input1.nextInt());
            }
        } else if (Case == 3) {

            File file = new File("worstCase.txt");
            Scanner input1 = new Scanner(file);
            while (input1.hasNext()) {
                a.add(input1.nextInt());
            }
        } else {
            System.out.println("you entered a wrong number");
        }
        input.close();
        return a;
    }
}
