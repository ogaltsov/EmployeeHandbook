package org.devgroup.handbook.controller;

import org.devgroup.handbook.dto.Response.Response;

public interface HistoryController {

    Response getEmployeeHistory(long id);
}
