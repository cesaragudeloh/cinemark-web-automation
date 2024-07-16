package co.com.cesar.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PaymentPage {

    public static final Target CREDIT_CARD_OPTION = Target.the("Credit Card Option").locatedBy("(//i[contains(@class,'anticon-credit-card')]/../../span)[contains(text(),'AGREGAR TARJETA DE CRÉDITO')]");
    public static final Target CREDIT_CARD_NUMBER = Target.the("Credit Card Number").located(By.id("payment_creditCard.number"));
    public static final Target CREDIT_CARD_OWNER_NAME = Target.the("Credit Card Owner Name").located(By.id("payment_creditCard.name"));
    public static final Target CREDIT_CARD_CVV = Target.the("Credit Card CVV").located(By.id("payment_creditCard.securityCode"));
    public static final Target CREDIT_CARD_EXPIRATION_DATE = Target.the("Credit Card Expiration Date").locatedBy("//span[@id='payment_creditCard.expirationDate']/div/input");
    public static final Target CALENDAR_NEXT_YEAR = Target.the("Next Year").locatedBy("//a[@class='ant-calendar-month-panel-next-year-btn']");
    public static final Target CALENDAR_MONTH = Target.the("Set month").locatedBy("//a[@class='ant-calendar-month-panel-month' and text()='{0}']");
    public static final Target CREDIT_CARD_INSTALLMENTS_OPTION = Target.the("Credit Card Installments Option").located(By.id("payment_creditCard.installments"));
    public static final Target CREDIT_CARD_INSTALLMENTS_VALUE = Target.the("Credit Card Installments Value").locatedBy("(//li[@role='option'])[{0}]");
    public static final Target PAYMENT_AGREEMENT = Target.the("Payment Agreement").located(By.id("payment_agreement"));
    public static final Target CONFIRM_PAYMENT_BUTTON = Target.the("Confirm Payment Button").locatedBy("//button[@title='ACEPTAR']");

    public PaymentPage(){
        throw new IllegalStateException("Utility class");
    }

}
