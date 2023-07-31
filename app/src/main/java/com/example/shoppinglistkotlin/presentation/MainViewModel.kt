package com.example.shoppinglistkotlin.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglistkotlin.data.ShopListRepositoryImpl
import com.example.shoppinglistkotlin.domain.DeleteShopItemUseCase
import com.example.shoppinglistkotlin.domain.EditShopItemUseCase
import com.example.shoppinglistkotlin.domain.GetShopListUseCase
import com.example.shoppinglistkotlin.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListUseCase = DeleteShopItemUseCase(repository)
    private val editShopListUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
    }

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopListUseCase.deleteShopItem(shopItem)
    }
    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopListUseCase.editShopItem(newItem)
    }
}