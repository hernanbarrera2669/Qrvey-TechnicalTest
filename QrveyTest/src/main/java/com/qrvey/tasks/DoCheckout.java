package com.qrvey.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.qrvey.userinterfaces.DataCheckout.*;

public class DoCheckout implements Task {

    private String name;
    private String lastName;
    private String zipCode;

    protected DoCheckout(String name,String lastName, String zipCode) {
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    public static DoCheckout buyProduct(String name, String lastName, String zipCode) {
        return Tasks.instrumented(DoCheckout.class, name, lastName,zipCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CHECKOUT),
                Enter.theValue(name).into(TXT_NAME),
                Enter.theValue(lastName).into(TXT_LAST_NAME),
                Enter.theValue(zipCode).into(TXT_ZIP_CODE),
                Click.on(BTN_CONTINUE),
                Click.on(BTN_FINISH)
        );
    }
}
