package com.example.android.jokelib;

import java.util.Random;

public class JokeProvider {
    private static final String ALPHABET_UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHABET_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static int ALPHABET_LENGTH = ALPHABET_LOWERCASE.length();

    private static final String SENTENCE_END_MARKS = ".?!";

    // number of sentences
    private static int MIN_NUMBER_OF_SENTENCE = 3;
    private static int MAX_NUMBER_OF_SENTENCE = 10;

    // number of words in a sentence
    private static int MIN_WORDS_IN_SENTENCE = 4;
    private static int MAX_WORDS_IN_SENTENCE = 15;

    // number of letters in a word
    private static int MIN_LETTERS_IN_WORD = 1;
    private static int MAX_LETTERS_IN_WORD = 10;

    private static Random mRandom;

    public static String generateJoke() {
        mRandom = new Random();
        int numberOfSentences = getNumberOfSentences();
        int numberOfWords;
        int numberOfLetters;
        char letter;

        StringBuilder joke = new StringBuilder();

        for (int s = 0; s < numberOfSentences; s++) {
            numberOfWords = getNumberOfWordsInSentence();
            for (int w = 0; w < numberOfWords; w++) {
                numberOfLetters = getNumberOfLettersInWord();
                for (int l = 0; l < numberOfLetters; l++) {
                    if (w == 0 && l == 0) { // first word in sentence
                        letter = ALPHABET_UPPERCASE
                                .charAt(mRandom.nextInt(ALPHABET_LENGTH));
                    } else {
                        letter = ALPHABET_LOWERCASE
                                .charAt(mRandom.nextInt(ALPHABET_LENGTH));
                    }

                    joke.append(letter);
                }
                if (w == (numberOfWords - 1)) {
                    // last word in sentence
                    // append sentence end mark
                    joke.append(SENTENCE_END_MARKS
                            .charAt(mRandom
                                    .nextInt(SENTENCE_END_MARKS.length())));
                }
                // append interval after each word
                joke.append(" ");
            }
            if (s < (numberOfSentences - 1)) {
                // not last sentence
                // append interval after sentence
                joke.append(' ');
            }
        }

        return joke.toString();
    }

    private static int getNumberOfSentences() {
        return MIN_NUMBER_OF_SENTENCE + mRandom.nextInt(
                MAX_NUMBER_OF_SENTENCE - MIN_NUMBER_OF_SENTENCE);
    }

    private static int getNumberOfWordsInSentence() {
        return MIN_WORDS_IN_SENTENCE + mRandom.nextInt(
                MAX_WORDS_IN_SENTENCE - MIN_WORDS_IN_SENTENCE);
    }

    private static int getNumberOfLettersInWord() {
        return MIN_LETTERS_IN_WORD + mRandom.nextInt(
                MAX_LETTERS_IN_WORD - MIN_LETTERS_IN_WORD);
    }
}
