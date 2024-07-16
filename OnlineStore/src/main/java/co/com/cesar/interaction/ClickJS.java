package co.com.cesar.interaction;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickJS implements Interaction {

    private Target target;

    public ClickJS(Target target) {
        this.target = target;
    }


    @Override
    @Step("{0} da clic en el elemento")
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getDriver();
        WebElement webElement = target.resolveFor(actor).getElement();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", webElement);
    }

    public static ClickJS onTarget(Target target) {
        return Instrumented.instanceOf(ClickJS.class).withProperties(target);
    }
}
