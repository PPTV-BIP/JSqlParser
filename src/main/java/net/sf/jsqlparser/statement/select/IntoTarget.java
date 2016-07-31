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

import net.sf.jsqlparser.schema.Table;

/**
 *add for pike sql
 */
public class IntoTarget {
    private Table target;
    private Period outputPeriod;

    public IntoTarget(Table target) {
        this.target = target;
    }

    public void setOutputPeriod(Period outputPeriod) {
        this.outputPeriod = outputPeriod;
    }

    public Table getTarget() {
        return this.target;
    }

    public Period getOutputPeriod() {
        return this.outputPeriod;
    }

    public String toString(){
        String tmp = this.target.toString();
        if(this.outputPeriod != null){
            tmp += " EVERY " + this.outputPeriod;
        }
        return tmp + " ";
    }
}
