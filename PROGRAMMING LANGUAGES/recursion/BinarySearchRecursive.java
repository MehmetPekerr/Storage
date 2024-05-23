package recursion;

import java.util.Stack;

public class BinarySearchRecursive {
    private static Stack<Integer> middleLog = new Stack<>();
    private static Stack<Integer> topLog = new Stack<>();
    private static Stack<Integer> bottomLog = new Stack<>();

    public static int binarySearch(int[] arr, int target) {
        int bottom = 0;
        int top = arr.length - 1;
        while (bottom <= top) {
            int mid = (bottom + top) / 2;
            middleLog.push(mid);
            topLog.push(top);
            bottomLog.push(bottom);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                bottom = mid + 1;
            } else {
                top = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        System.out.println("DİZİ:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        int target = 3;
        System.out.println("\nDizide aranacak sayı: " + target);

        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println("Sayı " + index + ". indekste bulundu.");
        } else {
            System.out.println("Sayı bulunamadı.");
        }

        System.out.println("\nEski:             \t\t\t\tYeni:");
        while (!middleLog.isEmpty()) {
            int middle = middleLog.pop();
            int bottom = bottomLog.pop();
            int top = topLog.pop();
            System.out.println("Middle: " + middle + "\tBottom: " + bottom + "\tTop: " + top + "\t|\t"
                    + "Middle: " + middle + "\tBottom: " + bottom + "\tTop: " + top);
        }
    }
}
