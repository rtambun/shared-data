package io.github.rtambun.dto.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IncidentKafkaTest {
    @Test
    void setPayload() {
        IncidentKafka incidentKafka = new IncidentKafka();
        assertThat(incidentKafka.getPayload()).isNull();
        incidentKafka.setPayload("payload");
        assertThat(incidentKafka.getPayload()).isEqualTo("payload");
    }

    @Test
    void setPayloadType() {
        IncidentKafka incidentKafka = new IncidentKafka();
        assertThat(incidentKafka.getPayloadType()).isNull();
        incidentKafka.setPayloadType("payloadType");
        assertThat(incidentKafka.getPayloadType()).isEqualTo("payloadType");
    }

    @Test
    void setPayloadTypeCategory() {
        IncidentKafka incidentKafka = new IncidentKafka();
        assertThat(incidentKafka.getPayloadTypeCategory()).isNull();
        incidentKafka.setPayloadTypeCategory("payloadTypeCategory");
        assertThat(incidentKafka.getPayloadTypeCategory()).isEqualTo("payloadTypeCategory");
    }

    @Test
    void allArgsConstructor() {
        IncidentKafka incidentKafka = new IncidentKafka("payload",
                "payloadTypeCategory",
                "payloadTypeCategory");
        assertThat(incidentKafka.getPayload()).isEqualTo("payload");
        assertThat(incidentKafka.getPayloadTypeCategory()).isEqualTo("payloadTypeCategory");
        assertThat(incidentKafka.getPayloadTypeCategory()).isEqualTo("payloadTypeCategory");
    }

    @Test
    void serializingTestOk() throws JsonProcessingException {
        String payloadJson = "{\"Payload\":\"payload\"," +
                "\"PayloadType\":\"payloadType\"," +
                "\"PayloadTypeCategory\":\"payloadTypeCategory\"}";
        IncidentKafka incidentKafka = new ObjectMapper().readValue(payloadJson, new TypeReference<>() {
        });
        assertThat(incidentKafka.getPayload()).isEqualTo("payload");
        assertThat(incidentKafka.getPayloadTypeCategory()).isEqualTo("payloadTypeCategory");
        assertThat(incidentKafka.getPayloadTypeCategory()).isEqualTo("payloadTypeCategory");
    }
}