package org.logparser.parser;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ParserController {
    private final ParserService parserService;

    @PostMapping("/process-text")
    public ResponseEntity<ParseResponseDto> processText(
            @RequestBody ParseRequestDto request
    ) {
        return ResponseEntity.ok().body(parserService.parseText(request));
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Сервер работает!");
    }
}
