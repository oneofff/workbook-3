package com.pluralsight.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

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

    public <T> List<T> getObjectListFromCvsFile(Function<String,T> mapper) {
        String header = this.readLine(); // skip header
        List<T> list = new LinkedList<>();
        while (true) {
            String line = this.readLine();
            if (line == null)
                break;
            list.add(mapper.apply(line));
        }
        return list;
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
