package org.codesolt.util;

import org.stringtemplate.v4.ST;

public class StringTemplateCase {

	public static void main(String[] args) {
		ST template = new ST("String template example for <value>");
		template.add("value", "Codesolt");
		String output = template.render().toString();
		System.out.println(output);
	}
}
