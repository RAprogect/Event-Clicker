package com.raproject.eventclicker.model

import android.content.Context
import android.graphics.drawable.Drawable
import com.raproject.eventclicker.R
import com.raproject.eventclicker.tools.getColorCompat
import com.raproject.eventclicker.tools.getImageCompat

enum class ActivityType(val key: String, private val iconId: Int, private val eventColorId: Int) {

    CoffeeBreak("coffee", R.drawable.ic_coffe_event, R.color.blueType),
    Sick("sick", R.drawable.ic_sick, R.color.blueType),
    Rest("rest", R.drawable.ic_rest_event, R.color.greenType),
    Pet("pet", R.drawable.ic_pet_event, R.color.greenType),
    Smoking("smoking", R.drawable.ic_smoking_event, R.color.orangeType),
    Wine("wine", R.drawable.ic_wine_event, R.color.orangeType),
    Music("music", R.drawable.ic_music_event, R.color.greenType),
    Activity("activity", R.drawable.ic_activity, R.color.greenType),
    Play("play", R.drawable.ic_event, R.color.blueType);

    fun getColor(context: Context): Int {
        return context.getColorCompat(eventColorId)
    }

    fun getIcon(context: Context): Drawable? {
        return context.getImageCompat(iconId)
    }

    companion object {
        fun getTypeByKey(key: String): ActivityType {
            return when (key) {
                "coffee" -> CoffeeBreak
                "sick" -> Sick
                "rest" -> Rest
                "pet" -> Pet
                "smoking" -> Smoking
                "wine" -> Wine
                "music" -> Music
                "activity" -> Activity
                "play" -> Play
                else -> Play
            }
        }
    }
}
