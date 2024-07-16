package co.com.cesar.builders;

import co.com.cesar.models.CreditCard;

public class CreditCardBuilder {

    private CreditCard creditCard = new CreditCard();

    public CreditCardBuilder withNumber(String number) {
        creditCard.setNumber(number);
        return this;
    }

    public CreditCardBuilder withName(String name) {
        creditCard.setName(name);
        return this;
    }

    public CreditCardBuilder withSecurityCode(String securityCode) {
        creditCard.setSecurityCode(securityCode);
        return this;
    }

    public CreditCardBuilder withExpirationDate(String expirationDate) {
        creditCard.setExpirationDate(expirationDate);
        return this;
    }

    public CreditCardBuilder withInstallments(String installments) {
        creditCard.setInstallments(installments);
        return this;
    }

    public CreditCard build() {
        return creditCard;
    }
}
