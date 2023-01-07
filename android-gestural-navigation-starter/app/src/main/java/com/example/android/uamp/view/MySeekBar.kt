package com.example.android.uamp.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Build
import android.util.AttributeSet

class MySeekBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = android.R.attr.seekBarStyle
) : androidx.appcompat.widget.AppCompatSeekBar(context, attrs, defStyle) {

    private val gestureExclusionRects = mutableListOf<Rect>()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        updateGestureExclusion()
    }

    private fun updateGestureExclusion() {
        if (Build.VERSION.SDK_INT < 29) return

        thumb?.also {
            gestureExclusionRects += it.copyBounds()
        }
        systemGestureExclusionRects = gestureExclusionRects
    }

}