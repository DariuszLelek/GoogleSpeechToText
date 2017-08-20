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

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/**
 *
 * @author Dariusz Lelek
 */
public class LogUtility {
    private static final Map<String, Logger> CACHE = new HashMap<>();
    private static final boolean PRINT_TO_CONSOLE = true;
    
    public static void logInfo(Class clazz, String message) {
        getLogger(clazz).log(Priority.INFO, message);
        printToConsole(message, null);
    }

    public static void logError(Class clazz, String message, Throwable t){
        getLogger(clazz).log(Priority.ERROR, message, t);
        printToConsole(message, t);
    }
    
    private static void printToConsole(String message, Throwable t){
        if(PRINT_TO_CONSOLE){
            System.out.println(message);
            printStackTrace(t);
        }
    }

    private static void printStackTrace(Throwable t) {
        if (t != null) {
            t.printStackTrace();
        }
    }

    private static Logger getLogger(Class clazz){
        if(!CACHE.containsKey(clazz.getName())){
            CACHE.put(clazz.getName(), Logger.getLogger(clazz));
        }
        
        return CACHE.get(clazz.getName());
    }
}
