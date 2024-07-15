package co.com.cesar.tasks;

import co.com.cesar.interaction.ClickJS;
import co.com.cesar.userinterfaces.BuyMealPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.cesar.userinterfaces.MainPage.CONTENT_LOADER;
import static co.com.cesar.userinterfaces.MainPage.CONTINUE_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class BuyMeal implements Task {

    private String category;
    private String meal;

    public BuyMeal(String category, String meal) {
        this.category = category;
        this.meal = meal;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickJS.onTarget(BuyMealPage.FOOD_CATEGORY_OPTION.of(category)),
                Scroll.to(BuyMealPage.FOOD_OPTION_QUANTITY.of(meal)),
                ClickJS.onTarget(BuyMealPage.FOOD_OPTION_QUANTITY.of(meal)),
                Click.on(CONTINUE_BUTTON),
                WaitUntil.the(CONTENT_LOADER, isNotVisible())
                        .forNoMoreThan(30)
                        .seconds(),
                Click.on(CONTINUE_BUTTON),
                WaitUntil.the(CONTENT_LOADER, isNotVisible())
                        .forNoMoreThan(30)
                        .seconds()
        );
    }

    public static BuyMeal toChoose(String category, String meal) {
        return Instrumented.instanceOf(BuyMeal.class).withProperties(category, meal);
    }
}
