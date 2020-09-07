package be.g00glen00b.apps;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(
    info = @Info(
        title = "employee-service",
        version = "1.0",
        description = "Employee API",
        contact = @Contact(url = "https://dimitr.im", name = "Dimitri")))
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}
