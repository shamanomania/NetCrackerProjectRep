package netcracker.viewsForms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static org.apache.commons.beanutils.locale.LocaleBeanUtils.getProperty;

/**
 * Created by Sid775 on 01.05.2017.
 */
public class FieldEqualsValidator implements ConstraintValidator<FieldEquals,Object> {

    private String field;
    private String equalsTo;
    private String message = FieldEquals.message;

    @Override
    public void initialize(FieldEquals constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.equalsTo = constraintAnnotation.equalsTo();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            final Object fieldObject = getProperty(value, field, null);
            final Object equalsToObject = getProperty(value, equalsTo, null);

            if (fieldObject == null && equalsToObject == null) {
                return true;
            }

            boolean matches = (fieldObject != null)
                    && fieldObject.equals(equalsToObject);

            if (!matches) {
                String msg = this.message;
                if( this.message == null
                        || "".equals( this.message )
                        || FieldEquals.message.equals( this.message ) ){
                    msg = field + " is not equal to " + equalsTo;
                }
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate( msg )
                        .addNode(equalsTo).addConstraintViolation();
            }

            return matches;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
