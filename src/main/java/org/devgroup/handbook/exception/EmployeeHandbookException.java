package org.devgroup.handbook.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeHandbookException extends RuntimeException {

    private ResponseException response;

}
