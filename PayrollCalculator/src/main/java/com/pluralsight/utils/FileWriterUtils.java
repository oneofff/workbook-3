package com.pluralsight.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtils implements AutoCloseable {
    private final BufferedWriter bufferedWriter;

    public FileWriterUtils(String file) {
        try {
            File newFile = new File(file);
            File parent = newFile.getParentFile();
            if (!parent.exists())
                if (!parent.mkdir()){
                    throw new IOException("Could not create directory: " + parent);
                }
            this.bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void writeLine(String line) {
        try {
            bufferedWriter.write(line);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            bufferedWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
