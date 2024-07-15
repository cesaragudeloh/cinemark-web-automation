package co.com.cesar.data;

import co.com.cesar.models.CreditCard;

public class CreditCardData {

    public CreditCardData(){
        throw new IllegalStateException("not instantiable class");
    }

    public static CreditCard getTCVisa(){
        CreditCard creditCard = new CreditCard();
        creditCard.setNumber("4097440000000004");
        creditCard.setName("APPROVED");
        creditCard.setSecurityCode("777");
        creditCard.setExpirationDate("feb.");
        creditCard.setInstallments("2");
        return creditCard;
    }

}
