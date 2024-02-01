package com.example.users

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class DotsIndicatorDecoration(
    private var context: Context,
    private var radius: Int,
    private var padding: Int,
    private var indicatorHeight: Int,
    @ColorInt private var colorInactive: Int,
    @ColorInt private var colorActive: Int,
): RecyclerView.ItemDecoration() {


    private var indicatorItemPadding:Int =0

    private lateinit var inactivePaint:Paint
    private lateinit var activePaint:Paint



//    fun DotsIndicatorDecoration() {
//        val strokeWidth = Resources.getSystem().displayMetrics.density * 1
//        this.radius = radius
//        inactivePaint.strokeCap = Paint.Cap.ROUND
//        inactivePaint.strokeWidth = strokeWidth
//        inactivePaint.style = Paint.Style.STROKE
//        inactivePaint.isAntiAlias = true
//        inactivePaint.color = colorInactive
//        activePaint.strokeCap = Paint.Cap.ROUND
//        activePaint.strokeWidth = strokeWidth
//        activePaint.style = Paint.Style.FILL
//        activePaint.isAntiAlias = true
//        activePaint.color = colorActive
//        indicatorItemPadding = padding
//        this.indicatorHeight = indicatorHeight
//    }
init {
    indicatorItemPadding = padding
    this.indicatorHeight = indicatorHeight
    initPaints(context)
}

    private fun initPaints(context: Context) {
        val resources = context.resources
        var strokeWidth = Resources.getSystem().displayMetrics.density * 1
        inactivePaint = Paint().apply {
            strokeCap = Paint.Cap.ROUND
            strokeWidth = strokeWidth
            style = Paint.Style.STROKE
            isAntiAlias = true
            color = colorInactive
        }

        activePaint = Paint().apply {
            strokeCap = Paint.Cap.ROUND
            strokeWidth = strokeWidth
            style = Paint.Style.FILL
            isAntiAlias = true
            color = colorActive
        }
    }
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val adapter = parent.adapter ?: return
        val itemCount = adapter.itemCount

        // center horizontally, calculate width and subtract half from center
        val totalLength = (radius * 2 * itemCount).toFloat()
        val paddingBetweenItems = (Math.max(0, itemCount - 1) * indicatorItemPadding).toFloat()
        val indicatorTotalWidth = totalLength + paddingBetweenItems
        val indicatorStartX = (parent.width - indicatorTotalWidth) / 2f

        // center vertically in the allotted space
        val indicatorPosY = parent.height - indicatorHeight / 2f
        drawInactiveDots(c, indicatorStartX, indicatorPosY, itemCount)
        val activePosition: Int
        activePosition = if (parent.layoutManager is GridLayoutManager) {
            (parent.layoutManager as GridLayoutManager?)!!.findFirstVisibleItemPosition()
        } else if (parent.layoutManager is LinearLayoutManager) {
            (parent.layoutManager as LinearLayoutManager?)!!.findFirstVisibleItemPosition()
        } else {
            // not supported layout manager
            return
        }
        if (activePosition == RecyclerView.NO_POSITION) {
            return
        }

        // find offset of active page if the user is scrolling
        val activeChild = parent.layoutManager!!.findViewByPosition(activePosition) ?: return
        drawActiveDot(c, indicatorStartX, indicatorPosY, activePosition)
    }

    private fun drawInactiveDots(
        c: Canvas,
        indicatorStartX: Float,
        indicatorPosY: Float,
        itemCount: Int,
    ) {
        // width of item indicator including padding
        val itemWidth = (radius * 2 + indicatorItemPadding).toFloat()
        var start = indicatorStartX + radius
        for (i in 0 until itemCount) {
            c.drawCircle(start, indicatorPosY, radius.toFloat(), inactivePaint)
            start += itemWidth
        }
    }

    private fun drawActiveDot(
        c: Canvas, indicatorStartX: Float, indicatorPosY: Float,
        highlightPosition: Int,
    ) {
        // width of item indicator including padding
        val itemWidth = (radius * 2 + indicatorItemPadding).toFloat()
        val highlightStart = indicatorStartX + radius + itemWidth * highlightPosition
        c.drawCircle(highlightStart, indicatorPosY, radius.toFloat(), activePaint)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = indicatorHeight
    }
}