package com.qrvey.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static com.qrvey.userinterfaces.SortByProduct.CMB_FILTER;

public class FilterProduct implements Task {
    private String filter;

    protected FilterProduct(String filter) {
        this.filter = filter;
    }

    public static FilterProduct sortProduct(String filter) {
        return Tasks.instrumented(FilterProduct.class, filter);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectFromOptions.byVisibleText(filter).from(CMB_FILTER));
    }
}
