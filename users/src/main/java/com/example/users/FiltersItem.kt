package com.example.users

class FiltersItem(
    private var filterLeftImage:Int,
    private var filterName: String,
    private var filterRightImage:Int
) {
    fun getFilterName():String{
        return filterName
    }
    fun setFilterName(name:String){
        this.filterName = name
    }
    fun getFilterLeftImage():Int{
        return filterLeftImage
    }
    fun setFilterLeftImage(image:Int){
        this.filterLeftImage = image
    }

    fun getFilterRightImage():Int{
        return filterRightImage
    }
    fun setFilterRightImage(image:Int){
        this.filterRightImage = image
    }
}