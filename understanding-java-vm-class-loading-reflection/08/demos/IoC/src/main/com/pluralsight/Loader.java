package com.pluralsight;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kevinj.
 */
public class Loader {

    public Map<Class, Registration> loadConfiguration(String filename) throws IoCException {

        Map<Class, Registration> registrations = new HashMap<Class, Registration>();

        try {
            Path path = FileSystems.getDefault().getPath(filename);
            String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            List<Registration> parsedReg = mapper.readValue(contents, mapper.getTypeFactory().constructCollectionType(List.class, Registration.class));
            for (Registration r : parsedReg){
                Class<?> cls = Class.forName(r.getType());
                registrations.put(cls, r);
            }
        } catch (IOException e) {
            throw new IoCException(e);
        } catch (ClassNotFoundException e) {
            throw new IoCException(e);
        }
        return registrations;
    }
}
