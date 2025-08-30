package com.esdoor.measure.controller;

import com.esdoor.measure.model.MeasurementForm;
import com.esdoor.measure.service.PdfService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/forms")
public class MeasurementController {

  private final PdfService pdfService;

  public MeasurementController(PdfService pdfService) {
    this.pdfService = pdfService;
  }

  @PostMapping("/{id}/pdf")
  public String create(@PathVariable String id, @RequestBody MeasurementForm form) throws IOException {
    return pdfService.render(id, form);
  }
}