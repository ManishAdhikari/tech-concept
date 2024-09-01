package com.self.learn.designpattern.lld.truecaller.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Account {
    private User user;
    @Builder.Default
    private PlanType planType = PlanType.FREE;
    private BusinessDetails businessDetails;
    public void purchasePremiumPlan(PlanType planType) {
        this.setPlanType(planType);
    }
    public void addBusinessAccountDetails(BusinessDetails businessDetails) {
        this.businessDetails = businessDetails;
    }
}
