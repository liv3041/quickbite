package com.example.users

class DiscountItem(
    private var discountImage:Int,
    private var discountName:String,
    private var discountDescription:String,
    val backgroundColor: Int
) {
    fun getDiscountName():String{
        return discountName
    }
    fun setDiscountName(name:String){
        this.discountName = name
    }

    fun getDiscountDescription():String{
        return discountDescription
    }
    fun setDiscountDescription(description:String){
        this.discountName = description
    }

    fun getDiscountImage():Int{
        return discountImage
    }
    fun setDiscountName(image:Int){
        this.discountImage = image
    }
}