package com.qrvey.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.qrvey.userinterfaces.DataUserInterface.TXT_USER;

public class VerifySessionClosed implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return TXT_USER.resolveFor(actor).isPresent();
    }

    public static VerifySessionClosed isCorrect() {
        return new VerifySessionClosed();
    }
}
