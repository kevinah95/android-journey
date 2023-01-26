package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import com.example.dessertclicker.data.DessertUiState
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel: ViewModel() {

    private val desserts = dessertList

    private val _uiState = MutableStateFlow(DessertUiState())

    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            val currentDessertIndex = currentState.currentDessertIndex
            currentState.copy(
                currentDessertPrice = desserts[currentDessertIndex].price,
                currentDessertImageId = desserts[currentDessertIndex].imageId
            )
        }
    }

    fun updateRevenue(updatedRevenue: Int) {
        val dessertsSold = _uiState.value.dessertsSold.inc();
        val dessertToShow = determineDessertToShow(dessertsSold)
        _uiState.update { currentState ->
            currentState.copy(
                revenue = currentState.revenue.plus(updatedRevenue),
                dessertsSold = dessertsSold,
                currentDessertImageId = dessertToShow.imageId,
                currentDessertPrice = dessertToShow.price
            )
        }
    }

    /**
     * Determine which dessert to show.
     */
    fun determineDessertToShow(
        dessertsSold: Int
    ): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }

        return dessertToShow
    }
}