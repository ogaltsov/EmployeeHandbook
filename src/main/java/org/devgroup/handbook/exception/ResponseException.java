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
    INTERRUPTEDEXCEPTION(1005, "<Блокирование потока исполнения!"),
    NUMBER_FORMAT_EXCEPTION(1005, "Неверно указаны данные в исходном файле!");

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
