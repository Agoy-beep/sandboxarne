package be.arnegoyvaerts.sandboxarne.functional_interfaces;

import java.util.function.BinaryOperator;

public class UsingBinaryOperator {

    public static String usingBinaryOperator(BinaryOperator<String> doThisToTwoStrings){
        return doThisToTwoStrings.apply("Er", "Der");
    }

    public static void main(String[] args) {
        System.out.println(UsingBinaryOperator.usingBinaryOperator((word,word2) -> word + word2));
    }
}
