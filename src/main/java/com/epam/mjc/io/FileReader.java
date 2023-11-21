package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        Map<String, String> map = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(":", 2);
                map.put(str[0].strip(), str[1].strip());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        profile.setAge(Integer.parseInt(map.get("Age")));
        profile.setEmail(map.get("Email"));
        profile.setName(map.get("Name"));
        profile.setPhone(Long.parseLong(map.get("Phone")));

        return profile;
    }
}
