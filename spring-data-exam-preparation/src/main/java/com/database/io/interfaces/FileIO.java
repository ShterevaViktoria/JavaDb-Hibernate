package com.database.io.interfaces;

import java.io.IOException;

/**
 * Created by dell on 12/11/2016.
 */
public interface FileIO {
    String read(String file) throws IOException;

    void write(String fileContent, String file) throws IOException;

}
