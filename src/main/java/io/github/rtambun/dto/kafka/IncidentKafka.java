package io.github.rtambun.dto.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncidentKafka {

    private final static String INCIDENT_PAYLOAD_TYPE_INCIDENT = "Incident";
    private final static String INCIDENT_PAYLOAD_CATEGORY_INCIDENT_STATUS_UPDATE = "IncidentStatusUpdated";
    private final static String INCIDENT_PAYLOAD_CATEGORY_INCIDENT_REMOVE_BLUE_INDICATOR_FROM_MAP =
            "RemovedBlueIndicatorFromMap";

    @JsonProperty(value="Payload")
    private String payload;
    @JsonProperty(value="PayloadType")
    private String payloadType;
    @JsonProperty(value="PayloadTypeCategory")
    private String payloadTypeCategory;
}
