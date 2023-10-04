package com.example.lab7.ui.Meals.view

import androidx.lifecycle.ViewModel
import com.example.lab7.Networking.Response.MealsCategoriesResponse
import com.example.lab7.ui.Meals.repository.MealsRepository

class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}