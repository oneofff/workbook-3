package com.pluralsight;

import java.io.*;

public class FileReaderUtils {
    private final BufferedReader bufferedReader;

    public FileReaderUtils(String file) {
        InputStream inputStream = FileReaderUtils.class.getClassLoader().getResourceAsStream(file);
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String readLine(){
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
