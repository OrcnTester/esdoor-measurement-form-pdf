package com.esdoor.measure.service;

import com.esdoor.measure.model.MeasurementForm;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.*;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;

@Service
public class PdfService {

  public String render(String id, MeasurementForm form) throws IOException {
    String file = "measurement-" + id + ".pdf";
    try (PDDocument doc = new PDDocument()) {
      PDPage page = new PDPage(PDRectangle.A4);
      doc.addPage(page);

      PDFont font = loadFont(doc);
      try (PDPageContentStream c = new PDPageContentStream(doc, page)) {
        // Header
        c.setFont(font, 16);
        c.beginText();
        c.newLineAtOffset(50, 800);
        c.showText("ESDOOR - Measurement Form");
        c.endText();

        c.setFont(font, 10);
        c.beginText();
        c.newLineAtOffset(50, 780);
        c.showText("Date: " + LocalDate.now());
        c.endText();

        // Body
        float y = 740;
        y = row(c, font, 12, 50, y, "Customer", form.getCustomerName());
        y = row(c, font, 12, 50, y, "Door Type", form.getDoorType());
        y = row(c, font, 12, 50, y, "Width (mm)", String.valueOf(form.getWidthMm()));
        y = row(c, font, 12, 50, y, "Height (mm)", String.valueOf(form.getHeightMm()));
        y = row(c, font, 12, 50, y, "Notes", form.getNotes() == null ? "" : form.getNotes());

        // Footer
        c.setFont(font, 9);
        c.beginText();
        c.newLineAtOffset(50, 60);
        c.showText("ESDOOR • IBAN: TR.. • esdoor.example");
        c.endText();
      }
      doc.save(file);
    }
    return file;
  }

  private float row(PDPageContentStream c, PDFont font, int size, float x, float y, String label, String value) throws IOException {
    c.setFont(font, size);
    c.beginText();
    c.newLineAtOffset(x, y);
    c.showText(label + ": " + (value == null ? "" : value));
    c.endText();
    return y - 22;
  }

  private PDFont loadFont(PDDocument doc) throws IOException {
    var in = getClass().getResourceAsStream("/fonts/DejaVuSans.ttf");
    if (in != null) return PDType0Font.load(doc, in);
    return PDType1Font.HELVETICA; // fallback (TR karakterlerini tam göstermez)
  }
}