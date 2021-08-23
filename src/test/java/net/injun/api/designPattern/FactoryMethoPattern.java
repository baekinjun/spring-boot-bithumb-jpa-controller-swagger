package net.injun.api.designPattern;

import java.util.function.Supplier;

public class FactoryMethoPattern {

}

interface Flooring {
    void installation();
}

class ConcreteFlooring implements Flooring {

    @Override
    public void installation() {
        System.out.println("컨크리트 바닥");
    }
}

class CorkFlooring implements Flooring {
    @Override
    public void installation() {
        System.out.println("코크 바닥 시공됨");
    }
}

class WoodenFlooring implements Flooring {
    @Override
    public void installation() {
        System.out.println("목재 바닥 시공됨");
    }
}

class FlooringFactory {
    static Flooring getFlooring(int min, int max) {
        Supplier<Flooring> flooringSupplier;
        if (min <= 5 && max <= 20) {
            flooringSupplier = WoodenFlooring::new;
        } else if (min <= 21 && max <= 45) {
            flooringSupplier = CorkFlooring::new;
        } else {
            flooringSupplier = ConcreteFlooring::new;
        }
        return flooringSupplier.get();
    }
}