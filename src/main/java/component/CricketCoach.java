package component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    @PostConstruct
    public void afterInit(){
        System.out.println("after construct...............");
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("before destroy.................");
    }
    public CricketCoach() {
        System.out.println("cricket coach constructor...");
    }

    @Override
    public String getDailyWorkout() {
        return "this is cricket coach...";
    }
}
