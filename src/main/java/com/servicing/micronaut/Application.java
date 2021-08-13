package com.servicing.micronaut;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(
    info = @Info(
            title = "micronautdemo_poc",
            version = "0.0",
            description = "micronautdemo_poc API",
            contact = @Contact(url = "https:finastra.com", name = "Billing Services", email = "testdemo@gmail.com"),
            license = @License(name = "Apache 2.0", url = "localhost:8081/")
    )
)


public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
