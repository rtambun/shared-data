package io.github.rtambun.dto.incident;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Incident implements Serializable {

    private String label;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "UTC")
    private Instant createdDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "UTC")
    private Instant closeDate;

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private Status status;
}
