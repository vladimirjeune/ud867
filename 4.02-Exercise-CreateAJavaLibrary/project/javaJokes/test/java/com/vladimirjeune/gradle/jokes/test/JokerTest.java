    package com.vladimirjeune.gradle.jokes.test;

    import com.udacity.gradle.jokes.JokeSmith;
    import org.junit.Test;

    public class JokerTest {
        @Test
        public void test() {
            Joker joker = new JokeSmith();
            assert joker.getJoke().length() != 0;
        }
    }