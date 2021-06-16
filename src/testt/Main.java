package testt;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main myMain = new Main();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter string: ");
        String theString = myObj.nextLine();

        boolean result = myMain.isValidExpression(theString);
        System.out.println("result = " + result);
    }

    public boolean isValidExpression(String expression) {

        int leftIndex = -1;
        char[] leftPartOfTheString = new char[1000];
        leftPartOfTheString[0] = '0';

        for(int i = 0; i < expression.length(); i++){
            if(Character.isLowerCase(expression.charAt(i))){
                if(leftIndex < 0) return false;
                if(leftPartOfTheString[leftIndex] == Character.toUpperCase(expression.charAt(i))){
                    leftPartOfTheString[leftIndex] = '0';
                    leftIndex--;
                } else {
                    return false;
                }

            } else {
                leftIndex++;
                leftPartOfTheString[leftIndex] = expression.charAt(i);
            }
        }

        if(leftPartOfTheString[0] == '0') return true;

        return false;
    }
}
