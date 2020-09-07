package be.g00glen00b.apps;

import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Sort;
import lombok.Value;

import java.util.List;

@Value
public class EmployeePage {
    int totalPages;
    long totalSize;
    int numberOfElements;
    long offset;
    Pageable pageable;
    int pagenumber;
    int size;
    Sort sort;
    boolean empty;
    List<Employee> content;
}
