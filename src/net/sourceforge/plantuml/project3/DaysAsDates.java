/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
 * 
 * If you like this project or if you find it useful, you can support us at:
 * 
 * http://plantuml.com/patreon (only 1$ per month!)
 * http://plantuml.com/paypal
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 * 
 *
 */
package net.sourceforge.plantuml.project3;

import java.util.Iterator;

public class DaysAsDates implements Subject, Complement, Iterable<DayAsDate> {

	private final DayAsDate date1;
	private final DayAsDate date2;

	public DaysAsDates(DayAsDate date1, DayAsDate date2) {
		this.date1 = date1;
		this.date2 = date2;
	}

	class MyIterator implements Iterator<DayAsDate> {

		private DayAsDate current;

		public MyIterator(DayAsDate current) {
			this.current = current;
		}

		public boolean hasNext() {
			return current.compareTo(date2) <= 0;
		}

		public DayAsDate next() {
			final DayAsDate result = current;
			current = current.next();
			return result;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	public Iterator<DayAsDate> iterator() {
		return new MyIterator(date1);
	}

}
