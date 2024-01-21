package com.example.users

import android.media.Image

class RestaurantItem(
    private var restaurantName:String,
    private var restaurantImage:Int,
    private var ratings:String,
    private var popularFoodItem:String,
    private var pricingForOne:String,
    private var distanceFromUser:String,
    private var distanceInKm:String
) {
    fun getRestaurantName():String{
        return restaurantName
    }
    fun setFoodName(rName:String){
        this.restaurantName = rName
    }
    fun getRestaurantImage():Int{
        return restaurantImage
    }
    fun setRestaurantImage(rImage:Int){
        this.restaurantImage = rImage
    }
    fun getRatings():String{
        return ratings
    }
    fun setRatings(rating:String){
        this.ratings = rating
    }
    fun getPopularFoodItem():String{
        return popularFoodItem
    }
    fun setPopularFoodItem(popularFood:String){
        this.popularFoodItem = popularFood
    }
    fun getPricing():String{
        return pricingForOne
    }
    fun setPricing(pricing:String){
        this.pricingForOne = pricing
    }
    fun getDistanceFromUser():String{
        return distanceFromUser
    }
    fun setDistanceFromUser(userDistance:String){
        this.distanceFromUser = userDistance
    }
    fun getDistanceInKm():String{
        return distanceInKm
    }
    fun setDistanceInKm(distanceKm:String){
        this.distanceInKm = distanceKm
    }
}