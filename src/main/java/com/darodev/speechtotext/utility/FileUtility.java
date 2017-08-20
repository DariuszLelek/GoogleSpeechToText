/*
 * Copyright 2017 Dariusz Lelek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.darodev.speechtotext.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Dariusz Lelek
 */
public class FileUtility {
    public static byte[] getFileData(final String fileName){
        return getFileData(getPath(fileName));
    }
    
    private static Path getPath(final String fileName) {
        Path path = Paths.get("");

        try {
            if (fileName != null && !fileName.isEmpty()) {
                path = Paths.get(fileName);
            }
        } catch (Exception ex) {
            LogUtility.logError(FileUtility.class, "Error during Paths.get()", ex);
        }

        return path;
    }

    private static byte[] getFileData(final Path path) {
        byte[] data = null;

        try {
            if (fileExists(path)) {
                data = Files.readAllBytes(path);
            }
        } catch (IOException ex) {
            LogUtility.logError(FileUtility.class, "Error during Files.readAllBytes()", ex);
        }

        return data != null ? data : new byte[0];
    }

    private static boolean fileExists(final Path path) {
        File f = new File(path.toUri());
        return !f.isDirectory() && f.exists();
    }
}
