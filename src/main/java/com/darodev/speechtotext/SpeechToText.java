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

import com.darodev.speechtotext.config.RecognitionConfigFactory;
import com.darodev.speechtotext.config.Configuration;
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Dariusz Lelek
 */
public class SpeechToText {

    public List<String> getTextsListFromAudio(final RecognitionAudio audio, final RecognitionConfig config) {
        return getTranscriptTextsList(getRecognitionResultsList(audio, config));
    }

    private List<String> getTranscriptTextsList(final List<SpeechRecognitionResult> results) {
        return results.stream()
                .flatMap(recognitionResult -> recognitionResult.getAlternativesList().stream())
                .map(SpeechRecognitionAlternative::getTranscript)
                .collect(Collectors.toList());
    }

    private List<SpeechRecognitionResult> getRecognitionResultsList(final RecognitionAudio audio, final RecognitionConfig config) {
        return tryGetRecognizeResponse(audio, config != null ? config : RecognitionConfigFactory.getRecognitionConfig(Configuration.DEFAULT)).getResultsList();
    }

    private RecognizeResponse tryGetRecognizeResponse(final RecognitionAudio audio, final RecognitionConfig config) {
        RecognizeResponse response = RecognizeResponse.getDefaultInstance();

        try (SpeechClient speech = SpeechClient.create()) {
            // comment this for testing - dont send requests
            response = speech.recognize(config, audio);
        } catch (Exception ex) {
            // TODO
            ex.printStackTrace();
        }

        return response;
    }
}
