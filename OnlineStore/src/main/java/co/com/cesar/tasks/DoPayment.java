package co.com.cesar.tasks;

import co.com.cesar.interaction.ClickJS;
import co.com.cesar.models.CreditCard;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.cesar.userinterfaces.MainPage.CONTENT_LOADER;
import static co.com.cesar.userinterfaces.MainPage.CONTINUE_BUTTON;
import static co.com.cesar.userinterfaces.PaymentPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DoPayment implements Task {

    private CreditCard creditCard;

    public DoPayment(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickJS.onTarget(CREDIT_CARD_OPTION),
                Enter.theValue(creditCard.getNumber()).into(CREDIT_CARD_NUMBER),
                Enter.theValue(creditCard.getName()).into(CREDIT_CARD_OWNER_NAME),
                ClickJS.onTarget(CREDIT_CARD_EXPIRATION_DATE),
                ClickJS.onTarget(CALENDAR_NEXT_YEAR),
                ClickJS.onTarget(CALENDAR_MONTH.of(creditCard.getExpirationDate())),
                Enter.theValue(creditCard.getSecurityCode()).into(CREDIT_CARD_CVV),
                ClickJS.onTarget(CREDIT_CARD_INSTALLMENTS_OPTION),
                ClickJS.onTarget(CREDIT_CARD_INSTALLMENTS_VALUE.of(creditCard.getInstallments())),
                ClickJS.onTarget(PAYMENT_AGREEMENT),
                ClickJS.onTarget(CONTINUE_BUTTON),
                ClickJS.onTarget(CONFIRM_PAYMENT_BUTTON),
                WaitUntil.the(CONTENT_LOADER, isNotVisible())
                        .forNoMoreThan(120)
                        .seconds()
        );
    }

    public static DoPayment with(CreditCard creditCard) {
        return Instrumented.instanceOf(DoPayment.class).withProperties(creditCard);
    }
}
