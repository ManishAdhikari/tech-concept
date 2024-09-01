package com.self.learn.designpattern.lld.truecaller;

import com.github.javafaker.Faker;
import com.self.learn.designpattern.lld.truecaller.model.Account;
import com.self.learn.designpattern.lld.truecaller.model.BusinessDetails;
import com.self.learn.designpattern.lld.truecaller.model.TruecallerRegistry;
import com.self.learn.designpattern.lld.truecaller.model.User;
import com.self.learn.designpattern.lld.truecaller.service.TruecallerService;

import java.util.stream.IntStream;

public class TruecallerMain {
    public static void main ( String[] args ) {
        var faker = new Faker();
        var truecallerRegistry = new TruecallerRegistry();
        var truecallerService = new TruecallerService(truecallerRegistry);
        //var user = User.builder().name("Tony Stark").mobNum("+44123456789").password("ironman1").build();
        //var account = Account.builder().user(user).planType(PlanType.GOLD).build();
        //Create user and register
        Account account = truecallerService.register(faker.name().fullName(), faker.phoneNumber().cellPhone(), faker.superhero().name());
        System.out.println("**** Registered account ****");
        System.out.println(account.getUser());
        System.out.println("================================================");
        //Add contacts to user
        IntStream.range(0,5).forEach(j ->
            account.getUser().addContact(faker.name().fullName(), faker.phoneNumber().cellPhone()));
        System.out.println("**** Added contacts ****");
        //check added contacts
        account.getUser().getUserRegistry().getSavedContacts().forEach(System.out::println);
        System.out.println("================================================");
        //search for contacts by name
        System.out.println("**** Search for contacts by name ****");
        account.getUser().searchUser("A");
        account.getUser().searchUser("M");
        System.out.println("================================================");
        //search for contacts by phone
        System.out.println("**** Search for contacts by number ****");
        account.getUser().searchUser("3");
        account.getUser().searchUser("1");
        System.out.println("================================================");
        //Block a number
        System.out.println("**** Block a number ****");
        account.getUser().blockContact(account.getUser().getUserRegistry().getSavedContacts().get(0));
        account.getUser().blockContact(account.getUser().getUserRegistry().getSavedContacts().get(1));
        System.out.println("---- Blocked contacts ----");
        System.out.println(account.getUser().getUserRegistry().getBlockedContacts());
        System.out.println("================================================");
        //should not receive call from blocked caller
        System.out.println("**** Should not receive call from blocked caller ****");
        account.getUser().receiveCall(account.getUser().getUserRegistry().getSavedContacts().get(1));
        System.out.println("================================================");
        //Unblock number
        System.out.println("**** Unblock number ****");
        account.getUser().unblockContact(account.getUser().getUserRegistry().getSavedContacts().get(1));
        System.out.println("---- Blocked contacts ----");
        System.out.println(account.getUser().getUserRegistry().getBlockedContacts());
        System.out.println("================================================");
        //should receive call from unblocked caller
        System.out.println("**** Should receive call from unblocked caller ****");
        account.getUser().receiveCall(account.getUser().getUserRegistry().getSavedContacts().get(1));
        System.out.println("================================================");
        //Should be able to report spam to global
        System.out.println("**** Should be able to report spam to global ****");
        var globalSpamUser = User.builder().mobNum("+112233445566778899").build();
        account.getUser().reportSpam(globalSpamUser);
        System.out.println("---- Global spam users ----");
        System.out.println(account.getUser().getUserRegistry().getGlobalSpamRegistry());
        System.out.println("================================================");
        //Should be able to block global spammers
        System.out.println("**** Should be able to block global spammers ****");
        System.out.println("---- Blocked contacts ----");
        System.out.println(account.getUser().getUserRegistry().getBlockedContacts());
        account.getUser().receiveCall(globalSpamUser);
        System.out.println("================================================");
        //adding business to contact
        System.out.println("**** Adding business to contact ****");
        account.addBusinessAccountDetails(BusinessDetails.builder().businessName(faker.company().name()).businessType(faker.university().name()).build());
        System.out.println(account);
        System.out.println("================================================");
        //getting contacts from global
        System.out.println("**** Getting contacts from global ****");
        account.getUser().searchUserGlobally("7");
        account.getUser().searchUserGlobally("S");
    }
}
