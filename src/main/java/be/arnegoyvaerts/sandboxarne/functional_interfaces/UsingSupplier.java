package be.arnegoyvaerts.sandboxarne.functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class UsingSupplier {

    private Double useSupplier(Supplier<Double> doubleToGet){
        return(doubleToGet.get());
    }

    public static void main(String[] args) {
        UsingSupplier supplier = new UsingSupplier();
        System.out.println(supplier.useSupplier(()-> Math.random()));

    }
}
