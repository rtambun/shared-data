package io.github.rtambun.dto.incident;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    OPEN("OPEN"),
    ON_GOING("ON_GOING"),
    CLOSED("CLOSED");

    private String status;
}
