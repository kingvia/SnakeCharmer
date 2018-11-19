package com.lu.wang.snakecharmer.data;

import java.util.Collection;
import java.util.Hashtable;

public class Graph {
	/**
	 * nodes
	 */
	private Hashtable<String, Node> nodes;

	/**
	 * paths
	 */
	private Collection<Path> paths;

	/**
	 * Constructor
	 */
	public Graph() {
	}

	/**
	 * Constructor
	 * 
	 * @param x
	 * @param y
	 */
	public Graph(Hashtable<String, Node> nodes, Collection<Path> paths) {
		this.setNodes(nodes);
		this.setPaths(paths);
	}

	/**
	 * @return the nodes
	 */
	public Hashtable<String, Node> getNodes() {
		return nodes;
	}

	/**
	 * @param collection the nodes to set
	 */
	public void setNodes(Hashtable<String, Node> nodes) {
		this.nodes = nodes;
	}

	/**
	 * @return the paths
	 */
	public Collection<Path> getPaths() {
		return paths;
	}

	/**
	 * @param paths the paths to set
	 */
	public void setPaths(Collection<Path> paths) {
		this.paths = paths;
	}
}
