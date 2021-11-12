package entity.problem5;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CreditCard extends BillingDetailBase {
    private String type;
    private String expirationMonth;
    private String expirationYear;

    @Column
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "expiration_month")
    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Column(name = "expiration_year")
    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    @Override
    public void setBillingDetail(BillingDetail billingDetail) {
        super.setBillingDetail(BillingDetail.CREDIT_CARD);
    }
}
