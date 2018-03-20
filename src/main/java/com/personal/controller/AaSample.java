package com.personal.controller;

import com.sun.media.jfxmedia.control.VideoFormat;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static j2html.TagCreator.*;
/**
 * Created by tim on 6/28/17.
 */
@RestController
public class AaSample {
    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/hi")
    public String index(){
        //File file = new File("/home/tim/Desktop/Other Files/System/imagejpeg_0j.jpg");
        String contents="";
        try {
             contents = new String(Files.readAllBytes(Paths.get("/home/tim/Desktop/hi.html")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String local = "http://localhost:8080";
    return contents;
//            String.format(
//            "<html>\n" +
//                    "<head>\n" +
//                    "\n" +
//                    "<!--THIS WILL LOAD THE VIDEO-->\n" +
//                    "<!--\n" +
//                    "<meta name=\"viewpoint\" content=\"width=device-width\">\n" +
//                    "</head>\n" +
//                    "<body style=\"margin: 0px;\">\n" +
//                     "-->\n" +
//                    "<h2>JavaScript in Body</h2>\n" +
//                    "\n" +
//                    "<p id=\"demo\"></p>\n" +
//                    "<p id=\"foo\"></p>\n" +
//                    "\n" +
//                    "<script>\n" +
//                    "var img = new Image();\n" +
//                    "img.src = 'http://localhost:8080/photo2';\n" +
//                    "var div = document.getElementById('foo');\n" +
//                    "\n" +
//                    "img.onload = function() {\n" +
//                    "  div.appendChild(img);\n" +
//                    "};\n" +
//                    "\n" +
//                    "document.getElementById(\"demo\").innerHTML = \"My First JavaScript\";\n" +
//                    "</script>\n" +
//                    "\n" +
//                    "</body>\n" +
//                    "</html> ");
//            String.format(
//            "<html>\n" +
//            "<head>\n" +
//            "<meta name=\"viewpoint\" content=\"width=device-width\">\n" +
//            "</head>\n" +
//            "<body style=\"margin: 0px;\">\n" +
//            "<video controls=\"\" autoplay=\"\" name=\"media\">" +
//          //  "<source src=\"http://localhost:8080/photo2\" type=\"video/mp4\">" +
//            "  <source type=\"video/mp4\" src=\"%s/test.mp4\" />\n" +
//            "      <!-- WebM/VP8 for Firefox4, Opera, and Chrome -->\n" +
//            "      <source type=\"video/webm\" src=\"%s/output.webm\" />"+
//            "</video>\n" +
//            "</body>\n" +
//            "</html>",local,local);
    }
 //   @RequestMapping("/photo2")




    @RequestMapping(value="photo2")
    public ResponseEntity<byte[]> testphoto() throws IOException {

        Path path = Paths.get("/home/tim/Desktop/giphy.gif");
        File file = new File(path.toString());//imagejpeg_0j.jpg

        InputStream targetStream = new FileInputStream(file);

        final HttpHeaders headers = new HttpHeaders();

        headers.setContentLength(file.length());
        headers.setContentType(MediaType.parseMediaType(Files.probeContentType(path)));
        return new ResponseEntity<byte[]>(IOUtils.toByteArray(targetStream), headers, HttpStatus.CREATED);
    }


//    @RequestMapping(value="/{endPoint:.+}")
//    public ResponseEntity<byte[]> testphoto(@PathVariable String endPoint) throws IOException {
//
//        Path path = Paths.get("/home/tim/Desktop/Other Files/System/"+endPoint);
//        File file = new File(path.toString());//imagejpeg_0j.jpg
//
//        InputStream targetStream = new FileInputStream(file);
//
//        final HttpHeaders headers = new HttpHeaders();
//
//        headers.setContentLength(file.length());
//        headers.setContentType(MediaType.parseMediaType(Files.probeContentType(path)));
//        return new ResponseEntity<byte[]>(IOUtils.toByteArray(targetStream), headers, HttpStatus.CREATED);
//    }
}
