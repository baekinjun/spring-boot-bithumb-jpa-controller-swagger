package net.injun.api.designPattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class IteratorTest {
    class MyArrayList {
        Object[] elements = new Object[5];

        MyArrayList(Object[] elements) {
            this.elements = elements;
        }

        void forEach(Consumer<Object> action) {
            for (Object element : elements) {
                action.accept(element);
            }
        }
    }

    @Test
    @DisplayName("이터레이터 테스트 패턴")
    void main() {
        MyArrayList list = new MyArrayList(new Object[]{
                1, 3, 5, 7, 8
        });
        list.forEach(System.out::println);
    }
}

