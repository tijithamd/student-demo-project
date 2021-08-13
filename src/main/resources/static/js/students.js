function isEmpty(field) {
			
	if(field.value.trim() == '') {
		return true;
	}
	return false;
}

function isDigit(charCode) {
	
	if(charCode >= 48 && charCode <= 57) {
		return true;
	}
	
	return false;
}

function isAlphabet(charCode) {
	
	if(    charCode == 32
	   || (charCode >= 65 && charCode <=90) 
	   || (charCode >= 97 && charCode <= 122)) 
	{
		return true;
	}
	
	return false;
}
