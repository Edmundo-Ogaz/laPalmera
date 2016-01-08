package cl.obam.pasteleria.lapalmera.util;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class CollectionUtil {

	public static List checkNull(List list) {
		
		return list == null ? Collections.EMPTY_LIST : list;
	}

	public static <T> Set<T> checkNull(Set<T> set) {
		
		return set == null ? Collections.EMPTY_SET : set;
	}
	
	public static <T> void printArray(T[] inputArray) {
		for(T element : inputArray) {
			
		}
	}
}