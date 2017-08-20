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

import com.google.cloud.speech.v1.RecognitionAudio;
import com.darodev.speechtotext.utility.FileUtilityTest;
import com.darodev.speechtotext.utility.LogUtility;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Dariusz Lelek
 */
public class AudioProviderTest {
    
    public AudioProviderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getDefaultRecognitionAudio method, of class
 AudioProvider.
     */
    @Test
    public void testGetDefaultRecognitionAudio() {
        LogUtility.logInfo(AudioProviderTest.class, "test: getDefaultRecognitionAudio");

        RecognitionAudio expected = RecognitionAudio.getDefaultInstance();

        assertEquals(expected, AudioProvider.getDefaultRecognitionAudio());
    }

    /**
     * Test of getRecognitionAudio method, of class AudioProvider.
     */
    @Test
    public void testGetRecognitionAudio_String() {
        LogUtility.logInfo(AudioProviderTest.class, "test: getRecognitionAudio");

        int testFileSerializedSizeExpected = 57962;
        RecognitionAudio recognitionAudioActual = AudioProvider.getRecognitionAudio(FileUtilityTest.TEST_FILE_LOCATION);

        assertNotNull(recognitionAudioActual);
        assertEquals(testFileSerializedSizeExpected, recognitionAudioActual.getSerializedSize());
    }

}
