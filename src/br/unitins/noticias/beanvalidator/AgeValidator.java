package br.unitins.noticias.beanvalidator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Date> {
	protected long minAge;

	@Override
	public void initialize(Age ageValue) {
		this.minAge = ageValue.value();
	}

	/**
	 * Este método é chamado na fase 2 ou 3 do ciclo de vida do jsf
	 */
	@Override
	public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
		// Permitir valor nulo
		if (date == null) {
			return true;
		}
		LocalDate today = LocalDate.now();
		LocalDate date2 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		// retorna true caso a quatidade de anos (calculada) for maior ou igual a idade
		// mínima definida na anotacao
		return ChronoUnit.YEARS.between(date2, today) >= minAge;
	}
}