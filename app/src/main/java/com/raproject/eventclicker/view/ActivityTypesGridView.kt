package com.raproject.eventclicker.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.raproject.eventclicker.databinding.ActivityTypesGridViewBinding
import com.raproject.eventclicker.model.ActivityType

class ActivityTypesGridView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var itemOnClick:((ActivityType?) -> Unit)? = null

    private var lastSelectedType:ActivityType? = null

    private val binding = ActivityTypesGridViewBinding.inflate(LayoutInflater.from(context),this)

    init {
        binding.apply {
            activity.initItem(ActivityType.Activity)
            music.initItem(ActivityType.Music)
            pet.initItem(ActivityType.Pet)

            rest.initItem(ActivityType.Rest)
            sick.initItem(ActivityType.Sick)
            coffee.initItem(ActivityType.CoffeeBreak)

            play.initItem(ActivityType.Play)
            wine.initItem(ActivityType.Wine)
            smoking.initItem(ActivityType.Smoking)
        }
    }

    private fun ActivityTypesGridViewBinding.getItemByType(activityType:ActivityType): ActivityTypeView {
       return when(activityType){
           ActivityType.CoffeeBreak -> coffee
           ActivityType.Sick -> sick
           ActivityType.Rest -> rest
           ActivityType.Pet -> pet
           ActivityType.Smoking -> smoking
           ActivityType.Wine -> wine
           ActivityType.Music -> music
           ActivityType.Activity -> activity
           ActivityType.Play -> play
       }
    }

    private fun ActivityTypeView.initItem(activityType:ActivityType){
        type = activityType
        onClick = { itemOnClick?.invoke(it) }
    }

    fun makeItemSelected(activityType:ActivityType){
        lastSelectedType?.let { type-> binding.getItemByType(type).makeUnselected() }
        binding.getItemByType(activityType).makeSelected()
        lastSelectedType = activityType
    }
}