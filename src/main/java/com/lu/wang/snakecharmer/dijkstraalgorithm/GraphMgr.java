package com.lu.wang.snakecharmer.dijkstraalgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lu.wang.snakecharmer.data.Graph;
import com.lu.wang.snakecharmer.data.Node;
import com.lu.wang.snakecharmer.data.Path;

public class GraphMgr {
	private static final Logger log = LoggerFactory.getLogger(GraphMgr.class);
	/**
	 * Operator list
	 */
	private Graph graph;

	/**
	 * Constructor.
	 */
	public GraphMgr() {
		graph = new Graph();
	}

	public Graph init(int fromX, int fromY, int toX, int toY) {
		// Reorder from x,y and to x,y so they are in increase order.
		int x1 = fromX;
		int y1 = fromY;
		int x2 = toX;
		int y2 = toY;
		if (fromX > toX) {
			x1 = toX;
			x2 = fromX;
		}
		if (fromY > toY) {
			y1 = toY;
			y2 = fromY;
		}

		Hashtable<String, Node> nodes = initNodes(x1 - 1, y1 - 1, x2 + 1, y2 + 1);
		graph.setNodes(nodes);
		Collection<Path> paths = initPaths(nodes);
		graph.setPaths(paths);

		for (Node node : nodes.values()) {
			log.debug("Init node " + node.toString());
		}
		for (Path path : paths) {
			log.debug("Init path " + path.toString());
		}

		return graph;
	}

	private Hashtable<String, Node> initNodes(int fromX, int fromY, int toX, int toY) {
		Hashtable<String, Node> nodes = new Hashtable<String, Node>();
		for (int i = fromX; i <= toX; i++) {
			for (int j = fromY; j <= toY; j++) {
				nodes.put(getKey(i, j), new Node(i, j));
			}
		}
		return nodes;
	}

	private Collection<Path> initPaths(Hashtable<String, Node> nodes) {
		ArrayList<Path> paths = new ArrayList<Path>();
		for (Node node : nodes.values()) {
			int absX = Math.abs(node.getX());
			int absY = Math.abs(node.getY());
			if ((absX % 2 == 0 && absY % 2 == 0) || (absX % 2 == 1 && absY % 2 == 1)) {
				Node node1 = nodes.get(getKey(node.getX() + 1, node.getY()));
				if (node1 != null) {
					paths.add(new Path(node, node1));
				}
				Node node2 = nodes.get(getKey(node.getX() - 1, node.getY()));
				if (node2 != null) {
					paths.add(new Path(node, node2));
				}
			} else {
				Node node1 = nodes.get(getKey(node.getX(), node.getY() + 1));
				if (node1 != null) {
					paths.add(new Path(node, node1));
				}
				Node node2 = nodes.get(getKey(node.getX(), node.getY() - 1));
				if (node2 != null) {
					paths.add(new Path(node, node2));
				}
			}
		}
		return paths;
	}

	public static String getKey(int x, int y) {
		return "[" + x + "," + y + "]";
	}
}
