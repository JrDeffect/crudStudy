package com.jrDeffect.javacore.model;

import java.util.List;
import java.util.Objects;

public class Writer {
    private int id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private Region region;

    public Writer(int id, String firstName, String lastName, List<Post> posts, Region region) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writer writer = (Writer) o;
        return id == writer.id &&
                firstName.equals(writer.firstName) &&
                lastName.equals(writer.lastName) &&
                posts.equals(writer.posts) &&
                region.equals(writer.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, posts, region);
    }

    @Override
    public String toString() {
        return "Writer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", posts=" + posts +
                ", region=" + region +
                '}';
    }
}
