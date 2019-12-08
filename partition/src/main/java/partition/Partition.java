package partition;

import java.util.ArrayList;
import java.util.List;

public class Partition {

	private Partition() {
		// Throw an exception if this ever *is* called
		throw new IllegalStateException("Utility class");
	}

	public static List<List<Integer>> partition(List<Integer> list, int length) {

		List<List<Integer>> containerList = new ArrayList<List<Integer>>();

		if (!list.isEmpty() && length != 0) {

			int size = list.size();
			int count = 0;
			int start = 0;
			int end = 0;

			while (end < size) {
				start = count * length;
				end = Math.min(start + length, size);
				containerList.add(new ArrayList<Integer>(list.subList(start, end)));
				count++;
			}
		} else {
			throw new IllegalArgumentException("list empty or length = 0");
		}

		return containerList;
	}

}
