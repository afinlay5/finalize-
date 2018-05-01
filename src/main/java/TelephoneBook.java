/*
Copyright (C) 2018 Adrian D. Finlay. All rights reserved.

Licensed under the MIT License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://opensource.org/licenses/MIT

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER INCLUDING AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
==============================================================================
**/

package src.main.java;

import java.util.Map;
import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;


class TelephoneBook {
	//Member Variables
	private java.io.PrintWriter record = null;
	private Map<String,String> contacts = new HashMap<>();
	//Provides minor advanatage over System.out in that it is Internationally 
	//friendly and better suited for writing Characters to the console.
	private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);

	//Constructor
	public TelephoneBook() throws IOException {

		var dir = System.getProperty("user.dir");
		//If TelephoneBook.txt exists, delete it.
		if (Files.deleteIfExists(Paths.get(dir + "/output/TelephoneBook.txt")) )
			out.println("Overwriting the file.");
		else
			out.println("Creating the file.");
		
        //Instantiate The Stream
		try { record = new java.io.PrintWriter(dir + "/output/TelephoneBook.txt"); }
		catch (IOException e) { 
			out.println("The attempt to create a Telephone Book failed."); 
			System.exit(0);
		}
	}

	@Override /*Overriding Finalize*/
	protected void finalize() {
		out.println("Finalize will close your stream for you....");
		if (record != null) record.close(); 
	}

	/*Utility Methods */

	//Write to the File
	void writeToFile() throws IOException {
		// The Pre-Java 8 Way --->
		// for (Map.Entry<String,Long> contact : contacts.entrySet()) 

		//Java 8+ Functional way of for-each over a Map, Java 11+ implicitly typed lambda formals with type-inference
		contacts.forEach( (var NA, var NM) -> {
			String EY = "\"" + NA + "\"" + ":\t+1-" + NM + "\n";
			record.write(EY);
		} );
	} 
	//Add Contacts
	void addContacts(Contact ... contacts) {
		for (var i=0; i<contacts.length; i++) {
			this.contacts.put(contacts[i].getName(), contacts[i].getNumber());
		}
	}
	//Print Map
	public void printMap() { out.println(contacts); };
}