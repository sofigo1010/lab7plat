package com.example.lab7.ui.Recipes.view

import RecipeCard
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab7.Networking.Response.MealDetail
import androidx.navigation.NavController
import com.example.lab7.ui.Meals.view.CategoryCard

@Composable
fun RecipesScreen(categoryName: String, navController: NavController) {
    val viewModel: RecipesViewModel = viewModel()
    val rememberedRecipes: MutableState<List<MealDetail>> = remember { mutableStateOf(emptyList<MealDetail>()) }

    viewModel.getRecipes(categoryName) { response ->
        val recipesFromTheApi = response?.meals
        rememberedRecipes.value = recipesFromTheApi.orEmpty()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // Contenedor principal
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            // Contenedor para el botón de regreso y el título "Recetas"
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Botón para regresar
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.DarkGray)
                }

                // Título "Recetas"
                Text(
                    text = "Recetas",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )

                // Espacio vacío para alinear el botón y el texto en los extremos opuestos
                Spacer(modifier = Modifier.width(48.dp)) // El ancho es aproximadamente el mismo que el del botón para equilibrar el espacio
            }

            Spacer(modifier = Modifier.height(16.dp)) // Espacio entre el título y el contenido

            // Contenido desplazable
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemsIndexed(rememberedRecipes.value.chunked(2)) { _, pair ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        pair.forEach { recipe ->
                            RecipeCard(recipeId = recipe.id, recipeName = recipe.name, recipeImage = recipe.imageUrl, navController = navController)
                        }
                    }
                }
            }
        }
    }
}








