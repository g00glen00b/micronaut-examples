package be.g00glen00b.apps;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@Controller("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeRepository repository;

    @Get
    @Operation(parameters = {
        @Parameter(
            name = "page",
            schema = @Schema(type = "integer", minimum = "0"),
            in = ParameterIn.QUERY,
            description = "Zero based page number of the employees you want to retrieve"),
        @Parameter(
            name = "size",
            schema = @Schema(type = "integer", minimum = "1"),
            in = ParameterIn.QUERY,
            description = "The amount of employees you want to retrieve"),
        @Parameter(
            name = "sort",
            schema = @Schema(type = "string", allowableValues = {"id", "name", "title", "startdate"}),
            in = ParameterIn.QUERY,
            description = "The field by which can be sorted"),
    }, responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Successful request",
            content = @Content(schema = @Schema(implementation = EmployeePage.class)))
    })
    public Page<Employee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Get("/{id}")
    @Operation(responses = {
        @ApiResponse(
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = Employee.class)),
            description = "Succesful request"),
        @ApiResponse(
            responseCode = "404",
            content = @Content(schema = @Schema(implementation = ErrorMessage.class)),
            description = "Employee with the given ID does not exist")
    })
    public Employee findById(@PathVariable long id) {
        return repository
            .findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}
