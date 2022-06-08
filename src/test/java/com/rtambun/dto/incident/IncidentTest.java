package com.rtambun.dto.incident;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IncidentTest {

    @Test
    public void noArgsConstructor() {
        Incident incident = new Incident();

        assertThat(incident.getCloseDate()).isNull();
        assertThat(incident.getCreatedData()).isNull();
        assertThat(incident.getStatus()).isNull();
    }

}