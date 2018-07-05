package com.buggyarts.customviews.model;

import java.util.ArrayList;

public class StoryData {

    // story cover image
    MDImage coverImage;

    // sub image
    String subImage;

    // story image array
    ArrayList<MDImage> images;

    // story title
    String title;

    // story title2
    String title2;

    // story subText
    String subText;

    // story timeStamp
    String timeStamp;

    // story timeStampPretty
    String timeStampPretty;

    // story description
    String shortDescription;

    // story fullStory;
    String fullStory;

    // story fullStoryUrl
    String fullStoryUrl;

    // story views
    Integer views;

    // story likes
    Integer likes;

    // story hasVideo
    Boolean hasVideo;

    // story videoUrl
    String  videoUrl;

    /**
     * getter and setter methods
     */
    public MDImage getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(MDImage coverImage) {
        this.coverImage = coverImage;
    }

    public String getSubImage() {
        return subImage;
    }

    public void setSubImage(String subImage) {
        this.subImage = subImage;
    }

    public ArrayList<MDImage> getImages() {
        return images;
    }

    public void setImages(ArrayList<MDImage> images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTimeStampPretty() {
        return timeStampPretty;
    }

    public void setTimeStampPretty(String timeStampPretty) {
        this.timeStampPretty = timeStampPretty;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullStory() {
        return fullStory;
    }

    public void setFullStory(String fullStory) {
        this.fullStory = fullStory;
    }

    public String getFullStoryUrl() {
        return fullStoryUrl;
    }

    public void setFullStoryUrl(String fullStoryUrl) {
        this.fullStoryUrl = fullStoryUrl;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(Boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
