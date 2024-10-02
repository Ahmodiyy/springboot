package component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "this is tennis coach...";
    }
}
