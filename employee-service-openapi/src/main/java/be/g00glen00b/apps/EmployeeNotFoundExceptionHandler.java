package be.g00glen00b.apps;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

@Singleton
@Requires(classes = EmployeeNotFoundException.class)
public class EmployeeNotFoundExceptionHandler implements ExceptionHandler<EmployeeNotFoundException, HttpResponse<ErrorMessage>> {

    @Override
    public HttpResponse<ErrorMessage> handle(HttpRequest request, EmployeeNotFoundException exception) {
        return HttpResponse.notFound(new ErrorMessage(exception.getMessage(), "NOT_FOUND"));
    }
}
