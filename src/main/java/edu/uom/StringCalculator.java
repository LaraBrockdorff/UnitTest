package edu.uom;

public class StringCalculator {

    public int add(String numbers){

        //check for null, trim and empty stirng
        if (numbers == null || numbers.trim().length()==0){
            System.out.println("Empty String");
            return 0;
        }

        //assume single number
        try {
            return Integer.parseInt(numbers);
        }catch (NumberFormatException nfe){
            return -1;
        }

    }
}
