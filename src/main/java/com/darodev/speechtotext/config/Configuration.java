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

import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;

/**
 *
 * @author Dariusz Lelek
 */
public enum Configuration {
    DEFAULT(),
    
    LINEAR16_16_EN(AudioEncoding.LINEAR16, 16000, "en-US");

    private AudioEncoding encoding;
    private int sampleRateHertz;
    private String languageCode;

    Configuration(){
    }
    
    Configuration(AudioEncoding encoding, int sampleRate, String languageCode) {
        this.encoding = encoding;
        this.sampleRateHertz = sampleRate;
        this.languageCode = languageCode;
    }

    public AudioEncoding getEncoding() {
        return encoding;
    }

    public int getSampleRateHertz() {
        return sampleRateHertz;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    @Override
    public String toString() {
        return "Encoding[" + encoding.name() + "] SampleRate(Hz)[" + sampleRateHertz + "] Language[" + languageCode + "]";
    }

    
}
