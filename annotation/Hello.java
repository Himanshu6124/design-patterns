package annotation;

import java.io.IOException;
import java.io.Writer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
 @interface GenerateHello {
    String value();
}




@SupportedAnnotationTypes("com.example.GenerateHello")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
class HelloProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment roundEnv) {

        for (Element element : roundEnv.getElementsAnnotatedWith(GenerateHello.class)) {

            String className = element.getSimpleName().toString();
            GenerateHello annotation = element.getAnnotation(GenerateHello.class);

            String message = annotation.value();

            generateClass(className, message);
        }

        return true;
    }

    private void generateClass(String className, String message) {
        try {
            String newClassName = "Hello_" + className;

            JavaFileObject file = processingEnv.getFiler()
                    .createSourceFile(newClassName);

            try (Writer writer = file.openWriter()) {
                writer.write(
                        "public class " + newClassName + " {\n" +
                                "   public static void sayHello() {\n" +
                                "       System.out.println(\"" + message + "\");\n" +
                                "   }\n" +
                                "}"
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}