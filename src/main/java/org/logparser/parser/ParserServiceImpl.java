package org.logparser.parser;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ParserServiceImpl implements ParserService {

    @Override
    public ParseResponseDto parseText(ParseRequestDto request) {
        String[] lines = request.getText().split(request.getRegex());
        int index = lines[1].indexOf(request.getCutoff());
        if (index == -1) return ParseResponseDto.builder().build();
        return ParseResponseDto.builder()
                .text(Arrays.stream(lines)
                        .filter(l -> !l.isEmpty())
                        .map(l -> l.substring(index + request.getCutoff().length()).trim())
                        .toList())
                .build();
    }
}
