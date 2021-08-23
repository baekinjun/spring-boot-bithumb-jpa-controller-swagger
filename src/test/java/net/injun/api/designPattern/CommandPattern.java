package net.injun.api.designPattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CommandPattern {
    class Aircon {
        void turnOn() {
            System.out.println("에어컨 켜기");
        }

        void turnOff() {
            System.out.println("에어컨 끄기");
        }

        void increaseTemp() {
            System.out.println("온도 올리기");
        }

        void decreaseTemp() {
            System.out.println("온도 내리기");
        }

    }
    //consumer가 마지막에 실행을 시켜야 한다!
    interface Command {
        void execute();
    }

    class AirconRemoteControl {
        Command command;

        void setCommand(Command command) {
            this.command = command;
        }

        void buttonPress() {
            command.execute();
        }
    }

    @Test
    @DisplayName("커맨드 패턴 테스트")
    void main() {
        Aircon aircon = new Aircon();
        AirconRemoteControl airconRemoteControl = new AirconRemoteControl();

        airconRemoteControl.setCommand(aircon::turnOn);
        airconRemoteControl.buttonPress(); //subscribe 의 원리를 설명한다.
    }
}
