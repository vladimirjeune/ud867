package app.com.vladimirjeune.jokewizard;

import com.vladimirjeune.gradle.jokes.JokeSmith;

public class JokeWizard {
    public String getJoke() {
        JokeSmith jokeSmith = new JokeSmith();
        return jokeSmith.getJoke();

    }
}
