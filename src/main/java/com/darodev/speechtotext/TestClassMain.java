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

package com.darodev.speechtotext;

import com.darodev.speechtotext.config.Configuration;
import com.darodev.speechtotext.config.RecognitionConfigFactory;
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import java.util.List;

/**
 *
 * @author Dariusz Lelek
 */
public class TestClassMain {
    public static void main(String[] args) {
        SpeechToText service = new SpeechToText();
        
        String fileName = "src/main/resources/audio.raw"; // test file
        
        
        RecognitionConfig config = RecognitionConfigFactory.getRecognitionConfig(Configuration.LINEAR16_16_EN);
        RecognitionAudio audio = AudioProvider.getRecognitionAudio(fileName);
        
        List<String> texts = service.getTextsListFromAudio(audio, config);
        
        
    }
}
