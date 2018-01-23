package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest implements EndpointsAsyncTask.JokeHandler {

    @Test
    public void retrieveNonEmptyString() {
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(this);
        asyncTask.execute();
    }

    @Override
    public void onJokeRetrieved(String joke) {
        assertTrue(joke.length() > 0);
    }
}
