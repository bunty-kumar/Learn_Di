package com.example.learndi.dagger_example

import android.util.Log

interface AnalyticsService {
    fun trackEvent(eventName: String, eventType: String)
}

@ActivityScope
class MixPanel : AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("buntyTag", "mix panel - $eventName - $eventType")
    }
}

class FirebaseAnalytics : AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("buntyTag", "firebase analytics - $eventName - $eventType")
    }
}

