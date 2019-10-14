package be.arnegoyvaerts.sandboxarne.functional_interfaces;

import java.util.function.UnaryOperator;

public class UsingUnaryOperator {

    public static String usingUnaryOperator(UnaryOperator<String> doThisToOneString){
        return doThisToOneString.apply("Er");
    }

    public static void main(String[] args) {
        System.out.println(UsingUnaryOperator.usingUnaryOperator(word -> "Derp" + word ));
    }
}
