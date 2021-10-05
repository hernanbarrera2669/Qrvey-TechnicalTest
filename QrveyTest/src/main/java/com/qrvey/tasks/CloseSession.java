package com.qrvey.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.qrvey.userinterfaces.Webpage.BTN_LOGOUT;
import static com.qrvey.userinterfaces.Webpage.BTN_MENU;

public class CloseSession implements Task {

    public static CloseSession closeSession() {
        return Tasks.instrumented(CloseSession.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_MENU),
                Click.on(BTN_LOGOUT));
    }
}
