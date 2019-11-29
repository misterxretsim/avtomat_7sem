package com.example.backweb.controller;
import com.example.backweb.jdbc.BackwebJDBCTemplate;
import com.example.backweb.model.Book;
import com.example.backweb.model.ReqBody;
import com.example.backweb.model.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    BackwebJDBCTemplate backwebJDBCTemplate;

    @PostMapping("/api")
    public ResponseEntity<Resp> doSomething(@RequestBody ReqBody reqBody){
        Resp resp = null;
        switch (reqBody.getMethod()){
            case "get":{
                resp = new Resp(reqBody.getMethod(), true, backwebJDBCTemplate.getBooks());
                break;
            }
            case "add":{
                resp = new Resp(reqBody.getMethod(), true, backwebJDBCTemplate.add(reqBody.getPost()));
                break;
            }
            case "delete":{
                resp = new Resp(reqBody.getMethod(), true, backwebJDBCTemplate.delete(reqBody.getPost().getId()));
                break;
            }
            default:{
                break;
            }
        }
        return new ResponseEntity<Resp>(resp, HttpStatus.OK);
    }
}
