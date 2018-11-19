package com.lu.wang.snakecharmer;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.lu.wang.snakecharmer.data.Node;
import com.lu.wang.snakecharmer.data.Node.Direction;
import com.lu.wang.snakecharmer.dijkstraalgorithm.DijkstraAlgorithm;
import com.lu.wang.snakecharmer.travelalgorithm.TravelAlgorithm;
import com.lu.wang.snakecharmer.travelalgorithm.TravelNodeMgr;

public class TravelAlgorithmTest {
	private TravelAlgorithm travelAlgorithm;
	private DijkstraAlgorithm dijkstraAlgorithm;
	private TravelNodeMgr travelMgr;

	@Before
	public void setUp() throws Exception {
		travelAlgorithm = new TravelAlgorithm();
		dijkstraAlgorithm = new DijkstraAlgorithm();
		travelMgr = new TravelNodeMgr();
	}

	/**
	 * Destination is random from -100 to 100. And test it for 20 times.
	 */
	@Test
	public void random() {
		int min = -100;
		int max = 100;
		int range = max - min;

		Random random = new Random();

		for (int i = 0; i < 20; i++) {
			Node expectedNode = new Node(min + random.nextInt(range), min + random.nextInt(range));

			// verify result from travel algorithm
			String result1 = travelAlgorithm.calcMovement(expectedNode);
			Node originNode1 = new Node(0, 0, Direction.NORTH);
			travelMgr.calcDestination(originNode1, result1);
			assertTrue("[0,0,NORTH]+" + result1 + "=" + expectedNode.toString(),
					expectedNode.equals(originNode1, false));

			// verify result from dijkstra algorithm
			String result2 = dijkstraAlgorithm.calcMovement(expectedNode);
			Node originNode2 = new Node(0, 0, Direction.NORTH);
			travelMgr.calcDestination(originNode2, result2);
			assertTrue("[0,0,NORTH]+" + result2 + "=" + expectedNode.toString(),
					expectedNode.equals(originNode2, false));

			// make sure the total movement on both algorithm is same.
			assertEquals("Total movement", result2.length(), result1.length());
		}
	}
}
