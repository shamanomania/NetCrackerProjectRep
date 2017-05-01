package netcracker.viewsForms.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Sid775 on 01.05.2017.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldEqualsValidator.class)
public @interface FieldEquals {

        public static String message = "fields.noMatches";

        String message() default message;

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default  {};

        @Target(ElementType.TYPE)
        @Retention(RetentionPolicy.RUNTIME)
        @interface List {
                    FieldEquals[] value();
        }

        String field();

        String equalsTo();

}
