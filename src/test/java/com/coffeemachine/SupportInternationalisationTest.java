package com.coffeemachine;

import junit.framework.TestCase;

public class SupportInternationalisationTest extends TestCase {
    // Tags: sprint:3
    public Actionwords actionwords = new Actionwords();
    public void messagesAreBasedOnLanguage(String language, String readyMessage) {
        // Tags: priority:medium
        // When I start the coffee machine using language "<language>"
        actionwords.iStartTheCoffeeMachineUsingLanguageLang(language);
        // Then message "<ready_message>" should be displayed
        actionwords.messageMessageShouldBeDisplayed(readyMessage);
    }

    public void testMessagesAreBasedOnLanguageEnglish() {
        messagesAreBasedOnLanguage("en", "Ready");
    }

    public void testMessagesAreBasedOnLanguageFrench() {
        messagesAreBasedOnLanguage("fr", "Pret");
    }


    //
    // Tags: priority:medium
    public void testNoMessagesAreDisplayedWhenMachineIsShutDown() {
        // Given the coffee machine is started
        actionwords.theCoffeeMachineIsStarted();
        // When I shutdown the coffee machine
        actionwords.iShutdownTheCoffeeMachine();
        // Then message "" should be displayed
        actionwords.messageMessageShouldBeDisplayed("");
    }
}