package com.esdoor.measure.model;

public class MeasurementForm {
  private String customerName;
  private String doorType;        // e.g. MDF, Membrane, Lacquer
  private double widthMm;         // mm
  private double heightMm;        // mm
  private String notes;

  public String getCustomerName() { return customerName; }
  public void setCustomerName(String customerName) { this.customerName = customerName; }
  public String getDoorType() { return doorType; }
  public void setDoorType(String doorType) { this.doorType = doorType; }
  public double getWidthMm() { return widthMm; }
  public void setWidthMm(double widthMm) { this.widthMm = widthMm; }
  public double getHeightMm() { return heightMm; }
  public void setHeightMm(double heightMm) { this.heightMm = heightMm; }
  public String getNotes() { return notes; }
  public void setNotes(String notes) { this.notes = notes; }
}