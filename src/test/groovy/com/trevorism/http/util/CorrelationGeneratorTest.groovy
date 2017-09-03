package com.trevorism.http.util

import org.junit.Test

/**
 * @author tbrooks
 */
class CorrelationGeneratorTest {
    @Test
    void testGenerate() {
        String id1 = CorrelationGenerator.generate()
        String id2 = CorrelationGenerator.generate()

        assert id1
        assert id2
        assert id1 != id2

    }
}
