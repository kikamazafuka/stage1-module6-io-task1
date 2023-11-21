package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


public class FileReader {
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());

    public Profile getDataFromFile(File file){
        Profile profile = new Profile();
        Map<String, String> map = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(":", 2);
                map.put(str[0].strip(), str[1].strip());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            logger.warning("FileNotFound exception");
        }
        catch (IOException ioException){
            logger.warning("IO exception");
        }
        profile.setAge(Integer.parseInt(map.get("Age")));
        profile.setEmail(map.get("Email"));
        profile.setName(map.get("Name"));
        profile.setPhone(Long.parseLong(map.get("Phone")));

        return profile;
    }
}
