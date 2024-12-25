package org.logparser.parser;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParseRequestDto {
    @NotBlank
    String text;

    @NotBlank
    @Size(min = 1, max = 255)
    String cutoff;

    @Size(min = 2)
    String regex;
}
