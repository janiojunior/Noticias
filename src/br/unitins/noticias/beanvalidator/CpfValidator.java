package br.unitins.noticias.beanvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<Cpf, String> {
	private Pattern pattern = Pattern.compile("([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})");

	/**
	 * Este método é chamado na fase 2 ou 3 do ciclo de vida do jsf
	 */
	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
		// Permitir valor nulo
		if (cpf == null) 
			return true;
		// Expressao regular (regex)
		Matcher m = pattern.matcher(cpf);
	    return m.matches();
	}
}