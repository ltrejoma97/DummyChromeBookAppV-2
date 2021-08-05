package com.example.dummychromebookwakelockexamplev_2

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Property.of
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dummychromebookwakelockexamplev_2.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel:MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val exitButton: Button =binding.exitApp
        exitButton.setOnClickListener {
        finishAffinity()
        }
        viewModel.counter.observe(this, Observer { binding.timer.text=viewModel.counter.value.toString() })
       viewModel.startTimeCounter(binding)

    }

    override fun onCreateView(parent: View?, name: String, context: Context, attrs: AttributeSet): View? {

        viewModel= ViewModelProvider(this).get(MainViewModel::class.java)

        return super.onCreateView(parent, name, context, attrs)
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {

        val x: Float? = event?.getX()
        val y: Float? = event?.getY()
        val eventAction = event?.getAction()

        when (eventAction) {

            MotionEvent.ACTION_DOWN -> {
                viewModel.resetCounter()
            }
            else ->{
                viewModel.resetCounter()
            }
        }
        return super.dispatchTouchEvent(event)
    }

    @SuppressLint("RestrictedApi")
    override fun dispatchKeyShortcutEvent(event: KeyEvent?): Boolean {
         when (event?.keyCode) {
            KeyEvent.KEYCODE_O -> {
                return true
            }
            else ->{
                Toast.makeText(this, "Se presiono una tecla", Toast.LENGTH_SHORT).show()
                return super.dispatchKeyShortcutEvent(event)
            }
        }

    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode){
            KeyEvent.KEYCODE_SPACE ->{
                viewModel.resetCounter()
            }
            else ->{
                viewModel.resetCounter()
            }
        }

        return super.onKeyUp(keyCode, event)
    }
}