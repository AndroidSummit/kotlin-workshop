package org.androidsummit.notepad.given

import android.content.Context
import android.graphics.Rect
import android.support.annotation.DimenRes
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Phil Oliver on 9/8/16.
 *
 * Sets the spacing between RecyclerView objects to the specified dimension. Note that spacing will only be added <i>between</i> items.
 * Outer spacing for edge items can be accomplished by setting padding values on the RecyclerView, itself.
 */
class SpaceItemDecoration(context: Context, @DimenRes dimenResId: Int, var orientation: Int = -1) : RecyclerView.ItemDecoration() {

    private val space: Int = context.resources.getDimensionPixelSize(dimenResId)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        val position = parent.getChildAdapterPosition(view)

        if (getOrientation(parent) == LinearLayoutManager.VERTICAL) {
            if (position != 0) {
                outRect.top = space
            }
        } else {
            if (position != 0) {
                outRect.left = space
            }
        }
    }

    private fun getOrientation(parent: RecyclerView): Int {
        if (orientation == -1) {
            val lm = parent.layoutManager
            if (lm is LinearLayoutManager) {
                orientation = lm.orientation
            } else {
                throw IllegalStateException("SpaceItemDecoration can only be used with a LinearLayoutManager.")
            }
        }

        return orientation
    }
}