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
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Dariusz Lelek
 */
public class RecognitionConfigFactoryTest {
    
    public RecognitionConfigFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getRecognitionConfig method, of class RecognitionConfigFactory.
     */
    @Test
    public void testGetRecognitionConfig() {
        System.out.println("getRecognitionConfig");
        Configuration configurationNull = null;
        Configuration configurationDefault = Configuration.DEFAULT;
        Configuration configurationLinear16 = Configuration.LINEAR16_16_EN;
        
        RecognitionConfig defaultConfigExpected = RecognitionConfig.getDefaultInstance();
        
        Assert.assertEquals(defaultConfigExpected, RecognitionConfigFactory.getRecognitionConfig(configurationNull));
        Assert.assertEquals(defaultConfigExpected, RecognitionConfigFactory.getRecognitionConfig(configurationDefault));
        
        RecognitionConfig defaultConfigLinear16Expected = RecognitionConfigFactory.getRecognitionConfig(configurationLinear16);
        
        Assert.assertNotNull(defaultConfigLinear16Expected);
        Assert.assertEquals(Configuration.LINEAR16_16_EN.getEncoding(), defaultConfigLinear16Expected.getEncoding());
        Assert.assertEquals(Configuration.LINEAR16_16_EN.getLanguageCode(), defaultConfigLinear16Expected.getLanguageCode());
        Assert.assertEquals(Configuration.LINEAR16_16_EN.getSampleRateHertz(), defaultConfigLinear16Expected.getSampleRateHertz());
    }
    
}
