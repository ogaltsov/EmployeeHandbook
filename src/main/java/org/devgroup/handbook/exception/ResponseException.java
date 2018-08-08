package org.devgroup.handbook.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@Getter
@AllArgsConstructor
public enum ResponseException {

    INCORRECT_TYPE_OF_INPUT_DATA    (1001, "Введены некоректные данные"),
    EMPLOYEE_NOT_EXIST              (1002, "Такого сотрудника не существует"),
    DEPARTMENT_NOT_EXIST            (1003, "Такого департамента не существует"),
    POSITION_NOT_EXIST              (1004, "Такой должности не существует"),
    FILE_NOT_FOUND                  (1000, "Заглушка");


    private int errorCode;
    private String errorMessage;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class BaseResponse {

        private Integer errorCode;
        private String errorMessage;
    }


    @SneakyThrows
    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        BaseResponse response = BaseResponse.builder()
                .errorCode(errorCode)
                .errorMessage(errorMessage)
                .build();
        return objectMapper.writeValueAsString(response);
    }


}
