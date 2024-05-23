package recursion;

import java.util.Stack;

public class FindMinRecursive {
    public static void main(String[] args) {
    	int[] arr = {8, 3, 6, 2, 10, 7, 1, 9};
    	System.out.println("ilk dizi:");
    	for (int i = 0; i < arr.length; i++) {
    	    System.out.print(arr[i] + " ");
    	}
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> reversedStack = new Stack<>();
        int[] newArr = new int[arr.length]; // Yeni dizi
        int[] minValues = new int[arr.length]; // Eski dizideki minimum değerler

        System.out.println("\nYığıta atıldığında yeni dizi:");
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
            newArr[i] = arr[stack.firstElement()]; // Yeni diziye ekle
            min = Math.min(min, arr[i]);
            minValues[i] = min;
            System.out.print(newArr[i] + " ");
        }

        System.out.println("\nYeni Dizi Min Değerleri");
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!reversedStack.isEmpty() && arr[i] < arr[reversedStack.peek()]) {
                reversedStack.pop();
            }
            reversedStack.push(i);
            System.out.println("Index: " + i + "\tMin Değer: " + newArr[i]); // Yeni diziyi kullan
        }

        System.out.println("\nEski Dizi Min Değerleri");
        for (int i = 0; i < minValues.length; i++) {
            System.out.println("Index: " + i + "\tMin Değer: " + minValues[i]);
        }
    }
}
