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

    @RequestMapping(value = "/process-text", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> optionsParser() {
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:63342, https://kiselevalecksey.github.io")
                .header("Access-Control-Allow-Methods", "POST, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type")
                .build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Сервер работает!");
    }

    @RequestMapping(value = "/test", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> optionsTest() {
        return ResponseEntity.ok().build();
    }
}
