package com.lu.wang.snakecharmer.travelalgorithm;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lu.wang.snakecharmer.data.Node;
import com.lu.wang.snakecharmer.data.Node.Direction;
import com.lu.wang.snakecharmer.data.TravelPath.Move;

public class TravelNodeMgrTest {

	/**
	 * Simple test case from given sample input
	 */
	@Test
	public void simple() {
		TravelNodeMgr mgr = new TravelNodeMgr();
		Node node = new Node(0, 0, Direction.NORTH);
		mgr.calcDestination(node, "RLLRL");
		assertEquals("Snake moves to x", -1, node.getX());
		assertEquals("Snake moves to y", 2, node.getY());
	}

	/**
	 * North moves to left
	 */
	@Test
	public void northLeft() {
		Move move = Move.L;
		Node node = new Node(0, 0, Direction.NORTH);
		Node expectedNode = new Node(-1, 0, Direction.WEST);

		TravelNodeMgr mgr = new TravelNodeMgr();
		mgr.calcDestination(node, move);
		assertTrue("Snake at " + node.toString() + " moves to " + move.toString() + " = " + expectedNode.toString(),
				expectedNode.equals(node));
	}

	/**
	 * North moves to right
	 */
	@Test
	public void northRight() {
		Move move = Move.R;
		Node node = new Node(0, 0, Direction.NORTH);
		Node expectedNode = new Node(1, 0, Direction.EAST);

		TravelNodeMgr mgr = new TravelNodeMgr();
		mgr.calcDestination(node, move);
		assertTrue("Snake at " + node.toString() + " moves to " + move.toString() + " = " + expectedNode.toString(),
				expectedNode.equals(node));
	}

	/**
	 * South moves to left
	 */
	@Test
	public void southLeft() {
		Move move = Move.L;
		Node node = new Node(0, 0, Direction.SOUTH);
		Node expectedNode = new Node(1, 0, Direction.EAST);

		TravelNodeMgr mgr = new TravelNodeMgr();
		mgr.calcDestination(node, move);
		assertTrue("Snake at " + node.toString() + " moves to " + move.toString() + " = " + expectedNode.toString(),
				expectedNode.equals(node));
	}

	/**
	 * South moves to right
	 */
	@Test
	public void southRight() {
		Move move = Move.R;
		Node node = new Node(0, 0, Direction.SOUTH);
		Node expectedNode = new Node(-1, 0, Direction.WEST);

		TravelNodeMgr mgr = new TravelNodeMgr();
		mgr.calcDestination(node, move);
		assertTrue("Snake at " + node.toString() + " moves to " + move.toString() + " = " + expectedNode.toString(),
				expectedNode.equals(node));
	}

	/**
	 * West moves to left
	 */
	@Test
	public void westLeft() {
		Move move = Move.L;
		Node node = new Node(0, 0, Direction.WEST);
		Node expectedNode = new Node(0, -1, Direction.SOUTH);

		TravelNodeMgr mgr = new TravelNodeMgr();
		mgr.calcDestination(node, move);
		assertTrue("Snake at " + node.toString() + " moves to " + move.toString() + " = " + expectedNode.toString(),
				expectedNode.equals(node));
	}

	/**
	 * West moves to right
	 */
	@Test
	public void westRight() {
		Move move = Move.R;
		Node node = new Node(0, 0, Direction.WEST);
		Node expectedNode = new Node(0, 1, Direction.NORTH);

		TravelNodeMgr mgr = new TravelNodeMgr();
		mgr.calcDestination(node, move);
		assertTrue("Snake at " + node.toString() + " moves to " + move.toString() + " = " + expectedNode.toString(),
				expectedNode.equals(node));
	}

	/**
	 * East moves to left
	 */
	@Test
	public void eastLeft() {
		Move move = Move.L;
		Node node = new Node(0, 0, Direction.EAST);
		Node expectedNode = new Node(0, 1, Direction.NORTH);

		TravelNodeMgr mgr = new TravelNodeMgr();
		mgr.calcDestination(node, move);
		assertTrue("Snake at " + node.toString() + " moves to " + move.toString() + " = " + expectedNode.toString(),
				expectedNode.equals(node));
	}

	/**
	 * East moves to right
	 */
	@Test
	public void eastRight() {
		Move move = Move.R;
		Node node = new Node(0, 0, Direction.EAST);
		Node expectedNode = new Node(0, -1, Direction.SOUTH);

		TravelNodeMgr mgr = new TravelNodeMgr();
		mgr.calcDestination(node, move);
		assertTrue("Snake at " + node.toString() + " moves to " + move.toString() + " = " + expectedNode.toString(),
				expectedNode.equals(node));
	}
}
