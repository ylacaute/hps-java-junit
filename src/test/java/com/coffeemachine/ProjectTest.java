package com.coffeemachine;

import junit.framework.TestCase;

public class ProjectTest extends TestCase {

    public Actionwords actionwords = new Actionwords();
    // Well, sometimes, you just get a coffee.
    public void testSimpleUse() {
        // Given the coffee machine is started
        actionwords.theCoffeeMachineIsStarted();
        // When I take a coffee
        actionwords.iTakeACoffee();
        // Then coffee should be served
        actionwords.coffeeShouldBeServed();
    }
    // Simple scenario showing that after 50 coffees, the "Fill tank" message is displayed but it is still possible to have coffee until the tank is fully empty.
    public void testWaterRunsAway() {
        // Given the coffee machine is started
        actionwords.theCoffeeMachineIsStarted();
        // When fifty coffees have been taken without filling the tank
        actionwords.fiftyCoffeesHaveBeenTakenWithoutFillingTheTank();
        // Then message "Fill tank" should be displayed
        actionwords.messageMessageShouldBeDisplayed("Fill tank");
        // When I take a coffee
        actionwords.iTakeACoffee();
        // Then coffee should be served
        actionwords.coffeeShouldBeServed();
        // When I take "10" coffees
        actionwords.iTakeCoffeeNumberCoffees(10);
        // Then coffee should not be served
        actionwords.coffeeShouldNotBeServed();
        // And message "Fill tank" should be displayed
        actionwords.messageMessageShouldBeDisplayed("Fill tank");
        // When I fill the water tank
        actionwords.iFillTheWaterTank();
        // Then message "Ready" should be displayed
        actionwords.messageMessageShouldBeDisplayed("Ready");
    }
    // Simple scenario showing that after 38 coffees, the message "Fill beans" is displayed but it is possible to take two coffees until there is no more beans.
    public void testBeansRunOut() {
        // Given the coffee machine is started
        actionwords.theCoffeeMachineIsStarted();
        // When thirty eight coffees are taken without filling beans
        actionwords.thirtyEightCoffeesAreTakenWithoutFillingBeans();
        // Then coffee should be served
        actionwords.coffeeShouldBeServed();
        // And message "Fill beans" should be displayed
        actionwords.messageMessageShouldBeDisplayed("Fill beans");
        // When I take "2" coffees
        actionwords.iTakeCoffeeNumberCoffees(2);
        // Then coffee should be served
        actionwords.coffeeShouldBeServed();
        // And message "Fill beans" should be displayed
        actionwords.messageMessageShouldBeDisplayed("Fill beans");
        // When I take a coffee
        actionwords.iTakeACoffee();
        // Then coffee should not be served
        actionwords.coffeeShouldNotBeServed();
    }
    // You keep getting coffee even if the "Empty grounds" message is displayed. That said it's not a fantastic idea, you'll get ground everywhere when you'll decide to empty it.
    public void testFullGroundsDoesNotBlockCoffee() {
        // Given the coffee machine is started
        actionwords.theCoffeeMachineIsStarted();
        // When I take "29" coffees
        actionwords.iTakeCoffeeNumberCoffees(29);
        // Then message "Ready" should be displayed
        actionwords.messageMessageShouldBeDisplayed("Ready");
        // When I take a coffee
        actionwords.iTakeACoffee();
        // Then coffee should be served
        actionwords.coffeeShouldBeServed();
        // And message "Empty grounds" should be displayed
        actionwords.messageMessageShouldBeDisplayed("Empty grounds");
        // When I fill the water tank
        actionwords.iFillTheWaterTank();
        // And I fill the beans tank
        actionwords.iFillTheBeansTank();
        // And I take "20" coffees
        actionwords.iTakeCoffeeNumberCoffees(20);
        // Then coffee should be served
        actionwords.coffeeShouldBeServed();
        // And message "Empty grounds" should be displayed
        actionwords.messageMessageShouldBeDisplayed("Empty grounds");
    }
    public void messagesAreBasedOnLanguage(String lang, String readyMessage) {
        // When I start the coffee machine "<lang>"
        actionwords.iStartTheCoffeeMachine(lang);
        // Then message "<ready_message>" should be displayed
        actionwords.messageMessageShouldBeDisplayed(readyMessage);
    }

    public void testMessagesAreBasedOnLanguageEnglish() {
        messagesAreBasedOnLanguage("en", "Ready");
    }

    public void testMessagesAreBasedOnLanguageFrench() {
        messagesAreBasedOnLanguage("fr", "Pret");
    }



    public void testNoMessagesAreDisplayedWhenMachineIsShutDown() {
        // Given the coffee machine is started
        actionwords.theCoffeeMachineIsStarted();
        // When I shutdown the coffee machine
        actionwords.iShutdownTheCoffeeMachine();
        // Then message "" should be displayed
        actionwords.messageMessageShouldBeDisplayed("");
    }
}