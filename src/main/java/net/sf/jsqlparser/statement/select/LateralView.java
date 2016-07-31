/*
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2016 JSQLParser
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

import net.sf.jsqlparser.expression.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * add for pike sql
 */
public class LateralView {
    private Function _function;
    public void setFunction(Function func) {
        this._function = func;
    }
    public Function getFunction() {
        return this._function;
    }

    private String _tableAlias;
    public void setTableAlias(String alias) {
        this._tableAlias = alias;
    }
    public String getTableAlias() {
        return this._tableAlias;
    }

    List<String> _columnAliases;
    public void setColumnAliases(List<String> cols) {
        this._columnAliases = new ArrayList<String>(cols);
    }
    public List<String> getColumnAliases() {
        return new ArrayList<String>(this._columnAliases);
    }

    public String toString() {
        String s = String.format("Lateral View %s %s As )", this._function, this._tableAlias);
        int n = 0;
        for(String col : this._columnAliases) {
            if (n > 0) s += ", ";
            s += col;
            n += 1;
        }
        return s;
    }
}
