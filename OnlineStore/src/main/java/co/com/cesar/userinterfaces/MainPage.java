package co.com.cesar.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class MainPage {

    public static final Target MOVIE_OPTION = Target.the("Movie Option").locatedBy("//div/img[@alt='{0}']/../../../button");
    public static final Target FORWARD_BUTTON = Target.the("Forward Button").locatedBy("//button[contains(@class,'btn--arrow__right')]");
    public static final Target PREMIERES_TITLE = Target.the("Premieres Title").locatedBy("//h1[contains(@class,'title--section')]");
    public static final Target CITY_OPTION = Target.the("City Option").locatedBy("//span[contains(@class,'text--sentence-case') and contains(text(),'ciudad')]");
    public static final Target CITY_VALUE = Target.the("City Value").locatedBy("//h2[contains(@class,'item-select')]");
    public static final Target FIRST_SCHEDULE = Target.the("First Schedule").locatedBy("(//div[contains(@class,'sessions__button--runtime')])[1]");
    public static final Target CONFIRM_BUTTON = Target.the("Confirm Button").locatedBy("//button[@title='CONFIRMAR']");
    public static final Target CONTENT_LOADER = Target.the("Content Loader").locatedBy("//div[contains(@class,'content-loader')]");
    public static final Target CLOSE_TICKET_FOR_FREE_AD = Target.the("Close Modal").locatedBy("//button[@class='ant-modal-close']");
    public static final Target SEAT_FORMAT_OPTION = Target.the("Seat Format Option").locatedBy("//span[text()='{0}']/../../../div/div/div[contains(@class,'select-seat-format')]/div");
    public static final Target SEAT_FORMAT_QUANTITY = Target.the("Seat Format Quantity").locatedBy("(//li[@role='option'])[{0}]");
    public static final Target CONTINUE_BUTTON = Target.the("Continue Button").locatedBy("//button[@title='continuar']");
    public static final Target SEAT_POSITION = Target.the("Seat Position").locatedBy("(//button[contains(@class,'seat-item--available')]/span)[{0}]");
    public static final Target CONFIRM_SEAT_BUTTON = Target.the("Confirm Seat Button").locatedBy("//button[@title='confirmar']");

    public MainPage(){
        throw new IllegalStateException("Utility class");
    }
}
