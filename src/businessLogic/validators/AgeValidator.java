package businessLogic.validators;

import model.Client;

/**
 * @Author: Coblisan George
 *
 * @Since: 19.04.2021
 * @Source AgeValidator
 */

public class AgeValidator implements Validator<Client> {
    private static final int MIN_AGE = 7;
    private static final int MAX_AGE = 50;

    public void validate(Client t) {

        if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
            throw new IllegalArgumentException("The Student Age limit is not respected!");
        }

    }

}

