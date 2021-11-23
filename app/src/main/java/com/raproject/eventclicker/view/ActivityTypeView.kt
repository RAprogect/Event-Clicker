package com.raproject.eventclicker.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.raproject.eventclicker.R
import com.raproject.eventclicker.databinding.ActivityTypeViewBinding
import com.raproject.eventclicker.model.ActivityType

class ActivityTypeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding = ActivityTypeViewBinding.inflate(LayoutInflater.from(context),this)

    var onClick:((ActivityType?) -> Unit)? = null

    var type:ActivityType? = null
        set(value) {
            if(value == field) return
            field = value?:return
            binding.reminderTypeIcon.setImageDrawable(value.getIcon(context))
            binding.reminderTypeIcon.setColorFilter(value.getColor(context))
        }

    init {
        binding.reminderTypeIcon.setOnClickListener { onClick?.invoke(type) }
    }

    fun makeSelected(){
        binding.reminderTypeIcon.setBackgroundResource(R.drawable.base_item_shape_with_selected_border)
    }

    fun makeUnselected(){
        binding.reminderTypeIcon.setBackgroundResource(R.drawable.base_item_shape)
    }
}