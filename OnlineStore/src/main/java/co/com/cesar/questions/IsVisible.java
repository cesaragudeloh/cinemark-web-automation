package co.com.cesar.questions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IsVisible implements Question<Boolean> {

    private Target target;

    public IsVisible(Target target) {
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isVisible())
                        .forNoMoreThan(30)
                        .seconds(),
                Scroll.to(target)
        );
        return target.resolveFor(actor).isCurrentlyVisible();
    }


    public static IsVisible theTarget(Target target) {
        return Instrumented.instanceOf(IsVisible.class).withProperties(target);
    }

}
