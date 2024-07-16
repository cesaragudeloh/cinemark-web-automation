package co.com.cesar.stepdefinitions;

import co.com.cesar.data.CreditCardData;
import co.com.cesar.questions.GetText;
import co.com.cesar.questions.IsVisible;
import co.com.cesar.tasks.BuyMeal;
import co.com.cesar.tasks.ChooseMovie;
import co.com.cesar.tasks.DoPayment;
import co.com.cesar.tasks.Login;
import co.com.cesar.utils.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static co.com.cesar.utils.Constants.ACTOR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import static co.com.cesar.userinterfaces.PurchaseSuccessfulPage.*;

public class BuyTicketStep {

    @Managed
    WebDriver webDriver;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        Open.browserOn();
        ACTOR.whoCan(
                BrowseTheWeb.with(webDriver)
        );
        ACTOR.attemptsTo(
                Open.url(Constants.URL_PAGE)
        );
    }

    @Given("the user enters at the web site")
    public void theUserEntersAtTheWebSite() {
        ACTOR.attemptsTo(
                Login.onThePage()
        );
    }

    @When("the user purchases a movie ticket")
    public void theUserPurchasesAMovieTicket() {
        ACTOR.attemptsTo(
                ChooseMovie.using("Wifi Ralph", "SÚPER PROMO BISTRO 2DXD", 1),
                BuyMeal.toChoose("Combos", "COMBO TU Y YO WEB IP"),
                DoPayment.with(CreditCardData.getTCVisa())
        );
    }

    @Then("the purchase is successful and the QR code is displayed")
    public void thePurchaseIsSuccessfulAndTheQRCodeIsDisplayed() throws InterruptedException {
        ACTOR.should(
                seeThat("the QR code is displayed", IsVisible.theTarget(QR_CODE), equalTo(true)),
                seeThat("the purchase is successful", GetText.fromTarget(TRANSACTION_CODE), is(notNullValue()))
        );
    }

}
