package com.shoolms.school.service;

import com.shoolms.school.models.FilesParent;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileStorageService {
    void storeFile(Long parentId, MultipartFile file) throws FileUploadException;
    FilesParent getFile(Long fileId) throws FileNotFoundException;
    List<String> getFilesByParentId(Long parentId);
}
