package com.qrvey.tasks;

import com.qrvey.userinterfaces.Webpage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenWebPage implements Task {
    public static Performable webPage(){
        return Tasks.instrumented(OpenWebPage.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(Webpage.class));
    }
}
