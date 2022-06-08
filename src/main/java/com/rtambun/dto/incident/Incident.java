package com.rtambun.dto.incident;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Incident implements Serializable {

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "UTC")
    private Instant createdData;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "UTC")
    private Instant closeDate;

    private Enum<Status> status;
}