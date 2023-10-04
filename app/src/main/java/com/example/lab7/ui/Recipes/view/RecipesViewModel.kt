package com.example.lab7.ui.Recipes.view

import androidx.lifecycle.ViewModel
import com.example.lab7.Networking.Response.MealDetailResponse
import com.example.lab7.Networking.Response.MealInstructionResponse
import com.example.lab7.ui.Meals.repository.MealsRepository

class RecipesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getRecipes(category: String, successCallback: (response: MealDetailResponse?) -> Unit) {
        repository.getRecipes(category) { response ->
            successCallback(response)
        }
    }
    fun getInstructions(recipeId: String, successCallback: (response: MealInstructionResponse?) -> Unit) {
        repository.getInstructions(recipeId) { response ->
            successCallback(response)
        }
    }

}
