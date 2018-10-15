package com.example.android.clickcounter.test;

import com.example.android.clickcounter.ClickCounter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ClickCountTest {

    ClickCounter clickCounter;

    @Before
    public void setUpClickCounter() {
        clickCounter = new ClickCounter();
    }

    @Test
    public void verifyClickCounterInitialCount() {

        int expectedValue = 0;
        int receivedValue = clickCounter.getCount();
        assertEquals(receivedValue, expectedValue);
    }

    @Test
    public void verifyClickCounterIncrement() {
        clickCounter.increment();

        int receivedValue = clickCounter.getCount();
        int expectedValue = 1;
        assertEquals(receivedValue, expectedValue);
    }

}