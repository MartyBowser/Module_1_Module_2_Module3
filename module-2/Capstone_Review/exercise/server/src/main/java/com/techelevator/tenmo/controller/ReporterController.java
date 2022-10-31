package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.model.Reporter;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReporterController {



    public ReporterController(ReporterDao dao) {

    }

    public List<Reporter> getReporters() {



    }
}
