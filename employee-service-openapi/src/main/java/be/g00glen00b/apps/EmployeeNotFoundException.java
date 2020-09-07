package be.g00glen00b.apps;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeNotFoundException extends RuntimeException {
    private final long employeeId;

    @Override
    public String getMessage() {
        return "Employee with ID '" + employeeId + "' was not found";
    }
}
