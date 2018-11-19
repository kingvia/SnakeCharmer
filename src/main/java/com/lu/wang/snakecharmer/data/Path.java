package com.lu.wang.snakecharmer.data;

public class Path {
	/**
	 * source
	 */
	private Node source;

	/**
	 * destination
	 */
	private Node destination;

	/**
	 * Constructor
	 * 
	 * @param x
	 * @param y
	 */
	public Path(Node source, Node destination) {
		this.setSource(source);
		this.setDestination(destination);
	}

	/**
	 * @return the source
	 */
	public Node getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(Node source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public Node getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(Node destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return getSource().toString() + "=>" + getDestination().toString();
	}
}
