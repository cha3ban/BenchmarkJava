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

@WebServlet("/BenchmarkTest13586")
public class BenchmarkTest13586 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		// FILE URIs are tricky because they are different between Mac and Windows because of lack of standardization.
		// Mac requires an extra slash for some reason.
		String startURIslashes = "";
        if (System.getProperty("os.name").indexOf("Windows") != -1)
	        if (System.getProperty("os.name").indexOf("Windows") != -1)
	        	startURIslashes = "/";
	        else startURIslashes = "//";

		try {
			java.net.URI fileURI = new java.net.URI("file", null, startURIslashes 
				+ org.owasp.benchmark.helpers.Utils.testfileDir.replace('\\', java.io.File.separatorChar).replace(' ', '_') + bar, null, null);
			new java.io.File(fileURI);
		} catch (java.net.URISyntaxException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a1748 = param; //assign
		StringBuilder b1748 = new StringBuilder(a1748);  // stick in stringbuilder
		b1748.append(" SafeStuff"); // append some safe content
		b1748.replace(b1748.length()-"Chars".length(),b1748.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1748 = new java.util.HashMap<String,Object>();
		map1748.put("key1748", b1748.toString()); // put in a collection
		String c1748 = (String)map1748.get("key1748"); // get it back out
		String d1748 = c1748.substring(0,c1748.length()-1); // extract most of it
		String e1748 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1748.getBytes() ) )); // B64 encode and decode it
		String f1748 = e1748.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g1748 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g1748); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
