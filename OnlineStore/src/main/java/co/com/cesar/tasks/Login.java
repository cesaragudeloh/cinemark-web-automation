package co.com.cesar.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.cesar.userinterfaces.LoginPage.*;

public class Login implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MODAL_WINDOW),
                Click.on(LOGIN_OPTION),
                Enter.theValue("automationtestbc@yopmail.com").into(USERNAME_INPUT),
                Enter.theValue("Colombia2024#").into(PASSWORD_INPUT),
                Click.on(LOGIN_BUTTON)
        );
    }

    public static Login onThePage(){
        return Instrumented.instanceOf(Login.class).withProperties();
    }
}
