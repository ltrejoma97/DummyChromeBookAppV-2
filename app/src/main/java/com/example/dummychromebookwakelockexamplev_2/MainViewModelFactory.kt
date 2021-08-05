//package com.example.dummychromebookwakelockexamplev_2
//
//import android.app.Application
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import java.lang.IllegalArgumentException
//
//class MainViewModelFactory(private val contractToService: MainViewModel.ContractToService, private val application: Application):ViewModelProvider.Factory {
//   @Suppress("unchecked_cast")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
//            return MainViewModel(contractToService, application) as T
//        }
//    throw IllegalArgumentException("Unknow ViewModelClass")
//    }
//}