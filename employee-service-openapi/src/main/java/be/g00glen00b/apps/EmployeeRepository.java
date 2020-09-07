package be.g00glen00b.apps;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

import java.util.Optional;

@Repository
public interface EmployeeRepository {
    Page<Employee> findAll(Pageable pageable);
    Optional<Employee> findById(long id);
}
