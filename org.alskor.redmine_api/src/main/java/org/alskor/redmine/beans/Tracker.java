package org.alskor.redmine.beans;

/**
 * Redmine's Tracker (bug/feature/task/...)
 */
public class Tracker {

	private Integer id;

	private String name;

	public Tracker() {
	}

	public Tracker(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
