package eci.ieti.services;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface FileServices {

    public InputStreamResource getFileByName(String filename) throws IOException;
}
