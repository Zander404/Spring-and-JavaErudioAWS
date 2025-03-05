package com.zander404.springandjavaerudio.controller;


import com.zander404.springandjavaerudio.entities.dto.UploadResponseDTO;
import com.zander404.springandjavaerudio.services.FileStorageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Tag(name = " File Endpoint")
@RestController
@RequestMapping("/api/v1/file")
public class FileController {
    private Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService service;

    @PostMapping("/uploadFile")
    public UploadResponseDTO updloaFile(@RequestParam("file") MultipartFile file) {
        logger.info("Uploaded file: " + file.getOriginalFilename());

        var filename = service.storeFile(file);
        String fileDonwloadURI = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/file/v1/downloadFile/")
                .path(filename)
                .toUriString();

        return new UploadResponseDTO(filename, fileDonwloadURI, file.getContentType(), file.getSize());

    }

    @GetMapping("/downloadFiles/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename, HttpServletRequest request) {
        logger.info("Download file: filename");

        Resource resource = service.loadFileResource(filename);
        String contentType = "";

        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        if (contentType.isBlank()) contentType = "application/octet-stream";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\""
                )
                .body(resource);
    }
}
