package com.jrDeffect.javacore.model;

import java.util.Objects;

public class Post {
    private int id;
    private String content;
    private boolean created;
    private boolean updated;

    public Post(int id, String content, boolean created, boolean updated) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
                created == post.created &&
                updated == post.updated &&
                content.equals(post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, created, updated);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
