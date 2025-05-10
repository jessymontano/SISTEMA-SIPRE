package com.mycompany.sipre.controlador;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneradorPDF {
    public static void mostrarPDFEnNavegador(int folio, String tipoDocumento, Date fechaSolicitud, String motivo) {
        try {
            // 1. Crear PDF en memoria
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // 2. Agregar contenido
            agregarContenidoPDF(document, folio, tipoDocumento, fechaSolicitud, motivo);
            document.close();

            // 3. Crear archivo temporal
            File tempFile = File.createTempFile("solicitud_" + folio + "_", ".pdf");
            tempFile.deleteOnExit();

            // 4. Escribir PDF en archivo temporal
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(baos.toByteArray());
            }

            // 5. Abrir en navegador
            Desktop.getDesktop().browse(tempFile.toURI());

        } catch (IOException e) {
            System.err.println("Error al generar/abrir PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void agregarContenidoPDF(Document document, int folio, String tipoDocumento, 
                                          Date fechaSolicitud, String motivo) {
        // Título
        Paragraph titulo = new Paragraph("Solicitud de Impresión - Folio: " + folio);
        titulo.setTextAlignment(TextAlignment.CENTER);
        titulo.setFontSize(16);
        document.add(titulo);
        document.add(new Paragraph("\n"));

        // Formatear fecha
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = dateFormat.format(fechaSolicitud);

        // Detalles
        document.add(new Paragraph("Tipo de Documento: " + tipoDocumento));
        document.add(new Paragraph("Fecha de Solicitud: " + fechaFormateada));
        document.add(new Paragraph("Motivo: " + motivo));
        document.add(new Paragraph("\n"));

    }
}