# Esdoor – Measurement Form PDF

Spring Boot service that converts measurement form data into a clean, printable PDF (TR fonts supported).

## Endpoint
- `POST /forms/{id}/pdf` → renders a PDF file on the server

## Sample Payload
```json
{
  "customerName": "Acme Ltd.",
  "doorType": "Membrane",
  "widthMm": 920,
  "heightMm": 2050,
  "notes": "Hinge left, matte finish."
}
