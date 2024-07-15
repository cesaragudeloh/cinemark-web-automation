package co.com.cesar.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PurchaseSuccessfulPage {

    public static final Target QR_CODE = Target.the("QR Code").locatedBy("//div[contains(@class,'qr')]");
    public static final Target TRANSACTION_CODE= Target.the("Transaction Code").locatedBy("(//div[contains(@class,'information-order')]/div[contains(@class,'container-description')]/div)[4]");

    public PurchaseSuccessfulPage(){
        throw new IllegalStateException("Utility class");
    }

}
