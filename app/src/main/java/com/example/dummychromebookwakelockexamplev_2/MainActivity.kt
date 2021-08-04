package com.example.dummychromebookwakelockexamplev_2

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.PowerManager
import android.os.PowerManager.WakeLock
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val isTouch: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet
    ): View? {
        return super.onCreateView(parent, name, context, attrs)
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {

        val x: Float? = event?.getX()
        val y: Float? = event?.getY()
        val eventAction = event?.getAction()

        when (eventAction) {

            MotionEvent.ACTION_DOWN -> {
                Toast.makeText(
                    this,
                    "ACTION_DOWN AT COORDS " + "X: " + x + " Y: " + y,
                    Toast.LENGTH_SHORT
                ).show()
            }
            MotionEvent.ACTION_MOVE -> {
                Toast.makeText(this, "MOVE " + "X: " + x + " Y: " + y, Toast.LENGTH_SHORT).show()
            }
            MotionEvent.ACTION_UP -> {
                Toast.makeText(this, "ACTION_UP " + "X: " + x + " Y: " + y, Toast.LENGTH_SHORT)
                    .show()
            }
            else ->{
                Toast.makeText(this, "actividad", Toast.LENGTH_SHORT).show()
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
}