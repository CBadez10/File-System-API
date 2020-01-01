
package com.cambot.filesys.models;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "path",
    "mode",
    "type",
    "sha",
    "size",
    "url"
})
public class Tree {

    @JsonProperty("path")
    private String path;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("type")
    private String type;
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tree() {
    }

    /**
     * 
     * @param mode
     * @param path
     * @param size
     * @param type
     * @param sha
     * @param url
     */
    public Tree(String path, String mode, String type, String sha, Integer size, String url) {
        super();
        this.path = path;
        this.mode = mode;
        this.type = type;
        this.sha = sha;
        this.size = size;
        this.url = url;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
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
