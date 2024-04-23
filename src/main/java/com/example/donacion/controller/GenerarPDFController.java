package com.example.donacion.controller;

import com.example.donacion.model.Donacion;
import com.example.donacion.model.response.DonacionResponse;
import com.example.donacion.service.DonacionService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/generar-pdf")
public class GenerarPDFController {

    private final TemplateEngine templateEngine;
    @Autowired
    private DonacionService donacionService;

    public GenerarPDFController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<InputStreamResource> generarPDF() throws IOException, DocumentException {
        // Obtener la lista de donaciones (de donde sea que provenga)
        List<Donacion> donaciones = donacionService.getAllDonacions();
		List<DonacionResponse> donacionResponses = new ArrayList<>();
        for (Donacion donacion : donaciones) {
            DonacionResponse donacionResponse = new DonacionResponse();
            donacionResponse.setFechaAdquisicion(String.valueOf(donacion.getFecha_adquisicion()));
            donacionResponse.setCantidad(donacion.getCantidad());
            donacionResponse.setNombreProducto(donacion.getProducto().getNombre());
            donacionResponse.setNombreOrganizacion(donacion.getOrganizacion().getNombre_org());
            donacionResponse.setNombreDonante(donacion.getDonante().getNombre());
            donacionResponse.setNombreVoluntarioRecojo(donacion.getVoluntarioRecojo().getNombre());
            donacionResponses.add(donacionResponse);
        }

        // Crear el contexto de Thymeleaf y agregar la lista de donaciones
        Context context = new Context();
        context.setVariable("donaciones", donacionResponses); // Puedes descomentar esta línea si tienes la lista de donaciones

        // Procesar la plantilla HTML con Thymeleaf
        String html = templateEngine.process("plantilla-pdf", context);

        // Crear el PDF a partir del HTML generado
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);

        // Configurar la respuesta para descargar el PDF
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        InputStreamResource resource = new InputStreamResource(inputStream);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=lista_donaciones.pdf");

        // Devolver la respuesta con el PDF como recurso de entrada
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }











//    private final ResourceLoader resourceLoader;
//
//    public GenerarPDFController(ResourceLoader resourceLoader) {
//        this.resourceLoader = resourceLoader;
//    }
//
//    @GetMapping
//    public void generarPDF(HttpServletResponse response) throws IOException {
//
//        String htmlContent = null;
//        // Configurar el tipo de contenido de la respuesta como PDF
//        response.setContentType("application/pdf");
//
//        // Establecer el nombre del archivo PDF de salida
//        response.setHeader("Content-Disposition", "attachment; filename=reporte.pdf");
//
//        try (OutputStream outputStream = response.getOutputStream();
//             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
//
//            // Inicializar el renderizador de HTML a PDF
//            ITextRenderer renderer = new ITextRenderer();
//
//            String htmlFilePath = "templates/principal/donaciones.html";
//            System.out.println(htmlFilePath);
////            renderer.setDocument(htmlFilePath);
//
//             Resource resource = resourceLoader.getResource("classpath:templates/principal/donaciones.html");
//
//        // Leer el contenido del archivo HTML
//        try (InputStream inputStream = resource.getInputStream();
//             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
//            // Leer todas las líneas del archivo y concatenarlas en una sola cadena
//            htmlContent = reader.lines().collect(Collectors.joining("\n"));
//            System.out.println(htmlContent);
//        }
//
//            Document doc = Jsoup.parse(htmlContent);
//
//            // Obtener el elemento body
//            Element body = doc.body();
//            // Crear un documento HTML vacío //hacer un reporte prediseñado en html
//            renderer.setDocumentFromString("<html>"+body.html()+"</html>");
//            //renderer.setDocumentFromString(htmlContent);
//
//            // Renderizar el contenido a PDF
//            renderer.layout();
//            renderer.createPDF(byteArrayOutputStream);
//
//            // Escribir el contenido del PDF en el flujo de salida de la respuesta
//            byteArrayOutputStream.writeTo(outputStream);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Manejar cualquier excepción que pueda ocurrir durante la generación del PDF
//            // Por ejemplo, podrías mostrar un mensaje de error al usuario
//        }
//    }
}

