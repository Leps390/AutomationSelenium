package com.obsqura.utilities;

import org.openqa.selenium.WebElement;

public class GenericUtility {
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	public boolean checkBoxSelected(WebElement element) {
		boolean select = element.isSelected();
		return select;

	}
	
	

}
