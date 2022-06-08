package com.rtambun.dto.incident;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

class IncidentTest {

    @Test
    public void noArgsConstructor() {
        Incident incident = new Incident();

        assertThat(incident.getCloseDate()).isNull();
        assertThat(incident.getCreatedData()).isNull();
        assertThat(incident.getStatus()).isNull();

        Instant now = Instant.now();
        incident.setCreatedData(now);
        incident.setCloseDate(now);
        incident.setStatus(Status.OPEN);

        assertThat(incident.getCloseDate()).isEqualTo(now);
        assertThat(incident.getCreatedData()).isEqualTo(now);
        assertThat(incident.getStatus()).isEqualTo(Status.OPEN);
    }

}