/**
* OWASP Benchmark Project v1.1
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07348")
public class BenchmarkTest07348 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}

		String bar = new Test().doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a78625 = param; //assign
		StringBuilder b78625 = new StringBuilder(a78625);  // stick in stringbuilder
		b78625.append(" SafeStuff"); // append some safe content
		b78625.replace(b78625.length()-"Chars".length(),b78625.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map78625 = new java.util.HashMap<String,Object>();
		map78625.put("key78625", b78625.toString()); // put in a collection
		String c78625 = (String)map78625.get("key78625"); // get it back out
		String d78625 = c78625.substring(0,c78625.length()-1); // extract most of it
		String e78625 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d78625.getBytes() ) )); // B64 encode and decode it
		String f78625 = e78625.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g78625 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g78625); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
