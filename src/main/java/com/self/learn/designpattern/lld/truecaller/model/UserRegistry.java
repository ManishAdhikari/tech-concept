package com.self.learn.designpattern.lld.truecaller.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserRegistry extends TruecallerRegistry {
    private List<User> savedContacts = new ArrayList<>();
    private List<User> blockedContacts = new ArrayList<>();
    private List<User> spamContacts = new ArrayList<>();
}
