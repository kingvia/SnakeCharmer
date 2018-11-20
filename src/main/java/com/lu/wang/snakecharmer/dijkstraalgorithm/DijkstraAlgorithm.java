package com.lu.wang.snakecharmer.dijkstraalgorithm;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lu.wang.snakecharmer.data.Graph;
import com.lu.wang.snakecharmer.data.Node;
import com.lu.wang.snakecharmer.data.Node.Direction;
import com.lu.wang.snakecharmer.data.Path;
import com.lu.wang.snakecharmer.data.TravelPath;
import com.lu.wang.snakecharmer.data.TravelPath.Move;
import com.lu.wang.snakecharmer.movementinterface.MovementInterface;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm implements MovementInterface {
	private static final Logger log = LoggerFactory.getLogger(DijkstraAlgorithm.class);

	private final int WEIGHT = 1;

	private Hashtable<String, Node> nodes;
	private List<Path> paths;
	private Set<Node> settledNodes;
	private Set<Node> unSettledNodes;
	private Map<Node, TravelPath> predecessors;
	private Map<Node, Integer> distance;

	/**
	 * Constructor
	 */
	public DijkstraAlgorithm() {
	}

	/**
	 * Run Dijkstra Algorithm to find all shortest path on all nodes.
	 */
	public void init() {
		// always from [0,0], facing north
		Node source = nodes.get(GraphMgr.getKey(0, 0));
		source.setDirection(Direction.NORTH);

		settledNodes = new HashSet<Node>();
		unSettledNodes = new HashSet<Node>();
		distance = new HashMap<Node, Integer>();
		predecessors = new HashMap<Node, TravelPath>();
		distance.put(source, 0);
		unSettledNodes.add(source);

		while (unSettledNodes.size() > 0) {
			Node node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node);
		}
	}

	/**
	 * Find the minimal distance from source of all neighbors of specified nodes.
	 * @param node node
	 */
	private void findMinimalDistances(Node node) {
		for (Node target : getNeighbors(node)) {
			if (getShortestDistance(target) > getShortestDistance(node) + WEIGHT) {
				distance.put(target, getShortestDistance(node) + WEIGHT);
				predecessors.put(target, getPath(node, target));
				unSettledNodes.add(target);
			}
		}
	}

	/**
	 * Find the travel path from source node to destination node. Also updating
	 * destination node with correct direction.
	 * 
	 * @param source      source node
	 * @param destination destination node
	 * @return Find the travel path from source node to destination node.
	 */
	private TravelPath getPath(Node source, Node destination) {
		Move move = null;
		switch (source.getDirection()) {
		case NORTH:
			if (destination.getX() > source.getX()) {
				move = Move.R;
				destination.setDirection(Direction.EAST);
			} else {
				move = Move.L;
				destination.setDirection(Direction.WEST);
			}
			break;
		case SOUTH:
			if (destination.getX() < source.getX()) {
				move = Move.R;
				destination.setDirection(Direction.WEST);
			} else {
				move = Move.L;
				destination.setDirection(Direction.EAST);
			}
			break;
		case WEST:
			if (destination.getY() > source.getY()) {
				move = Move.R;
				destination.setDirection(Direction.NORTH);
			} else {
				move = Move.L;
				destination.setDirection(Direction.SOUTH);
			}
			break;
		case EAST:
			if (destination.getY() < source.getY()) {
				move = Move.R;
				destination.setDirection(Direction.SOUTH);
			} else {
				move = Move.L;
				destination.setDirection(Direction.NORTH);
			}
			break;
		default:
		}
		return new TravelPath(source, destination, move);
	}

	/**
	 * Find all neighbor nodes from given node.
	 * 
	 * @param node node
	 * @return List of neighbor nodes from given node.
	 */
	private List<Node> getNeighbors(Node node) {
		List<Node> neighbors = new ArrayList<Node>();
		for (Path edge : paths) {
			if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}

	/**
	 * Find the node in specified node list with the minimum distances from source. 
	 * @param nodes node list
	 * @return the node in specified node list with the minimum distances from source. 
	 */
	private Node getMinimum(Set<Node> nodes) {
		Node minimum = null;
		for (Node node : nodes) {
			if (minimum == null) {
				minimum = node;
			} else {
				if (getShortestDistance(node) < getShortestDistance(minimum)) {
					minimum = node;
				}
			}
		}
		return minimum;
	}

	/**
	 * Check if the node is settled.
	 * 
	 * @param node node
	 * @return Check if the node is settled.
	 */
	private boolean isSettled(Node node) {
		return settledNodes.contains(node);
	}

	/**
	 * Find the shortest distance from specified destination node to [0,0].
	 * 
	 * @param destination destination node.
	 * @return shortest distance from specified destination node to [0,0].
	 */
	private int getShortestDistance(Node destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	/**
	 * This method returns the path from [0,0] to the specified destination node and
	 * NULL if no path exists
	 * 
	 * @param destination destination node
	 * @return path from [0,0] to the selected target and NULL if no path exists
	 */
	public LinkedList<TravelPath> getPath(Node destination) {
		LinkedList<TravelPath> paths = new LinkedList<TravelPath>();
		Node step = nodes.get(GraphMgr.getKey(destination.getX(), destination.getY()));
		TravelPath path;

		while (predecessors.get(step) != null) {
			path = predecessors.get(step);
			paths.add(path);
			step = path.getSource();
		}
		// Put it into the correct order
		Collections.reverse(paths);
		return paths;
	}

	@Override
	public String calcMovement(Node destination) {
		GraphMgr mgr = new GraphMgr();
		Graph graph = mgr.init(0, 0, destination.getX(), destination.getY());
		this.nodes = graph.getNodes();
		this.paths = new ArrayList<Path>(graph.getPaths());
		this.init();

		LinkedList<TravelPath> paths = getPath(destination);
		StringBuffer sb = new StringBuffer();
		for (TravelPath path : paths) {
			sb.append(path.getMove().getCommand());
		}
		return sb.toString();
	}
}