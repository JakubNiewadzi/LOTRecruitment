package pl.niewadzj.LOTRecruitment.validation.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pl.niewadzj.LOTRecruitment.validation.AfterDayValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AfterDayValidator.class)
public @interface AfterDay {
    String message() default "Flights must start at least 24 hours after creation time";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
