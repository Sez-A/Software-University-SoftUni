package entity.problem5;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class BankAccount extends BillingDetailBase{

    private String bankName;
    private String SWIFT;

    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Column(name = "swift")
    public String getSWIFT() {
        return SWIFT;
    }

    public void setSWIFT(String SWIFT) {
        this.SWIFT = SWIFT;
    }

    @Override
    public void setBillingDetail(BillingDetail billingDetail) {
        super.setBillingDetail(BillingDetail.BANK_ACCOUNT);
    }
}
