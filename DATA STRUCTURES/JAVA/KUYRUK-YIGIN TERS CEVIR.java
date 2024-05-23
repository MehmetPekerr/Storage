package mehmet;


import java.util.Scanner;

public class Mehmet_Peker_Odev1 {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public Mehmet_Peker_Odev1(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
        } else {
            System.out.println("Stack dolu, eklenemiyor " + value);
        }
    }

    public int pop() {
        if (top >= 0) {
            return stackArray[top--];
        } else {
            System.out.println("Stack boş");
            return -1; 
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static int[] reverseInput(int[] inputSequence) {
    	Mehmet_Peker_Odev1 stack = new Mehmet_Peker_Odev1(inputSequence.length);


        for (int item : inputSequence) {
            stack.push(item);
        }

 
        int[] reversedSequence = new int[inputSequence.length];
        int index = 0;
        while (!stack.isEmpty()) {
            reversedSequence[index++] = stack.pop();
        }

        return reversedSequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen bir dizi giriş girin (örneğin: 1 2 3 4): ");
        String[] inputString = scanner.nextLine().split(" ");


        int[] inputSequence = new int[inputString.length];
        for (int i = 0; i < inputString.length; i++) {
            inputSequence[i] = Integer.parseInt(inputString[i]);
        }


        int[] result = reverseInput(inputSequence);


        System.out.print("Giriş Sırası: ");
        for (int item : inputSequence) {
            System.out.print(item + " ");
        }

        System.out.println("\nTersine Çevrilen Sıra: ");
        for (int item : result) {
            System.out.print(item + " ");
        }
    }
}