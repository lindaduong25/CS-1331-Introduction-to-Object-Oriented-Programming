public class PrimitiveOperations {
    public static void main(String[] args) {
        int numberInteger = 5;
        double numberDecimal = 3.5;
        double numberMultiply = numberInteger * numberDecimal;
        double myDouble = numberInteger;
        int myInt = (int) numberDecimal;
        char myLetter = 'A'; // ASCII Value of 'A' is 65 and 'a' is 97

        System.out.println(numberInteger);
        System.out.println(numberDecimal);
        System.out.println(numberMultiply);
        System.out.println(myDouble);
        System.out.println(myInt);
        System.out.println(myLetter);
        System.out.println((char) (myLetter + 32));
    }

}

