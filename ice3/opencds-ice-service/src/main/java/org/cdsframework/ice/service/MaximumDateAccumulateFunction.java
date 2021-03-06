/**
 * Copyright (C) 2019 New York City Department of Health and Mental Hygiene, Bureau of Immunization
 * Contributions by HLN Consulting, LLC
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version. You should have received a copy of the GNU Lesser
 * General Public License along with this program. If not, see <http://www.gnu.org/licenses/> for more
 * details.
 *
 * The above-named contributors (HLN Consulting, LLC) are also licensed by the New York City
 * Department of Health and Mental Hygiene, Bureau of Immunization to have (without restriction,
 * limitation, and warranty) complete irrevocable access and rights to this project.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; THE
 *
 * SOFTWARE IS PROVIDED "AS IS" WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING,
 * BUT NOT LIMITED TO, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE COPYRIGHT HOLDERS, IF ANY, OR DEVELOPERS BE LIABLE FOR
 * ANY CLAIM, DAMAGES, OR OTHER LIABILITY OF ANY KIND, ARISING FROM, OUT OF, OR IN CONNECTION WITH
 * THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information about this software, see http://www.hln.com/ice or send
 * correspondence to ice@hln.com.
 */

package org.cdsframework.ice.service;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.drools.runtime.rule.AccumulateFunction;

// import org.kie.api.runtime.rule.AccumulateFunction;

public class MaximumDateAccumulateFunction implements AccumulateFunction  { // , org.kie.api.runtime.rule.AccumulateFunction {
// public class MaximumDateAccumulateFunction implements TypedAccumulateFunction {

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}
	
	 public static class DateAccumulationData implements Externalizable {
		 public List<Date> list = new ArrayList<Date>();
	     
		 public DateAccumulationData() {}

		 public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		 
		 }


		 public void writeExternal(ObjectOutput out) throws IOException {
		 }
	 }


	@Override
	public void accumulate(Serializable context, Object pDateAccumulationElement) {
		DateAccumulationData data = (DateAccumulationData) context;
	    data.list.add((Date) pDateAccumulationElement);
	}

	@Override
	public Serializable createContext() {
		return new DateAccumulationData();
	}

	@Override
	public void init(Serializable context) throws Exception {
		DateAccumulationData data = (DateAccumulationData) context;
	    data.list.clear();
	}

	
	@Override
	public void reverse(Serializable context, Object value) throws Exception {
		DateAccumulationData data = (DateAccumulationData) context;
	    data.list.remove( value );
	}

	@Override
	public boolean supportsReverse() {
		return true;
	}
	
	public Object getResult(Serializable context) throws Exception {
		DateAccumulationData data = (DateAccumulationData) context;
		if (data.list == null) {
			// return new ArrayList<Object>();
			return null;
		}
		Date maxDate = null;
		for (Date d : data.list) {
			if (maxDate == null) {
				maxDate = d;
			}
			else if (d != null && d.after(maxDate)) {
				maxDate = d;
			}
		}

		return maxDate;
	}
	
	/*
	public Class<?> getResultType() {
		
		try {
			return Date.class;
		}
		catch (Exception e) {
			throw new RuntimeException();
		}
		// return new Class<Object>();
	}
	*/
}
