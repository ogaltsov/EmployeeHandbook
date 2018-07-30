//package org.devgroup.handbook.controller;
//
//import org.devgroup.handbook.dto.Response.Response;
//import org.devgroup.handbook.exception.MyException;
//import org.devgroup.handbook.service.HistoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HistoryControllerImpl implements HistoryController {
//
//    @Autowired
//    private HistoryService historyService;
//
//    @RequestMapping(value = "/getEmployeeHistory", method = RequestMethod.GET)
//    public Response getEmployeeHistory(@RequestParam(value = "id") long id) {
//        try {
//            String answer = historyService.getEmployeeHistory(id);
//            return Response.builder()
//                    .message(answer)
//                    .build();
//        } catch (MyException e) {
//            return Response.builder()
//                    .message(e.getResponse().getErrorCode() + e.getResponse().getErrorMessage())
//                    .build();
//        }
//
//    }
//}
