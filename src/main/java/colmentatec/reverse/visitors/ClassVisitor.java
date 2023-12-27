package colmentatec.reverse.visitors;

import colmentatec.reverse.antlrJava.JavaParser;
import colmentatec.reverse.antlrJava.JavaParserBaseVisitor;
import colmentatec.reverse.dto.ClassAnalyzeDTO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ClassVisitor extends JavaParserBaseVisitor<Void> {

    @Value("${java.extension}")
    private String java_extension;

    @Override
    public Void visitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {

        System.out.println((ctx.identifier().getText() + java_extension));
        return super.visitClassDeclaration(ctx);
    }

}
