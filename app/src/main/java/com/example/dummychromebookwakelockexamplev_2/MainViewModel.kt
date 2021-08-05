package com.example.dummychromebookwakelockexamplev_2


import android.annotation.SuppressLint
import android.app.Application
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dummychromebookwakelockexamplev_2.databinding.ActivityMainBinding


class MainViewModel( ): ViewModel(){
    private var _counter: MutableLiveData<Int> = MutableLiveData<Int>()
    val counter : LiveData<Int>
        get() = _counter
  @SuppressLint("StaticFieldLeak")
  lateinit var myAccessibilityService: MyAccessibilityService
    init {
        myAccessibilityService= MyAccessibilityService()
        Log.i("ViewModel","SeCreoElViewMOdel")
        resetCounter()
    }

    fun resetCounter(){
        _counter.value= 0
    }
    fun addSecondToCounter(){
        _counter.value= _counter.value?.plus(1)
    }

    fun startTimeCounter(binding: ActivityMainBinding) {
        val countTime: TextView = binding.timer
        if (counter.value == 0) {
            object : CountDownTimer(50000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
//                countTime.text = viewModel.counter.value.toString()
                    addSecondToCounter()
                }
                override fun onFinish() {
                    resetCounter()
                    startTimeCounter(binding)
                }
            }.start()
        }
    }


}