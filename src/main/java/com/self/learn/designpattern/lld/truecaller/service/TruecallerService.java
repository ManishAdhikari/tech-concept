package com.self.learn.designpattern.lld.truecaller.service;

import com.self.learn.designpattern.lld.truecaller.model.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TruecallerService {
    private final TruecallerRegistry truecallerRegistry;

    public Account register(String name, String mobNum, String password) {
        var user = User.builder().name(name).password(password.toCharArray()).mobNum(mobNum).build();
        user.getUserRegistry().getGlobalUserRegistry().add(user);
        return Account.builder().user(user).build();
    }


}
