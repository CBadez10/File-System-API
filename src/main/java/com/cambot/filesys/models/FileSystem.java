
package com.cambot.filesys.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "hash", "type", "name", "path", "size", "date", "creatorName", "parentPath", "parentID",
		"children" })
public class FileSystem {

	@Override
	public String toString() {
		return "FileSystem [hash=" + hash + ", type=" + type + ", name=" + name + ", path=" + path + ", size=" + size
				+ ", date=" + date + ", creatorName=" + creatorName + ", parentPath=" + parentPath + ", parentID="
				+ parentID + ", children=" + children + ", additionalProperties=" + additionalProperties + "]";
	}

	@JsonProperty("hash")
	private String hash;
	@JsonProperty("type")
	private String type;
	@JsonProperty("name")
	private String name;
	@JsonProperty("path")
	private String path;
	@JsonProperty("size")
	private Integer size;
	@JsonProperty("date")
	private String date;
	@JsonProperty("creatorName")
	private String creatorName;
	@JsonProperty("parentPath")
	private Object parentPath;
	@JsonProperty("parentID")
	private Object parentID;
	@JsonProperty("children")
	private List<String> children = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public FileSystem() {
	}

	/**
	 * 
	 * @param date
	 * @param path
	 * @param size
	 * @param children
	 * @param parentPath
	 * @param name
	 * @param creatorName
	 * @param type
	 * @param hash
	 * @param parentID
	 */
	public FileSystem(String hash, String type, String name, String path, Integer size, String date, String creatorName,
			Object parentPath, Object parentID, List<String> children) {
		super();
		this.hash = hash;
		this.type = type;
		this.name = name;
		this.path = path;
		this.size = size;
		this.date = date;
		this.creatorName = creatorName;
		this.parentPath = parentPath;
		this.parentID = parentID;
		this.children = children;
	}

	@JsonProperty("hash")
	public String getHash() {
		return hash;
	}

	@JsonProperty("hash")
	public void setHash(String hash) {
		this.hash = hash;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("path")
	public String getPath() {
		return path;
	}

	@JsonProperty("path")
	public void setPath(String path) {
		this.path = path;
	}

	@JsonProperty("size")
	public Integer getSize() {
		return size;
	}

	@JsonProperty("size")
	public void setSize(Integer size) {
		this.size = size;
	}

	@JsonProperty("date")
	public String getDate() {
		return date;
	}

	@JsonProperty("date")
	public void setDate(String date) {
		this.date = date;
	}

	@JsonProperty("creatorName")
	public String getCreatorName() {
		return creatorName;
	}

	@JsonProperty("creatorName")
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	@JsonProperty("parentPath")
	public Object getParentPath() {
		return parentPath;
	}

	@JsonProperty("parentPath")
	public void setParentPath(Object parentPath) {
		this.parentPath = parentPath;
	}

	@JsonProperty("parentID")
	public Object getParentID() {
		return parentID;
	}

	@JsonProperty("parentID")
	public void setParentID(Object parentID) {
		this.parentID = parentID;
	}

	@JsonProperty("children")
	public List<String> getChildren() {
		return children;
	}

	@JsonProperty("children")
	public void setChildren(List<String> children) {
		this.children = children;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
