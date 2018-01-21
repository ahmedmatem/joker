package com.udacity.gradle.builditbigger.backend;

import com.example.android.jokelib.JokeProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    @ApiMethod(name = "getJoke")
    public JokeBean getJoke() {
        String joke = JokeProvider.generateJoke();
        JokeBean response = new JokeBean();
        response.setJoke(joke);

        return response;
    }
}
