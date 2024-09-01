package com.self.learn.designpattern.lld.truecaller.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TruecallerRegistry {
    private List<User> globalSpamRegistry = new ArrayList<>();
    private List<User> globalUserRegistry = new ArrayList<>();
}
