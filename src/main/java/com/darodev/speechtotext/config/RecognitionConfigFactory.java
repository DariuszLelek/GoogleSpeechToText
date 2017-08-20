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
package com.darodev.speechtotext.config;

import com.google.cloud.speech.v1.RecognitionConfig;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dariusz Lelek
 */
public class RecognitionConfigFactory {
    private static final RecognitionConfig DEFAULT_CONFIG = RecognitionConfig.getDefaultInstance();
    private static final Map<Configuration, RecognitionConfig> CACHE = new HashMap<>();

    public static RecognitionConfig getRecognitionConfig(Configuration config) {
        return config == null || config == Configuration.DEFAULT ? DEFAULT_CONFIG : getFromCache(config);
    }
    
    private static RecognitionConfig getFromCache(Configuration config){
        if(!CACHE.containsKey(config)){
            CACHE.put(config, buildRecognitionConfig(config));
        }
        
        return CACHE.get(config);
    }
    
    private static RecognitionConfig buildRecognitionConfig(Configuration config) {
        return RecognitionConfig.newBuilder()
                .setEncoding(config.getEncoding())
                .setSampleRateHertz(config.getSampleRateHertz())
                .setLanguageCode(config.getLanguageCode())
                .build();
    }
}
