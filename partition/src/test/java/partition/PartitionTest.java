package partition;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PartitionTest {
	private List<Integer> inputlist;
	private List<List<Integer>> result;
	int length = 0;

	@Before
	public void init() {
		inputlist = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
	}

	@After
	public void clearList() {
		inputlist.clear();
	}

	@Test
	public void partitionShouldReturnResultTestOne() {
		length = 2;
		result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
		result.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
		result.add(new ArrayList<Integer>(Arrays.asList(5)));
		assertEquals("partition result must be equals to [[1,2],[3,4],[5]", result,
				Partition.partition(inputlist, length));
	}
	
	@Test
	public void partitionShouldReturnResultTestTwo() {
		length = 3;
		result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
		result.add(new ArrayList<Integer>(Arrays.asList(4, 5)));
		assertEquals("partition result must be equals to [[1,2,3],[4,5]]", result,
				Partition.partition(inputlist, length));
	}
	
	@Test
	public void partitionShouldReturnResultTestThree() {
		length = 1;
		result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>(Arrays.asList(1)));
		result.add(new ArrayList<Integer>(Arrays.asList(2)));
		result.add(new ArrayList<Integer>(Arrays.asList(3)));
		result.add(new ArrayList<Integer>(Arrays.asList(4)));
		result.add(new ArrayList<Integer>(Arrays.asList(5)));
		assertEquals("partition result must be equals to [[1],[2],[3],[4],[5]]", result,
				Partition.partition(inputlist, length));
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void partitionShoulThrowIllegalArgumentExceptionListEmpty() {
		Partition.partition(new ArrayList<Integer>(), length);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void partitionShoulThrowIllegalArgumentExceptionLengthZero() {
		length = 0;
		Partition.partition(inputlist, length);
	}
}
