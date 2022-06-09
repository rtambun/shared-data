package io.github.rtambun.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.rtambun.dto.incident.Incident;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncidentQuery implements Serializable {
    @JsonProperty("Count")
    private int count;

    private List<Incident> incidents;
}
