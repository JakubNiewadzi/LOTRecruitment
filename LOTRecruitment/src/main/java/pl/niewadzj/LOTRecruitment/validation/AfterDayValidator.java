package pl.niewadzj.LOTRecruitment.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.niewadzj.LOTRecruitment.validation.annotations.AfterDay;

import java.time.LocalDateTime;

public class AfterDayValidator implements ConstraintValidator<AfterDay, LocalDateTime> {
    @Override
    public boolean isValid(LocalDateTime localDateTime,
                           ConstraintValidatorContext constraintValidatorContext) {
        if (localDateTime == null) {
            return true;
        }

        LocalDateTime nextDay = localDateTime.plusDays(1);

        return localDateTime.isAfter(nextDay);
    }
}

