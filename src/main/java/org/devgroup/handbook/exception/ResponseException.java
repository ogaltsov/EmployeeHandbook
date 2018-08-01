package org.devgroup.handbook.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@Getter
@AllArgsConstructor
public enum ResponseException {

    FILE_NOT_FOUND(1001, "Файл отсутствует!"),
    INVALID_INPUT_DATA(1002, "Входыне данные некорректны!"),
    RESULT_FILE_NOT_FOUND(1003, "Результирующий файл не найден!"),
    UNSUPPORTED_ENCODING_EXCEPTION(1004, "Ошибка кодирования результирующего файла!"),
    INTERRUPTEDEXCEPTION(1005, "Блокирование потока исполнения!"),
    NUMBER_FORMAT_EXCEPTION(1006, "Неверно указаны данные в исходном файле!"),
    EMPLOYEE_NOT_EXIST(1007, "Такого сотрудника не существует"),
    DEPARTMENT_NOT_EXIST(1008, "Такого департамента не существует"),
    POSITION_NOT_EXIST(1009, "Такой должности не существует");


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
