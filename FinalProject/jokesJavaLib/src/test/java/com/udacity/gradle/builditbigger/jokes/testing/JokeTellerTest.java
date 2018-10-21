package com.udacity.gradle.builditbigger.jokes.testing;

import com.udacity.gradle.builditbigger.jokes.JokeTeller;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class JokeTellerTest {

    JokeTeller jokeTeller;

    @Before
    public void setUpClickCounter() {
        jokeTeller = new JokeTeller();
    }

    @Test
    public void verifyJokeTellerTellsAJoke() {
	final int zero = 0;
	int length = 0;

	length = jokeTeller.getJoke().length();
	// Make sure that size is not 0
        assertTrue(length > zero);
    }

}
