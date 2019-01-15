package com.example.maria.homework_10.decoration

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.widget.RecyclerView

internal class SampleDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private var mPaint: Paint = Paint()

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        mPaint.style = Paint.Style.FILL
        for (i in 0 until parent.childCount) {
            val view = parent.getChildAt(i)
            mPaint.color = Color.parseColor("#ababab")
            c.drawRect(view.left.toFloat(), view.bottom.toFloat(), view.right.toFloat(), (view.bottom + 1.px).toFloat(), mPaint)
        }
    }

    val Int.px: Int
        get() = (this * Resources.getSystem().displayMetrics.density).toInt()

    companion object {
        private val ATTRS = intArrayOf(android.R.attr.listDivider)
    }
}

