package colmentatec.reverse.services;

import colmentatec.reverse.dto.ClassAnalyzeDTO;
import colmentatec.reverse.dto.MethodAnalyzeDTO;
import colmentatec.reverse.utils.FilesUtils;
import colmentatec.reverse.visitors.ClassVisitor;
import colmentatec.reverse.visitors.MethodVisitor;
import colmentatec.reverse.visitors.errors.JavaErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import colmentatec.reverse.antlrJava.*;
import org.antlr.v4.runtime.ANTLRInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@Service
public class JavaService {

    @Autowired
    ClassVisitor classVisitor;
    @Autowired
    MethodVisitor methodVisitor;
    @Autowired
    FilesUtils filesUtils;

    //Analiza el codigo java a partir del path de un directorio
    public void analizarCodigoFromPath (String path)
    {
        List<File> files = filesUtils.getFilesFromPath(path);
        for (File file : files) {
            ANTLRInputStream input = null;
            try {
                //Crea los componentes necesarios de ANTLR para visitar el arbol de derivacion para un archivo
                input = new ANTLRInputStream(new FileInputStream(file));
                JavaLexer lexer = new JavaLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                JavaParser parser = new JavaParser(tokens);
                parser.addErrorListener(new JavaErrorListener()); //Inyecta manejador de errores personalizados de ANTLR
                ParseTree tree = parser.compilationUnit();
                classVisitor.visit(tree);
                methodVisitor.visit(tree);

            } catch (Exception e) {

                throw new RuntimeException(String.format("Error en la clase %s debido a %s",file.getName(),e.getMessage()));
            }
        }
    }
}
