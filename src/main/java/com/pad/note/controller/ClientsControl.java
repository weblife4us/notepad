package com.pad.note.controller;

import ch.qos.logback.core.net.server.Client;
import com.pad.note.ApiResponse;
import com.pad.note.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientsControl {

    @Autowired
    private ClientService clientService_;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity getHelloWorldMessage() {
        return ResponseEntity.ok(new ApiResponse(true, "Test passed successfully"));
    }
}
