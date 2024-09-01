package com.self.learn.designpattern.lld.truecaller.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import java.util.List;

@Data
@ToString(exclude = {"password", "userRegistry"})
@Builder
public class User {
    private final String name;
    private final String mobNum;
    private char[] password;
    @Builder.Default
    private UserRegistry userRegistry = new UserRegistry();

    public User addContact(String name, String mobNum) {
        var user = User.builder().name(name).mobNum(mobNum).build();
        userRegistry.getSavedContacts().add(user);
        userRegistry.getGlobalUserRegistry().add(user);
        return user;
    }

    public void importContacts( List<String> commaSeparatedContacts) {
        commaSeparatedContacts.forEach(contact -> {
            var contactInfo = contact.split(",");
            var user = User.builder().name(contactInfo[0]).mobNum(contactInfo[1]).build();
            userRegistry.getSavedContacts().add(user);
            userRegistry.getGlobalUserRegistry().add(user);
        });
    }

    public User blockContact(User user) {
        userRegistry.getBlockedContacts().add(user);
        return user;
    }

    public User unblockContact(User user) {
        userRegistry.getBlockedContacts().remove(user);
        return user;
    }

    public User reportSpam(User user) {
        userRegistry.getSpamContacts().add(user);
        userRegistry.getGlobalSpamRegistry().add(user);
        userRegistry.getBlockedContacts().add(user);
        return user;
    }

    public void searchUser(String searchKey) {
        var searchByName = searchKey.chars().mapToObj(i -> (char)i).allMatch(Character::isAlphabetic);
        var searchByMobNum = searchKey.chars().mapToObj(i -> (char)i).allMatch(Character::isDigit);
        List<User> users = List.of();
        if (searchByName) {
            users = userRegistry.getSavedContacts()
                    .stream().filter(user -> user.getName().startsWith(searchKey)).toList();
        } else if (searchByMobNum) {
            users = userRegistry.getSavedContacts()
                    .stream().filter(user -> user.getMobNum().startsWith(searchKey)).toList();
        }
        System.out.println(users);
    }

    public void searchUserGlobally(String searchKey) {
        var searchByName = searchKey.chars().mapToObj(i -> (char)i).allMatch(Character::isAlphabetic);
        var searchByMobNum = searchKey.chars().mapToObj(i -> (char)i).allMatch(Character::isDigit);
        List<User> users = List.of();
        if (searchByName) {
            users = userRegistry.getGlobalUserRegistry()
                    .stream().filter(user -> user.getName().startsWith(searchKey)).toList();
        } else if (searchByMobNum) {
            users = userRegistry.getGlobalUserRegistry()
                    .stream().filter(user -> user.getMobNum().startsWith(searchKey)).toList();
        }
        System.out.println(users);
    }

    public void receiveCall(User user) {
        var savedContact = userRegistry.getSavedContacts().stream().filter(u -> u.equals(user)).findAny();
        savedContact.ifPresentOrElse(contact -> {
            if (userRegistry.getBlockedContacts().contains(contact)) {
                System.out.println("Blocked contact: " + user.getName() + " calling");
            } else if (userRegistry.getSpamContacts().contains(contact)) {
                System.out.println("Spam contact: " + user.getName() + " : " + user.getMobNum() + " calling");
            } else {
                System.out.println(user.getName() + " calling");
            }
        }, () -> {
            if(userRegistry.getGlobalSpamRegistry().contains(user)) {
                System.out.println("Spam number: " + user.getName() + " : " + user.getMobNum() + " calling");
            } else {
                System.out.println("Unknown number: " + user.getMobNum() + " calling");
            }
        });
    }
}
