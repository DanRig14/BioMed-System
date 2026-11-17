
package com.biomedsystems.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    Patient p1 = new Patient(
            "123",
            "Daniel",
            "Fun",
            "dFun@gmail.com",
            LocalDate.of(2024, 11, 14)
    );

    Patient p2 = new Patient(
            "124",
            "Jack",
            "Buck",
            "jBuck@email.com",
            LocalDate.of(2023, 11, 14)
    );

    @Test
    void testPatientFullName() {
        assertEquals("Fun, Daniel", p1.getFullName());
    }

    @Test
    void testEmail() {
        assertEquals("dFun@gmail.com", p1.getEmail());
    }

    @Test
    void testPatientId() {
        assertNotNull(p1.getId());
        assertNotEquals(p1.getId(), p2.getId());
    }

    @Test
    void testSetFirstName() {
        p1.setFirstName("David");

        assertEquals("David", p1.getFirstName());
    }

    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            p1.setFirstName("");
        });
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            p1.setEmail("invalid-email");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Patient(
                    "126",
                    "John",
                    "Smith",
                    "invalid-email",
                    LocalDate.of(2000, 5, 15)
            );
        });
    }

    @Test
    void testValidEmail() {
        p1.setEmail("newemail@gmail.com");

        assertEquals("newemail@gmail.com", p1.getEmail());
    }

    @Test
    void testInvalidDateOfBirth() {
        assertThrows(IllegalArgumentException.class, () -> {
            p1.setDateOfBirth(LocalDate.now().plusDays(1));
        });
    }

    @Test
    void testFutureDateOfBirth() {
        assertThrows(IllegalArgumentException.class, () -> {
            p1.setDateOfBirth(LocalDate.now().plusDays(1));
        });
    }
}
