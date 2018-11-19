package com.lu.wang.snakecharmer.travelalgorithm;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.lu.wang.snakecharmer.data.Node;
import com.lu.wang.snakecharmer.data.Node.Direction;

public class TravelAlgorithmTest {
	private TravelAlgorithm algorithm;
	private TravelNodeMgr travelMgr;
	private Node originNode;

	@Before
	public void setUp() throws Exception {
		algorithm = new TravelAlgorithm();
		travelMgr = new TravelNodeMgr();
		originNode = new Node(0, 0, Direction.NORTH);
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

			String result = algorithm.calcMovement(expectedNode);
			Node originNode = new Node(0, 0, Direction.NORTH);
			travelMgr.calcDestination(originNode, result);
			assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
		}
	}

	/**
	 * No movement. ([0,0] => [0,0])
	 */
	@Test
	public void noMove() {
		Node expectedNode = new Node(0, 0);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is north only
	 */
	@Test
	public void directNorth() {
		Node expectedNode = new Node(0, 10);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is south only
	 */
	@Test
	public void directSouth() {
		Node expectedNode = new Node(0, -10);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is west only
	 */
	@Test
	public void directWest() {
		Node expectedNode = new Node(-10, 0);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is east only
	 */
	@Test
	public void directEast() {
		Node expectedNode = new Node(10, 0);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is northwest
	 */
	@Test
	public void northwest() {
		Node expectedNode = new Node(-10, 10);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is northwest + north (odd movement)
	 */
	@Test
	public void northwestAndNorthOdd() {
		Node expectedNode = new Node(-1, 2);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is northwest + north (even movement)
	 */
	@Test
	public void northwestAndNorthEven() {
		Node expectedNode = new Node(-2, 4);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is northwest + west (odd movement)
	 */
	@Test
	public void northwestAndWestOdd() {
		Node expectedNode = new Node(-10, 1);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is northwest + west (even movement)
	 */
	@Test
	public void northwestAndWestEven() {
		Node expectedNode = new Node(-10, 4);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is northeast
	 */
	@Test
	public void northeast() {
		Node expectedNode = new Node(10, 10);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is northeast + north (odd movement)
	 */
	@Test
	public void northeastAndNorthOdd() {
		Node expectedNode = new Node(1, 2);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is northeast + north (even movement)
	 */
	@Test
	public void northeastAndNorthEven() {
		Node expectedNode = new Node(2, 4);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is northeast + east (odd movement)
	 */
	@Test
	public void northeastAndEastOdd() {
		Node expectedNode = new Node(10, 1);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is northeast + east (even movement)
	 */
	@Test
	public void northeastAndEastEven() {
		Node expectedNode = new Node(10, 4);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is southwest
	 */
	@Test
	public void southwest() {
		Node expectedNode = new Node(-10, -10);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is southwest + south (odd movement)
	 */
	@Test
	public void southwestAndSouthOdd() {
		Node expectedNode = new Node(-1, -2);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is southwest + south (even movement)
	 */
	@Test
	public void southwestAndSouthEven() {
		Node expectedNode = new Node(-2, -4);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is southwest + west (odd movement)
	 */
	@Test
	public void southwestAndWestOdd() {
		Node expectedNode = new Node(-10, -5);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is southwest + west (even movement)
	 */
	@Test
	public void southwestAndWestEven() {
		Node expectedNode = new Node(-10, -4);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is southeast
	 */
	@Test
	public void southeast() {
		Node expectedNode = new Node(10, -10);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is southeast + south (odd movement)
	 */
	@Test
	public void southeastAndSouthOdd() {
		Node expectedNode = new Node(1, -2);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is southeast + south (even movement)
	 */
	@Test
	public void southeastAndSouthEven() {
		Node expectedNode = new Node(2, -4);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is southeast + east (odd movement)
	 */
	@Test
	public void southeastAndEastOdd() {
		Node expectedNode = new Node(10, -5);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}

	/**
	 * Destination is southeast + east (even movement)
	 */
	@Test
	public void southeastAndEastEven() {
		Node expectedNode = new Node(10, -4);

		String result = algorithm.calcMovement(expectedNode);
		travelMgr.calcDestination(originNode, result);
		assertTrue("[0,0,NORTH]+" + result + "=" + expectedNode.toString(), expectedNode.equals(originNode, false));
	}
}
