package ru.job4j.template;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

public class GeneratorTest {

    String template;

    @Before
    public void initData() {
        template = "I am a ${name}, Who are ${subject}? ";
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenCorrectKeys() {
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        PhraseGenerator phraseGenerator = new PhraseGenerator();
        phraseGenerator.produce(template, args);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenNotEnoughKeys() {
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        PhraseGenerator phraseGenerator = new PhraseGenerator();
        phraseGenerator.produce(template, args);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenExtraKeys() {
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        args.put("answer", "Hi, I am batman)");
        PhraseGenerator phraseGenerator = new PhraseGenerator();
        phraseGenerator.produce(template, args);
    }

}