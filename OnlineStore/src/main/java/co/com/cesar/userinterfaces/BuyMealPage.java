package co.com.cesar.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BuyMealPage {

    public static final Target FOOD_CATEGORY_OPTION = Target.the("Food Option").locatedBy("//li/a/span[contains(text(),'{0}')]");
    public static final Target FOOD_OPTION_QUANTITY = Target.the("Food Category Option").locatedBy("//h4[contains(text(),'{0}')]/../../../div/div/div/div/button[contains(@class,'candy-store__btn-control--left-space')]");


    public BuyMealPage(){
        throw new IllegalStateException("Utility class");
    }

}
