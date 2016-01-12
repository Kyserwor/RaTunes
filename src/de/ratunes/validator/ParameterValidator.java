package de.ratunes.validator;

import java.util.EmptyStackException;
import java.util.List;

public class ParameterValidator implements Validator{

	@Override
	public boolean validateString(String param) {
		boolean result = false;
		if(param != null){
			result = true;
		}
		return result;
	}

	public void validateList(List<String> params) {
		for (int index = 0; index < params.size(); index++) {
			if (validateString(params.get(index)) != true){
				throw new EmptyStackException();
			}
		}
	}

}
