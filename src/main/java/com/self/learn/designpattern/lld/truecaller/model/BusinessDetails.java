package com.self.learn.designpattern.lld.truecaller.model;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class BusinessDetails {
    private String businessName;
    private String businessType;
}
