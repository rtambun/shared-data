package io.github.rtambun.dto.incident;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

class IncidentTest {

    @Test
    public void noArgsConstructor() {
        Incident incident = new Incident();

        assertThat(incident.getCloseDate()).isNull();
        assertThat(incident.getCreatedDate()).isNull();
        assertThat(incident.getStatus()).isNull();

        Instant now = Instant.now();
        incident.setCreatedDate(now);
        incident.setCloseDate(now);
        incident.setStatus(Status.OPEN);

        assertThat(incident.getCloseDate()).isEqualTo(now);
        assertThat(incident.getCreatedDate()).isEqualTo(now);
        assertThat(incident.getStatus()).isEqualTo(Status.OPEN);
    }

    @Test
    public void allArgsConstructor() {
        Instant now = Instant.now();

        Incident incident = new Incident(now, now, Status.ON_GOING);

        assertThat(incident.getCloseDate()).isEqualTo(now);
        assertThat(incident.getCreatedDate()).isEqualTo(now);
        assertThat(incident.getStatus()).isEqualTo(Status.ON_GOING);
    }

    //TODO: Wait for answer from stackoverflow.
    /** @Test
    public void deserializingTest() throws JsonProcessingException {
        String payloadJson = "{" +
                "\"createdDate\":\"08/06/2022 08:08:52\"," +
                "\"closeDate\":\"08/06/2022 08:08:52\"," +
                "\"status\":\"CLOSED\"" +
                "}";
        Incident actual = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .readValue(payloadJson, Incident.class);

        Incident expected = new Incident(
                InstantGenerator.generateInstantUTC(2022,6,8, 8, 8, 52),
                InstantGenerator.generateInstantUTC(2022,6, 8, 8, 8, 52),
                Status.OPEN);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }*/

    @Test
    public void serializingTest() throws JsonProcessingException {
        Incident actual = new Incident(Instant.now(), Instant.now(), Status.CLOSED);
        String json = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(actual);
        System.out.println(json);
    }

}