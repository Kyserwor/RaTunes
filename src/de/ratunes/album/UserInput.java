package de.ratunes.album;

public class UserInput {
	public boolean checkRequestParameter(String par1, String par2, String par3, String par4){
		boolean result = false;
		if (par1 != null && par2 != null && par3 != null && par4 != null){
			result = true;
		}
		return result;
	}
}
