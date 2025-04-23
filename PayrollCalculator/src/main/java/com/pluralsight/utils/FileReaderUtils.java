package com.pluralsight.utils;

import java.io.*;

public class FileReaderUtils implements AutoCloseable {
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

    @Override
    public void close(){
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
