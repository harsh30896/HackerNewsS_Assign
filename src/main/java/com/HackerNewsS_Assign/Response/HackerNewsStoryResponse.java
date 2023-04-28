
package com.HackerNewsS_Assign.Response;

import com.HackerNewsS_Assign.Service.HackerNewService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HackerNewsStoryResponse {

    @JsonProperty("by")
    private String by;
    @JsonProperty("descendants")
    private Integer descendants;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("kids")
    private List<Integer> kids;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("time")
    private Integer time;
    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private String type;
    @JsonProperty("url")
    private String url;

    @JsonProperty("by")
    public String getBy() {
        return by;
    }

    @JsonProperty("by")
    public void setBy(String by) {
        this.by = by;
    }

    @JsonProperty("descendants")
    public Integer getDescendants() {
        return descendants;
    }

    @JsonProperty("descendants")
    public void setDescendants(Integer descendants) {
        this.descendants = descendants;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("kids")
    public List<Integer> getKids() {
        return kids;
    }

    @JsonProperty("kids")
    public void setKids(List<Integer> kids) {
        this.kids = kids;
    }

    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
    }

    @JsonProperty("time")
    public Integer getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Integer time) {
        this.time = time;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "HackerNewsStoryResponse{" +
                "by='" + by + '\'' +
                ", descendants=" + descendants +
                ", id=" + id +
                ", kids=" + kids +
                ", score=" + score +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


}