package visitors;

import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import translate.Translator;

public class PackageVisitor extends VoidVisitorAdapter<Void> {
    private Translator translator;

    public PackageVisitor(Translator translator) {
        this.translator = translator;
    }
    @Override
    public void visit(PackageDeclaration n, Void arg) {
        translator.addPackage(n);
        super.visit(n, arg);
    }
}
