package colmentatec.reverse.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class ClassAnalyzeDTO {
    private String package_name;
    private String name;
    private List<MethodAnalyzeDTO> methodAnalyzeDTOList;

}
