package co.com.cesar.tasks;

import co.com.cesar.interaction.ClickJS;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.cesar.userinterfaces.MainPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;


public class ChooseMovie implements Task {

    private String movieName;
    private String seatFormat;
    private int quantity;

    public ChooseMovie(String movieName, String seatFormat, int quantity) {
        this.movieName = movieName;
        this.seatFormat = seatFormat;
        this.quantity = quantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CITY_OPTION),
                Click.on(CITY_VALUE)
        );

        boolean movieFound = false;
        while (!movieFound) {
            if (MOVIE_OPTION.of(movieName).resolveFor(actor).isClickable()) {
                movieFound = true;
                actor.attemptsTo(
                        Scroll.to(PREMIERES_TITLE),
                        ClickJS.onTarget(MOVIE_OPTION.of(movieName)),
                        WaitUntil.the(CONTENT_LOADER, isNotVisible())
                                .forNoMoreThan(30)
                                .seconds(),
                        Scroll.to(FIRST_SCHEDULE),
                        Click.on(FIRST_SCHEDULE),
                        Click.on(CONFIRM_BUTTON)
                );
            } else {
                actor.attemptsTo(
                        Scroll.to(PREMIERES_TITLE),
                        ClickJS.onTarget(FORWARD_BUTTON)
                );
            }
        }
        actor.attemptsTo(
                WaitUntil.the(CONTENT_LOADER, isNotVisible())
                        .forNoMoreThan(30)
                        .seconds(),
                ClickJS.onTarget(CLOSE_TICKET_FOR_FREE_AD),
                ClickJS.onTarget(SEAT_FORMAT_OPTION.of(seatFormat)),
                ClickJS.onTarget(SEAT_FORMAT_QUANTITY.of(String.valueOf(quantity + 1))),
                Click.on(CONTINUE_BUTTON),
                Scroll.to(SEAT_POSITION.of("1")),
                ClickJS.onTarget(SEAT_POSITION.of("1")),
                Click.on(CONTINUE_BUTTON),
                Click.on(CONFIRM_SEAT_BUTTON),
                WaitUntil.the(CONTENT_LOADER, isNotVisible())
                        .forNoMoreThan(30)
                        .seconds()
        );

    }

    public static ChooseMovie using(String movieName, String seatFormat, int quantity) {
        return Instrumented.instanceOf(ChooseMovie.class).withProperties(movieName, seatFormat, quantity);
    }

}
