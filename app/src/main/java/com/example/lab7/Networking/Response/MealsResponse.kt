package com.example.lab7.Networking.Response

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(val categories: List<MealResponse>)

data class MealDetailResponse(val meals: List<MealDetail>)

data class MealInstructionResponse(val meals: List<MealInstruction>)

data class MealResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)


data class MealDetail(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String
)

data class MealInstruction(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strInstructions") val instructions: String,
    @SerializedName("strMealThumb") val imageUrl: String,
)

