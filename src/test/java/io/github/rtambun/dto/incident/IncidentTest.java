package io.github.rtambun.dto.incident;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.rtambun.dto.util.InstantGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class IncidentTest {

    @Test
    public void noArgsConstructor() {
        Incident incident = new Incident();

        assertThat(incident.getLabel()).isNull();
        assertThat(incident.getCloseDate()).isNull();
        assertThat(incident.getCreatedDate()).isNull();
        assertThat(incident.getStatus()).isNull();

        Instant now = Instant.now();
        incident.setLabel("label");
        incident.setCreatedDate(now);
        incident.setCloseDate(now);
        incident.setStatus(Status.OPEN);

        assertThat(incident.getLabel()).isEqualTo("label");
        assertThat(incident.getCloseDate()).isEqualTo(now);
        assertThat(incident.getCreatedDate()).isEqualTo(now);
        assertThat(incident.getStatus()).isEqualTo(Status.OPEN);
    }

    @Test
    public void allArgsConstructor() {
        Instant now = Instant.now();

        Incident incident = new Incident("label", now, now, Status.CLOSED);

        assertThat(incident.getLabel()).isEqualTo("label");
        assertThat(incident.getCloseDate()).isEqualTo(now);
        assertThat(incident.getCreatedDate()).isEqualTo(now);
        assertThat(incident.getStatus()).isEqualTo(Status.CLOSED);
    }

    @Test
    public void deserializingTest() throws JsonProcessingException {
        String payloadJson = "{\"label\":\"label\"," +
                "\"createdDate\":\"08/06/2022 08:08:52\"," +
                "\"closeDate\":\"08/06/2022 08:08:52\"," +
                "\"status\":\"CLOSED\"" +
                "}";
        Incident actual = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .readValue(payloadJson, Incident.class);

        Incident expected = new Incident("label",
                InstantGenerator.generateInstantUTC(2022,6,8, 8, 8, 52),
                InstantGenerator.generateInstantUTC(2022,6, 8, 8, 8, 52),
                Status.CLOSED);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void deserializingTest_StatusStringNull() throws JsonProcessingException {
        String payloadJson = "{\"label\":\"label\"," +
                "\"createdDate\":\"08/06/2022 08:08:52\"," +
                "\"closeDate\":\"08/06/2022 08:08:52\"," +
                "\"status\":null" +
                "}";
        Incident actual = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .readValue(payloadJson, Incident.class);

        Incident expected = new Incident("label",
                InstantGenerator.generateInstantUTC(2022,6,8, 8, 8, 52),
                InstantGenerator.generateInstantUTC(2022,6, 8, 8, 8, 52),
                Status.UNKNOWN);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"\"\"", "\"any\""})
    public void deserializingTest_StatusStringUnknown(String status) throws JsonProcessingException {
        String payloadJson = "{\"label\":\"label\"," +
                "\"createdDate\":\"08/06/2022 08:08:52\"," +
                "\"closeDate\":\"08/06/2022 08:08:52\"," +
                "\"status\":" + status +
                "}";
        Incident actual = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)
                .readValue(payloadJson, Incident.class);

        Incident expected = new Incident("label",
                InstantGenerator.generateInstantUTC(2022,6,8, 8, 8, 52),
                InstantGenerator.generateInstantUTC(2022,6, 8, 8, 8, 52),
                Status.UNKNOWN);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void serializingTest() throws JsonProcessingException {
        Instant now = Instant.now();
        String stringNow = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.ofInstant(now, ZoneOffset.UTC));
        Incident test = new Incident("label", now, now, Status.CLOSED);
        String actual = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(test);
        String expected = "{" +
                "\"label\":\"label\"," +
                "\"createdDate\":\"" + stringNow + "\"," +
                "\"closeDate\":\"" + stringNow + "\"," +
                "\"status\":\"CLOSED\"" +
                "}";
        assertThat(actual).isEqualTo(expected);
    }

}