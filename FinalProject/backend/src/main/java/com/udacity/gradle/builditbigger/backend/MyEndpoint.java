package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.builditbigger.jokes.JokeTeller;

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
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayJoke")
    public MyBean sayJoke() {
        MyBean response = new MyBean();
        JokeTeller jokeTeller = new JokeTeller();  // Joke from Java Library

        response.setData(jokeTeller.getJoke());

        return response;
    }

//    @Api(name = "myApi", version = "v1")
//    public class MyEndpoint {
//
//        @ApiMethod(name = "helloWorld")
//        public String hello() {
//            return "Hello World!";
//        }
//
//    }

}
