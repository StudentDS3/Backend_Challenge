package com.example.superhero;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringEncryptionTest {

    @Test
    public void testEncrypt() {
        assertEquals("def", StringEncryption.encrypt("abc"), "Encryption of 'abc' should be 'def'");
        assertEquals("wklv lv d whvw phvvdjh", StringEncryption.encrypt("this is a test message"), "Encryption of 'this is a test message' should be 'wklv lv d whvw phvvdjh'");
        assertEquals("Wklv lv d whvw phvvdjh", StringEncryption.encrypt("This is a test message"), "Encryption of 'This is a test message' should be 'Wklv lv d whvw phvvdjh'");
        assertEquals("123", StringEncryption.encrypt("123"), "Encryption of '123' should be '123'");
    }
}

