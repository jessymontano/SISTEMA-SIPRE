package com.mycompany.sipre.controlador;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneradorPDF {
    public static void generarPDF(int folio, String tipoDocumento, Date fechaSolicitud, String motivo) {
        // Crear el documento PDF
        try {
            // Ruta donde se guardará el PDF generado
            String rutaPDF = "solicitud_folio_" + folio + ".pdf";

            // Establecer el escritor del PDF
            PdfWriter writer = new PdfWriter(new FileOutputStream(rutaPDF));
            PdfDocument pdfDoc = new PdfDocument(writer);

            // Crear el documento iText
            Document document = new Document(pdfDoc);

            // Agregar contenido al documento
            Paragraph titulo = new Paragraph("Solicitud para retirar Documentos de la bodega");
            titulo.setTextAlignment(TextAlignment.CENTER);  // Aquí usamos TextAlignment correctamente
            document.add(titulo);
            document.add(new Paragraph(" "));  // Salto de línea

            // Formatear la fecha de solicitud
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = dateFormat.format(fechaSolicitud);

            // Detalles de la solicitud
            document.add(new Paragraph("Folio: " + folio));
            document.add(new Paragraph("Tipo de Documento: " + tipoDocumento));
            document.add(new Paragraph("Fecha de Solicitud: " + fechaFormateada));
            document.add(new Paragraph("Motivo: " + motivo));
            document.add(new Paragraph(" "));  // Salto de línea

            // Cerrar el documento
            document.close();
            System.out.println("PDF generado en la ruta: " + rutaPDF);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al generar el PDF.");
        }
    }
}

