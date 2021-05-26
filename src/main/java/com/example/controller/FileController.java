package com.example.controller;

import com.example.dao.DocumentDao;
import com.example.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.function.EntityResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class FileController {

    @Autowired
    DocumentDao documentDao;

    @PostMapping(value = "/file")
    public String fileUpload(@RequestParam MultipartFile[] mFile) throws IOException {
                //mFile will contains resume and cover letter
                List<Document> documents = new ArrayList<>();
                for(MultipartFile multipartFile: mFile){
                    //add byte array to document obj
                    documents.add(new Document(multipartFile.getName(),multipartFile.getBytes()));
                }
                //get all application info from front end form and create application obj;
                //application.setDocument;
                //applicationDao.save(application);
                return "success";
    }

    @GetMapping(value = "file")
    public EntityResponse<?> getFile(HttpServletResponse response) throws IOException {

        Optional<Document> file = documentDao.findById(1);

        try(OutputStream os = response.getOutputStream(); ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
            byteArrayOutputStream.write(file.get().getData()); //get byte[] array then write it to byteArrayOutputStream
            response.setContentType("application/pdf"); //set response type to determine file type
            response.setHeader("Content-Disposition", "attachment;filename="+ new String("test.pdf".getBytes()));
            byteArrayOutputStream.writeTo(os);
            response.getOutputStream().flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
