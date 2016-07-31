/*
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2013 JSQLParser
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 2.1 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */
package net.sf.jsqlparser.statement.select;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;

public class Select implements Statement {

	private SelectBody selectBody;
	private List<WithItem> withItemsList;
	private Period period;
	private Map<String, Object> optionItems;

	@Override
	public void accept(StatementVisitor statementVisitor) {
		statementVisitor.visit(this);
	}

	public SelectBody getSelectBody() {
		return selectBody;
	}

	public void setSelectBody(SelectBody body) {
		selectBody = body;
	}

	@Override
	public String toString() {
		StringBuilder retval = new StringBuilder();
		if (optionItems != null) {
			for(Map.Entry<String, Object> entry : optionItems.entrySet()){
				retval.append("set " + entry.getKey());
				retval.append("=");
				retval.append(entry.getValue().toString() + "; ");
			}
		}

		if (period != null) {
			retval.append(period.toString());
		}

		if (withItemsList != null && !withItemsList.isEmpty()) {
			retval.append("WITH ");
			for (Iterator<WithItem> iter = withItemsList.iterator(); iter.hasNext();) {
				WithItem withItem = (WithItem) iter.next();
				retval.append(withItem);
				if (iter.hasNext()) {
					retval.append(",");
				}
				retval.append(" ");
			}
		}
		retval.append(selectBody);
		return retval.toString();
	}

	public List<WithItem> getWithItemsList() {
		return withItemsList;
	}

	public void setWithItemsList(List<WithItem> withItemsList) {
		this.withItemsList = withItemsList;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Map<String, Object> getOptionItems() {
		return optionItems;
	}

	public void setOptionItems(Map<String, Object> optionItems) {
		this.optionItems = optionItems;
	}
}
