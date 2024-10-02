package component;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("tennis coach constructor...");
    }

    @Override
    public String getDailyWorkout() {
        return "this is tennis coach...";
    }
}
