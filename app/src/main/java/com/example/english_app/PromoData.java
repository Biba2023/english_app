package com.example.english_app;

import androidx.annotation.DrawableRes;

public class PromoData {
    @DrawableRes
    public  Integer imageId;
    String title;
    String description;
    String button;
    public  Integer scrollId;


    static PromoData[] values = new PromoData[]{
            new PromoData(R.drawable.onboarding_1, "Confidence in your words","With conversation-based learning, you'll be talking from lesson one", R.drawable.onboarding_dots_1, "Next"),
            new PromoData(R.drawable.onboarding_2, "Take your time to learn","Develop a habit of learning and make it a part of your daily routine", R.drawable.onboarding_dots_2, "More"),
            new PromoData(R.drawable.onboarding_3, "The lessons you need to learn", "Using a variety of learning styles to learn and retain", R.drawable.onboarding_dots_3, "Choose")
    };

    public PromoData(int img, String title, String desc, int scroll, String button) {
        this.imageId = img;
        this.title = title;
        this.description = desc;
        this.scrollId = scroll;
        this.button = button;
    }
}