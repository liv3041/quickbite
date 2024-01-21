package com.example.users

class FoodItem(
    private var foodName:String,
    private var foodImage:Int
) {
     fun getFoodName():String{
         return foodName
     }
    fun setFoodName(foodN:String){
        this.foodName = foodN
    }
    fun getFoodImage():Int{
        return foodImage
    }
    fun setFoodImage(foodImg:Int){
        this.foodImage = foodImg    }
}