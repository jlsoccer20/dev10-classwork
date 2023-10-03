package learn.powerball.models;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Reservation {

    public Result<Reservation> add(Reservation reservation) throws DataException {

        Result<Reservation> result = new Result<>();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // No explicit validation rules.
        // The validate method is not longer needed.
        // Rules are encoded as constraint annotations.
        Set<ConstraintViolation<Reservation>> violations = validator.validate(reservation);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Reservation> violation : violations) {
                result.addErrorMessage(violation.getMessage();
            }
            return result;
        }

        reservation.calculateTotal();
        result.setPayload(reservationRepository.add(reservation));
        return result;
    }

}
