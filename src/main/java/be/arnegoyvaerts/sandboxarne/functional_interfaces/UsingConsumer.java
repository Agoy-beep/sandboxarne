package be.arnegoyvaerts.sandboxarne.functional_interfaces;

import java.util.function.Consumer;

public class UsingConsumer {


    public static void useConsumerInt(Consumer<Integer> specifyWhatNeedsToBeDoneToT){
        specifyWhatNeedsToBeDoneToT.accept(2);
    }

    public static void useConsumerString(Consumer<String> specifyWhatNeedsToBeDoneToT){
        specifyWhatNeedsToBeDoneToT.accept("Bork");
    }
    public static void main(String[] args) {
        UsingConsumer.useConsumerInt(number -> System.out.println(number * 3));
        UsingConsumer.useConsumerString(word -> System.out.println(word + word + "\t Erk"));

    }
}
