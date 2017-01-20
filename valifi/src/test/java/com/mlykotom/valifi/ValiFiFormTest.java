package com.mlykotom.valifi;

import com.mlykotom.valifi.fields.ValiFieldEmail;
import com.mlykotom.valifi.fields.ValiFieldEmailTest;
import com.mlykotom.valifi.fields.ValiFieldText;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ValiFiFormTest {
	private ValiFiForm mForm;


	@Before
	public void prepare() {
		ValiFi.install(null);
		mForm = new ValiFiForm();
	}


	@After
	public void clean() {
		mForm.destroy();
	}


	@Test
	public void checkFieldsValid() {
		ValiFieldText field1 = new ValiFieldText();
		field1.setEmptyAllowed(true);
		mForm.addField(field1);

		// TODO update, correct
		ValiFieldEmail field2 = new ValiFieldEmail(ValiFieldEmailTest.EMAIL_ADDRESS_VALID, ValiFieldEmailTest.EMAIL_ERROR_MSG);
		mForm.addField(field2);

		assertThat(mForm.getIsValid(), is(true));
	}
}
