package service;

import utils.IntegerAsker;

import static java.lang.System.out;

public class ValidationService {
    boolean checkIfStringIsNotTooLong(String input, int maxStringLength) {
        if(input.length() > maxStringLength) {
            out.println("The string is too long - max " + maxStringLength + " chars");
            return true;
        } else return false;
    }


}
