package entity.problem5;

import entity.BaseEntity;

import javax.persistence.*;

@MappedSuperclass
public class BillingDetailBase extends BaseEntity {
    private String number;
    private User owner;
private BillingDetail billingDetail;
    @Column(unique = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ManyToOne
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Enumerated(value = EnumType.STRING)
    public BillingDetail getBillingDetail() {
        return billingDetail;
    }

    public void setBillingDetail(BillingDetail billingDetail) {
        this.billingDetail = billingDetail;
    }
}
