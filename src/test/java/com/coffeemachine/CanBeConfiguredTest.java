package com.coffeemachine;

import junit.framework.TestCase;

public class CanBeConfiguredTest extends TestCase {

    public Actionwords actionwords = new Actionwords();

    public void testDisplaySettings() {
        // Given the coffee machine is started
        actionwords.theCoffeeMachineIsStarted();
        // When I switch to settings mode
        actionwords.iSwitchToSettingsMode();
        // Then displayed message is:
        actionwords.displayedMessageIs("Settings:\n - 1: water hardness\n - 2: grinder");
    }

    public void testDefaultSettings() {
        // Given the coffee machine is started
        actionwords.theCoffeeMachineIsStarted();
        // When I switch to settings mode
        actionwords.iSwitchToSettingsMode();
        // Then settings should be: "| water hardness | 2      |
        // | grinder        | medium |"
        actionwords.settingsShouldBe("| water hardness | 2      |\n| grinder        | medium |");
    }
}