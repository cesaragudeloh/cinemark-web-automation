package co.com.cesar.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target MODAL_WINDOW = Target.the("Modal window").locatedBy("//span[@class='ant-modal-close-x']");
    public static final Target LOGIN_OPTION = Target.the("Login Option").locatedBy("//*[@id='__next']/div[2]/header/div[2]/div[2]/div[1]/span[2]/div/button");
    public static final Target USERNAME_INPUT = Target.the("Username input").located(By.id("MemberEmail"));
    public static final Target PASSWORD_INPUT = Target.the("Password input").located(By.id("MemberPassword"));
    public static final Target LOGIN_BUTTON = Target.the("Login Button").locatedBy("//button[@title='Ingresar']");

    public LoginPage(){
        throw new IllegalStateException("Utility class");
    }
}
