/**
 * Copyright 2024 Sebastian Proksch
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package depinjection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LowerCaserTest {

    private TestIOUtils doc;
    private LowerCaser sut;

    @BeforeEach
    public void setup() {
        doc = new TestIOUtils();
        sut = new LowerCaser(doc);
    }

    @Test
    public void textShouldBeLowered() {
        doc.nextRead = "aBc";

        sut.run();

        var expected = "abc";
        var actual = doc.lastWrite;
        assertEquals(expected, actual);
    }

    @Test
    public void correctCallOrder() {
        // call read, call write
        sut.run();

        var expected = List.of("read", "write");
        var actual = doc.calls;
        assertEquals(expected, actual);
    }

    public class TestIOUtils implements IOUtils {

        public String nextRead = "";
        public String lastWrite;
        public List<String> calls = new LinkedList<>();

        @Override
        public String read() {
            calls.add("read");
            return nextRead;
        }

        @Override
        public void write(String s) {
            calls.add("write");
            lastWrite = s;
        }

    }
}