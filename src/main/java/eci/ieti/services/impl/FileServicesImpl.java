package eci.ieti.services.impl;

import com.mongodb.client.gridfs.model.GridFSFile;
import eci.ieti.services.FileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FileServicesImpl implements FileServices {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Override
    public InputStreamResource getFileByName(String filename) throws IOException {
        GridFSFile file = gridFsTemplate.findOne(new Query().addCriteria(Criteria.where("filename").is(filename)));
        GridFsResource resource = gridFsTemplate.getResource(file.getFilename());
        return new InputStreamResource(resource.getInputStream());
    }
}
