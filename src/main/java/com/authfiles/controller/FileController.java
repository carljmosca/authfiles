/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.authfiles.controller;

import java.security.Principal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author moscac
 */
@RestController
public class FileController {

    @RequestMapping(method = GET, path = "/file/{organization}/{filename}")
    public ResponseEntity<byte[]> getFile(@PathVariable String organization,
            @PathVariable String filename, Principal principal) {

        byte[] bytes = null;
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/octet-stream");
        headers.add("Content-Disposition", "attachment; filename=\"" + filename + "\"");
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

}
