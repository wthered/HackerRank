import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int many = input.nextInt();
        for(int i=0; i<many; i++) {
            System.out.printf("Can you count to " + i + "? ");
        }
    }
}