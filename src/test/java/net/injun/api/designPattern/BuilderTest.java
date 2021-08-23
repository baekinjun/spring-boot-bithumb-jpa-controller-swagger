package net.injun.api.designPattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BuilderTest {
    @Data
    @AllArgsConstructor
    class Mobile {
        private final int ram;
        private final int storage;
        private final int battery;
        private final int camera;
        private final String processor;
        private final double screenSize;

        public Mobile(MobileBuilder builder) {
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.battery = builder.battery;
            this.camera = builder.camera;
            this.processor = builder.processor;
            this.screenSize = builder.screenSize;
        }
    }

    @Data
    class MobileBuilder {
        private int ram; /* if final, Default Constructor Error */
        private int storage;
        private int battery;
        private int camera;
        private String processor;
        private double screenSize;

        public MobileBuilder with(Consumer<MobileBuilder> buildFields) {
            buildFields.accept(this);
            return this;
        }

        //builder
        public Mobile createMobile() {
            return new Mobile(this);
        }
    }

    @Test
    @DisplayName("빌더 패턴")
    void main() {
        //consumer 써서 소비해서 빌더를 만든다 생성자를 생성
        MobileBuilder builder = new MobileBuilder();
        Mobile myMobile = builder.with(myBuilder -> {
            myBuilder.ram = 7;
            myBuilder.battery = 7000;
            myBuilder.processor = "A12";
        }).createMobile();

        assertThat(myMobile.getRam(), is(7));
        assertThat(myMobile.getBattery(), is(7000));
        assertThat(myMobile.getProcessor(), is("A12"));
    }
}
