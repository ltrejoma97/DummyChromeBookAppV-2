package com.example.dummychromebookwakelockexamplev_2

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.util.Log
import android.view.accessibility.AccessibilityEvent


class MyAccessibilityService(val contract:ContractToService) : AccessibilityService() {
    val test: String = "Lyrroyt"

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        val eventType = event.eventType
        var eventText: String? = null

        when (eventType) {
            AccessibilityEvent.TYPE_VIEW_CLICKED -> {
                eventText = "Clicked: "
            }
            AccessibilityEvent.TYPE_VIEW_FOCUSED -> {
                eventText = "Focused: "
            }
            AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED -> {
                eventText = "Typed"
            }

            AccessibilityEvent.TYPE_VIEW_SCROLLED -> {
                eventText = "scrolleaste"
            }
            AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED -> {
                eventText = "SeleccionasteAlgo"
            }
            AccessibilityEvent.TYPE_WINDOWS_CHANGED -> {
                eventText = "NewActivity"
            }
            AccessibilityEvent.TYPE_TOUCH_INTERACTION_START -> {
                eventText = "touchTHeSCREEN"
            }
        }
        eventText = eventText + event.text
        //print the typed text in the console. Or do anything you want here.
        contract.notifityAllOk(eventText)
        println("ACCESSIBILITY SERVICE : $eventText")
    }


    override fun onInterrupt() {
        //whatever
    }

    public override fun onServiceConnected() {
        //configure our Accessibility service
        val info = serviceInfo
        info.eventTypes = AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN
        info.notificationTimeout = 100
        this.serviceInfo = info
    }

    interface ContractToService {
        fun notifityAllOk(chartTyped:String) {}

    }
}