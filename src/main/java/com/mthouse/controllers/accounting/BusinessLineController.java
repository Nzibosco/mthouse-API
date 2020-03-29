package com.mthouse.controllers.accounting;


import com.mthouse.services.accounting.BusinessLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/line")
public class BusinessLineController {

    @Autowired
    private BusinessLineService businessLineService;
}
