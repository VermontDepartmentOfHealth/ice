package org.cdsframework.cds.supportingdata;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cdsframework.ice.util.CollectionUtils;
import org.opencds.common.exceptions.ImproperUsageException;

public abstract class LocallyCodedCdsItem {

	private String cdsItemName;
	private Collection<String> cdsVersions;

	private static Log logger = LogFactory.getLog(LocallyCodedCdsItem.class);
	
	/**
	 * Creates a LocallyCodedCdsItem. Both the CdsItemName and CdsVersions must be specified, or an IllegalArgumentException is thrown.
	 */
	public LocallyCodedCdsItem(String pCdsItemName, Collection<String> pCdsVersions) 
		throws ImproperUsageException {
		
		String _METHODNAME = "LocallyCodedCdsItem(): ";
		
		if (pCdsItemName == null || pCdsItemName.isEmpty()) {
			String lErrStr = "CdsItem name not specified";
			logger.error(_METHODNAME + lErrStr);
			throw new IllegalArgumentException(lErrStr);
		}
		if (pCdsVersions == null || pCdsVersions.isEmpty()) {
			String lErrStr = "CdsVersion(s) not specified";
			logger.error(_METHODNAME + lErrStr);
			throw new ImproperUsageException(lErrStr);
		}
		
		this.cdsItemName = pCdsItemName;
		this.cdsVersions = pCdsVersions;
	}

	public String getCdsItemName() {
		return cdsItemName;
	}

	public Collection<String> getCdsVersions() {
		return cdsVersions;
	}

	/*
	 * Inclusion of cdsVersions in equality?
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdsItemName == null) ? 0 : cdsItemName.hashCode());
		for (String s : cdsVersions) {
			// Order does not matter
			result = prime * result + ((s == null) ? 0 : s.hashCode());
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocallyCodedCdsItem other = (LocallyCodedCdsItem) obj;
		if (cdsItemName == null) {
			if (other.cdsItemName != null)
				return false;
		} else if (!cdsItemName.equals(other.cdsItemName))
			return false;
		if (cdsVersions == null) {
			if (other.cdsVersions != null)
				return false;
		} 
		else { 
			Collection<String> lInter = CollectionUtils.intersectionOfStringCollections(cdsVersions, other.cdsVersions);
			if (lInter == null) {
				return false;
			}
			else if (cdsVersions.size() == lInter.size()) {
				// Each collection contains the same set of versions, though they could be in a different order
				return true;
			}
			else {
				return false;
			}
		}
		return true;
	}
	*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdsItemName == null) ? 0 : cdsItemName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocallyCodedCdsItem other = (LocallyCodedCdsItem) obj;
		if (cdsItemName == null) {
			if (other.cdsItemName != null)
				return false;
		} else if (!cdsItemName.equals(other.cdsItemName))
			return false;
		return true;
	}

}
