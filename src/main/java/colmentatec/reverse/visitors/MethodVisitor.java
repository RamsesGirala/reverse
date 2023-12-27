package colmentatec.reverse.visitors;

import colmentatec.reverse.antlrJava.JavaParser;
import colmentatec.reverse.antlrJava.JavaParserBaseVisitor;
import colmentatec.reverse.dto.MethodAnalyzeDTO;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Component;

@Component
public class MethodVisitor extends JavaParserBaseVisitor<Void> {

    private final MethodAnalyzeDTO methodAnalyzeDTO = MethodAnalyzeDTO.builder().build();

    @Override
    public Void visitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        System.out.println(ctx.identifier().getText());
        return super.visitMethodDeclaration(ctx);
    }

    @Override
    public Void visitMethodBody(JavaParser.MethodBodyContext ctx) {

        return super.visitMethodBody(ctx);
    }

    @Override
    public Void visitStatement(JavaParser.StatementContext ctx) {

        if(ctx.TRY() != null) System.out.println("Un TRY");
        if(ctx.IF() != null) System.out.println("Un IF");
        if(ctx.ELSE() != null) System.out.println("Un ELSE");
        if(ctx.DO() != null) System.out.println("Un DO");
        if(ctx.WHILE() != null) System.out.println("Un While");
        if(ctx.FOR() != null) System.out.println("Un FOR");
        if(ctx.switchBlockStatementGroup().size() > 0){
            System.out.println("Cantidad de CASE y DEFAULT " + ctx.switchBlockStatementGroup().size());
        }
        if(ctx.catchClause().size()> 0){
            System.out.println("Cantidad de CATCH " + ctx.catchClause().size());
        }

        return super.visitStatement(ctx);
    }


}
