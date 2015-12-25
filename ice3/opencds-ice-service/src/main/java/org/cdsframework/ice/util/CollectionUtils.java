package org.cdsframework.ice.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CollectionUtils {


	public static <K> boolean isNotSpecified(Collection<K> pCollection) {
		
		if (pCollection == null || pCollection.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	

	/**
	 * Return a Collection that contains String arguments in all of the collections, or an empty set if there is no intersection of common elements.
	 * @param pCollection
	 * @return
	 */
	@SafeVarargs
	public static Collection<String> intersectionOfStringCollections(Collection<String> ... pCollection) {

		if (pCollection == null || pCollection.length == 0 || pCollection.length == 1) {
			return pCollection[0];
		}

		HashSet<String> lIntersectionSet = new HashSet<String>();
		lIntersectionSet.addAll(pCollection[0]);
		for (Collection<String> lCollection : pCollection) {
			lIntersectionSet.retainAll(lCollection);
		}

		return lIntersectionSet;
	}


	/**
	 * Create a List that combines elements from both Lists and returns a new List in no particular order containing entries from both Lists. Duplicates
	 * across the lists will be included in the combined list but null entries are not. If the specified Lists are both empty and/or null, an empty list 
	 * is returned.
	 */
	public static <K> List<K> unionOfTwoCollections(Collection<K> pCollection1, Collection<K> pCollection2) {

		if (pCollection1 == null && pCollection2 == null) {
			return null;
		}

		List<K> lUnion = new ArrayList<K>();
		if (pCollection1 != null) {
			for (K lEntry : pCollection1) {
				if (lEntry != null)
					lUnion.add(lEntry);
			}
		}
		if (pCollection2 != null) {
			for (K lEntry : pCollection2) {
				if (lEntry != null)
					lUnion.add(lEntry);
			}
		}

		return lUnion;
	}

}
