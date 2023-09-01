package com.shoolms.school.service;

import com.shoolms.school.models.FilesParent;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

public interface FileStorageService {
    void storeFile(Long parentId, MultipartFile file) throws FileUploadException;
    FilesParent getFile(Long fileId) throws FileNotFoundException;
}
