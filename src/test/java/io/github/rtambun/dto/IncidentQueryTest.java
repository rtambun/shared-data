package io.github.rtambun.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class IncidentQueryTest {

    @Test
    void noArgsConstructor() {
        IncidentQuery incidentQuery = new IncidentQuery();
        assertThat(incidentQuery.getCount()).isEqualTo(0);
        assertThat(incidentQuery.getIncidents()).isEqualTo(null);

        incidentQuery.setCount(1);
        incidentQuery.setIncidents(new ArrayList<>());

        assertThat(incidentQuery.getCount()).isEqualTo(1);
        assertThat(incidentQuery.getIncidents()).usingRecursiveComparison().isEqualTo(new ArrayList<>());
    }

    @Test
    void allArgsConstructor() {
        IncidentQuery incidentQuery = new IncidentQuery(1, new ArrayList<>());

        assertThat(incidentQuery.getCount()).isEqualTo(1);
        assertThat(incidentQuery.getIncidents()).usingRecursiveComparison().isEqualTo(new ArrayList<>());
    }

    @Test
    void deserializingTest() throws JsonProcessingException {
        String payloadJson = "{\"Count\":1," +
                "\"incidents\":[]}";
        IncidentQuery incidentQuery = new ObjectMapper().readValue(payloadJson, new TypeReference<>() {
        });
        assertThat(incidentQuery.getCount()).isEqualTo(1);
        assertThat(incidentQuery.getIncidents()).usingRecursiveComparison().isEqualTo(new ArrayList<>());
    }

}