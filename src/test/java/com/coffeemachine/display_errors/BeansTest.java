package com.coffeemachine.display_errors;

import junit.framework.TestCase;
import com.coffeemachine.Actionwords;

public class BeansTest extends TestCase {

    public Actionwords actionwords = new Actionwords();
    protected void setUp() throws Exception {
        super.setUp();

        // Given the coffee machine is started
        actionwords.theCoffeeMachineIsStarted();
        // And I handle everything except the beans
        actionwords.iHandleEverythingExceptTheBeans();
    }

    //
    // Tags: priority:high
    public void testMessageFillBeansIsDisplayedAfter38CoffeesAreTaken() {
        // When I take "38" coffees
        actionwords.iTakeCoffeeNumberCoffees(38);
        // Then message "Fill beans" should be displayed
        actionwords.messageMessageShouldBeDisplayed("Fill beans");
    }
    //
    // Tags: priority:low
    public void testItIsPossibleToTake40CoffeesBeforeThereIsReallyNoMoreBeans() {
        // When I take "40" coffees
        actionwords.iTakeCoffeeNumberCoffees(40);
        // Then coffee should be served (yeah man)
        actionwords.coffeeShouldBeServedYeahMan();
        // When I take a coffee
        actionwords.iTakeACoffee();
        // Then coffee should not be served
        actionwords.coffeeShouldNotBeServed();
        // And message "Fill beans" should be displayed
        actionwords.messageMessageShouldBeDisplayed("Fill beans");
    }
    //
    // Tags: priority:high
    public void testAfterAddingBeansTheMessageFillBeansDisappears() {
        // When I take "40" coffees
        actionwords.iTakeCoffeeNumberCoffees(40);
        // And I fill the beans tank
        actionwords.iFillTheBeansTank();
        // Then message "Ready" should be displayed
        actionwords.messageMessageShouldBeDisplayed("Ready");
    }
}