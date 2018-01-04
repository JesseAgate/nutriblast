package com.nutriblast;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.print.*;
import java.io.IOException;

/**
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: -
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer. - Redistributions in binary
 * form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided
 * with the distribution. - Neither the name of Oracle or the names of its
 * contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * This class prints out the high scores
 * <p>
 * Time spent: 1.5 hours
 * </p>
 * <p>
 * <b>Version 1</b> <br>
 * - Created Class
 * </p>
 * 
 * @author Oracle, Modified by Jesse
 * @version Final 6/6/2015
 */
public class PrintHighScores implements Printable {
	
	
	/**
	 * Prints the high scores
	 * 
	 * @param g
	 *            A graphics Object
	 * @param pf
	 *            A PageFormatObject
	 * @param page
	 *            An int
	 * @throws PrinterException
	 */
	public int print(Graphics g, PageFormat pf, int page)
			throws PrinterException {
		if (page > 0) {
			return NO_SUCH_PAGE;
		}
		String[] names = { "Bob", "Billi Bob", "Zangherion",
				"MMMMMMMMMMMMMMMMMMMMM", "jesse", "Griffonator", "yes man" };
		String[] scores = { "1:00", "2:00", "10:25", "1:23", "3:21", "1:32",
				"66:06" };
		Graphics2D g2 = (Graphics2D) g;
		g2.translate(pf.getImageableX(), pf.getImageableY());
		g2.setFont(new Font("Corbel", Font.BOLD, 26));
		g2.drawString("Level 1", 250, 50);
		g2.drawString("Rank", 50, 100);
		g2.drawString("Name", 150, 100);
		g2.drawString("Score", 450, 100);
		g2.setFont(new Font("Corbel", Font.PLAIN, 16));
		for (int i = 0; i < 10; i++) {
			g2.drawString(Integer.toString(i + 1), 65, 150 + (i * 50));
			if (i < names.length) {
				g2.drawString(names[i], 150, 150 + (i * 50));
				g2.drawString(scores[i], 470, 150 + (i * 50));
			}
		}
		g2.setFont(new Font("Corbel", Font.ITALIC, 13));
		g2.drawString("@Isocehedron Entertainment", 65, 735);
		 g2.drawImage(ImageData.getImage(ImageData.COMPANY_LOGO),480,700,null);

		/* tell the caller that this page is part of the printed document */
		return PAGE_EXISTS;
	}

	public static void sendToPrinter() {
		PrinterJob job = PrinterJob.getPrinterJob();
		Printable p = new PrintHighScores();
		job.setPrintable(p);
		boolean ok = job.printDialog();
		if (ok) {
			try {
				job.print();
			} catch (PrinterException ex) {
				/* The job did not successfully complete */
			}
		}
	}
}
