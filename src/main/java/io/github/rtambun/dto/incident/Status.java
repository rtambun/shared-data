package io.github.rtambun.dto.incident;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    OPEN,
    CLOSED,
    @JsonEnumDefaultValue UNKNOWN
}
