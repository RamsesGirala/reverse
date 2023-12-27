package colmentatec.reverse.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MethodAnalyzeDTO {
    private String name;
    private int cyclomatic_complexity;
}
