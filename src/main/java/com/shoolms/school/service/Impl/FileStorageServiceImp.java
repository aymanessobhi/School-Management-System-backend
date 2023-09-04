package com.shoolms.school.service.Impl;

import com.shoolms.school.models.FilesParent;
import com.shoolms.school.models.MyParent;
import com.shoolms.school.repository.FileRepository;
import com.shoolms.school.repository.MyParentRepository;
import com.shoolms.school.service.FileStorageService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileStorageServiceImp implements FileStorageService {

    private final FileRepository fileRepository;
    private final MyParentRepository myParentRepository;
    @Autowired
    public FileStorageServiceImp(FileRepository fileRepository, MyParentRepository myParentRepository) {
        this.fileRepository = fileRepository;
        this.myParentRepository = myParentRepository;
    }

    @Override
    public void storeFile(Long parentId, MultipartFile file) throws FileUploadException {
        try {
            // Fetch the parent entity by ID (you should have a MyParentRepository)
            MyParent myParent = myParentRepository.findById(parentId)
                    .orElseThrow(() -> new EntityNotFoundException("Parent not found with id " + parentId));

            // Normalize file name
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            // Create a new FilesParent entity
            FilesParent filesParent = new FilesParent();
            filesParent.setFileName(fileName);
            filesParent.setFileType(file.getContentType());
            filesParent.setData(file.getBytes());
            filesParent.setMyParent(myParent);

            // Save the FilesParent entity to the database
            fileRepository.save(filesParent);
        } catch (IOException ex) {
            throw new FileUploadException("Could not store file for parent with ID " + parentId, ex);
        }
    }

    @Override
    public FilesParent getFile(Long fileId) throws FileNotFoundException {
        return fileRepository.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));

    }

    @Override
    public List<String> getFilesByParentId(Long parentId) {
        List<FilesParent> filesParents = fileRepository.findByMyParentId(parentId);
        // Extract and return the file names from the FilesParent entities
        return filesParents.stream()
                .map(FilesParent::getFileName)
                .collect(Collectors.toList());
    }

}
