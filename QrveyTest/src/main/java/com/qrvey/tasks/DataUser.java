package com.qrvey.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import static com.qrvey.userinterfaces.DataUserInterface.TXT_USER;
import static com.qrvey.userinterfaces.DataUserInterface.TXT_PASSWORD;
import static com.qrvey.userinterfaces.DataUserInterface.BTN_LOGIN;
import net.serenitybdd.screenplay.actions.Click;

public class DataUser implements Task {

    private String user;
    private String password;

    protected DataUser(
            String user,
            String password) {
        this.user = user;
        this.password = password;
    }

    public static DataUser dataOfLogin(String user, String password) {
        return Tasks.instrumented(DataUser.class, user, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(user).into(TXT_USER),
                Enter.theValue(password).into(TXT_PASSWORD),
                Click.on(BTN_LOGIN));
    }
}
