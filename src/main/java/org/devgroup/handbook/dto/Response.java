package org.devgroup.handbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response<T> {
    private String message;
    private List<T> list;

    public void addToList(T object){
        if(list==null){
            list = new ArrayList<T>();
        }
        list.add(object);
    }

    //todo: fix problems with builder()
    public Response(String message) {
        this.message = message;
    }

    //todo: fix problems with builder()
    public Response(List<T> list) {
        this.list = list;
    }

    //todo: fix problems with builder()
    public Response(String message, List<T> list) {
        this.message = message;
        this.list = list;
    }
}
