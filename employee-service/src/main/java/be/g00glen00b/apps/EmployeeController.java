package be.g00glen00b.apps;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import lombok.RequiredArgsConstructor;

@Controller("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeRepository repository;

    @Get
    public Page<Employee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Get("/{id}")
    public Employee findById(@PathVariable long id) {
        return repository
            .findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}
