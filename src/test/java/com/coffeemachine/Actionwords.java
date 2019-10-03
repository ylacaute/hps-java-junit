package com.coffeemachine;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class Actionwords {
    public CoffeeMachine sut = new CoffeeMachine();
    public boolean handleWater = false;
    public boolean handleBeans = false;
    public boolean handleGrounds = false;

    public void iStartTheCoffeeMachineUsingLanguageLang() {
        iStartTheCoffeeMachineUsingLanguageLang("en");
    }

    public void iStartTheCoffeeMachineUsingLanguageLang(String lang) {
        sut.start(lang);
    }

    public void iShutdownTheCoffeeMachine() {
        sut.stop();
    }

    public void messageMessageShouldBeDisplayed(String message) {
        assertEquals(sut.message(), message);
    }

    public void unNouveauStep() {
        System.out.println("Un step qui ne sert a rien");
    }

    public void coffeeShouldBeServedYeahMan() {
        assertTrue(sut.coffeeServed);
    }

    public void coffeeShouldNotBeServed() {
        assertFalse(sut.coffeeServed);
    }

    public void iTakeACoffee() {
        sut.takeCoffee();
    }

    public void iEmptyTheCoffeeGrounds() {
        sut.emptyGrounds();
    }

    public void iFillTheBeansTank() {
        sut.fillBeans();
    }

    public void iFillTheWaterTank() {
        sut.fillTank();
    }

    public void iTakeCoffeeNumberCoffees(int coffeeNumber) {
        while ((coffeeNumber > 0)) {
            iTakeACoffee();
            coffeeNumber = coffeeNumber - 1;

            if (handleWater) {
                iFillTheWaterTank();
            }

            if (handleBeans) {
                iFillTheBeansTank();
            }

            if (handleGrounds) {
                iEmptyTheCoffeeGrounds();
            }
        }
    }

    public void theCoffeeMachineIsStarted() {
        iStartTheCoffeeMachineUsingLanguageLang();
    }

    public void iHandleWaterTank() {
        handleWater = true;
    }

    public void iHandleBeans() {
        handleBeans = true;
    }

    public void iHandleCoffeeGrounds() {
        handleGrounds = true;
    }

    public void iHandleEverythingExceptTheWaterTank() {
        iHandleCoffeeGrounds();
        iHandleBeans();
    }

    public void iHandleEverythingExceptTheBeans() {
        iHandleWaterTank();
        iHandleCoffeeGrounds();
    }

    public void iHandleEverythingExceptTheGrounds() {
        iHandleWaterTank();
        iHandleBeans();
    }

    public void displayedMessageIs(String freeText) {
        messageMessageShouldBeDisplayed(freeText);
    }

    public void iSwitchToSettingsMode() {
        sut.showSettings();
    }

    public void settingsShouldBe(String datatable) {
        Map<String,String> settings = new HashMap<String, String>();
        for (String line : datatable.split("\n")) {
            String[] cells = line.split("\\|");
            settings.put(cells[1].trim(), cells[2].trim());
        }

        assertEquals(sut.getSettings(), settings);
    }
}
