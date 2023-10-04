package com.example.lab7.ui.Meals.repository

import com.example.lab7.Networking.MealsWebService
import com.example.lab7.Networking.Response.MealDetailResponse
import com.example.lab7.Networking.Response.MealInstructionResponse
import com.example.lab7.Networking.Response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        return webService.getMeals().enqueue(object : Callback<MealsCategoriesResponse> {
            override fun onResponse(
                call: Call<MealsCategoriesResponse>,
                response: Response<MealsCategoriesResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<MealsCategoriesResponse>, t: Throwable) {
                // TODO treat failure
            }
        })
    }
    fun getRecipes(category: String, successCallback: (response: MealDetailResponse?) -> Unit) {
        return webService.getRecipes(category).enqueue(object : Callback<MealDetailResponse>  {
            override fun onResponse(
                call: Call<MealDetailResponse>,
                response: Response<MealDetailResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<MealDetailResponse>, t: Throwable) {
                // TODO treat failure
            }
        })
    }
    fun getInstructions(recipeId: String, successCallback: (response: MealInstructionResponse?) -> Unit) {
        return webService.getMealInstructions(recipeId).enqueue(object : Callback<MealInstructionResponse> {
            override fun onResponse(
                call: Call<MealInstructionResponse>,
                response: Response<MealInstructionResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<MealInstructionResponse>, t: Throwable) {
                // TODO treat failure
            }
        })
    }
}