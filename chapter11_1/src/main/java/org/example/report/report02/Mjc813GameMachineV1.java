package org.example.report.report02;

import javax.management.BadAttributeValueExpException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Mjc813GameMachineV1 {
    private int battery = 0;
    private MarioGame game1;

//	public Mjc813GameMachineV1() {
//	}
//
//	public Mjc813GameMachineV1(int bat, MarioGame game) {
//		this.battery = bat;
//		this.game1 = game;
//	}

    public void runGame1() throws BatteryLessThan5Exception, Game1IsNullException {
        if ( battery < 5 ) {
            // 배터리 5% 미만 이라는 예외를 만들어서 던져보세요
            // 예외클래스 이름은 BatteryLessThan5Exception
            throw new BatteryLessThan5Exception("Battery is less than 5");
        }
        if ( game1 == null ) {
            // game1 소프트웨어가 없다 라는 예외를 만들어서 던져 보세요
            // 예외클래스 이름은 Game1IsNullException
            throw new Game1IsNullException("Game1 is null");
        }
        game1.runGame();
    }
}
