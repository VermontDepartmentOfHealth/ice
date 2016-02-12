/**
 * Copyright (C) 2016 New York City Department of Health and Mental Hygiene, Bureau of Immunization
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

package org.cdsframework.ice.supportingdatatmp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opencds.vmr.v1_0.internal.datatypes.CD;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//This class will be replaced for dynamic import of Supporting Data in a specified format generated by the Rule Authoring Tool         // 
//(e.g. - CAT). See opencds-ice-service-data/src/main/resources/ice-supporting-data/                                                   //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public enum SupportedPersonConcept {
	
	_GENDER_MALE("C30", "Male", "2.16.840.1.113883.5.1", "Gender", "M", "Male"),
	_GENDER_FEMALE("C31", "Female", "2.16.840.1.113883.5.1", "Gender", "F", "Female");
	
	private CD supportedPersonConcept;
	private CD localVaccineCodeConcept;

	private static Log logger = LogFactory.getLog(SupportedPersonConcept.class);
	
	
	private SupportedPersonConcept(String pConceptCodeValue, String pConceptDisplayNameValue) {
		supportedPersonConcept = new CD();
		localVaccineCodeConcept = new CD();
		supportedPersonConcept.setCode(pConceptCodeValue);
		supportedPersonConcept.setDisplayName(pConceptDisplayNameValue);
	}
	
	private SupportedPersonConcept(String pConceptCodeValue, String pConceptDisplayNameValue, String pLocalCodeSystem, String pLocalCodeSystemName, String pLocalCodeValue, 
			String pLocalCodeDisplayNameValue) {
		supportedPersonConcept = new CD();
		localVaccineCodeConcept = new CD();
		supportedPersonConcept.setCode(pConceptCodeValue);
		supportedPersonConcept.setDisplayName(pConceptDisplayNameValue);
		localVaccineCodeConcept.setCodeSystem(pLocalCodeSystem);
		localVaccineCodeConcept.setCodeSystemName(pLocalCodeSystemName);
		localVaccineCodeConcept.setCode(pLocalCodeValue);
		localVaccineCodeConcept.setDisplayName(pLocalCodeDisplayNameValue);
	}
	
	public static SupportedPersonConcept getsupportedPersonConceptByConceptCode(String conceptCode) {

		if (conceptCode == null) {
			return null;
		}
		for (SupportedPersonConcept vc : SupportedPersonConcept.values()) {
			if (conceptCode.equals(vc.getConceptCodeValue())) {
				return vc;
			}
		}
		
		return null;
	}
	
	public static SupportedPersonConcept getSupportedConceptByConceptCodeValue(String conceptCodeValue) {
		
		try {
			SupportedPersonConcept svc = SupportedPersonConcept.valueOf(conceptCodeValue);
			return svc;
		}
		catch (IllegalArgumentException iea) {
			String errStr = "No supportedPersonConcepts exists for the supplied conceptCodeValue";
			logger.error(errStr);
			throw iea;
		}
	}
	
	public CD getConcept() {
		return supportedPersonConcept;
	}
	
	public String getConceptCodeValue() {
		return supportedPersonConcept.getCode();
	}
	
	public String getConceptDisplayNameValue() {
		return supportedPersonConcept.getDisplayName();
	}
	
	public CD getLocalCodeConcept() {
		return localVaccineCodeConcept;
	}
	
	public String getLocalCodeSystem() {
		return localVaccineCodeConcept.getCodeSystem();
	}
	
	public String getLocalCodeSystemName() {
		return localVaccineCodeConcept.getCodeSystemName();
	}
	
	public String getLocalCodeValue() {
		return localVaccineCodeConcept.getCode();
	}
	
	public String getLocalCodeDisplayName() {
		return localVaccineCodeConcept.getDisplayName();
	}
}
