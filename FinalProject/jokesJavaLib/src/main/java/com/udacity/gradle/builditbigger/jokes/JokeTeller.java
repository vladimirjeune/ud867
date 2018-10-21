package com.udacity.gradle.builditbigger.jokes;

import java.util.Random;

public class JokeTeller {

        private String[] jokes = {
                "A lot of people cry when they cut onions. The trick is not to form an emotional bond.",
                "'Um.'\n\n  —First horse that got ridden",
                "Moses had the first tablet that could connect to the cloud.",
                "Never criticize someone until you've walked a mile in their shoes.\nThat way, when you criticize them, they won't be able to hear you from that far away.\nPlus, you'll have their shoes.",
                "Did you hear about the semi-colon that broke the law?\n\nHe was given two consecutive sentences.",
                "I refused to believe my road worker father was stealing from his job, but when I got home all the signs were there.",
                "Q. What's the difference between ignorance and apathy?\n\nA. I don’t know and I don’t care.",
                "This is totally a funny joke",
                };

        public String getJoke(){
            Random random = new Random();
            int currentJokeIndex = random.nextInt(jokes.length);

            return jokes[currentJokeIndex];
        }
    }