package component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("cricket coach constructor...");
    }

    @Override
    public String getDailyWorkout() {
        return "this is cricket coach...";
    }
}
