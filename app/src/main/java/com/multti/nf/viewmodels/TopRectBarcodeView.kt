package com.multti.nf.viewmodels

import android.content.Context
import android.content.res.Resources
import android.graphics.Rect
import android.util.AttributeSet
import android.util.TypedValue
import com.journeyapps.barcodescanner.BarcodeView
import com.journeyapps.barcodescanner.Size

class TopRectBarcodeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BarcodeView(context, attrs, defStyleAttr) {

    override fun getFramingRectSize(): Size {
        return Size(Resources.getSystem().displayMetrics.widthPixels, Resources.getSystem().displayMetrics.heightPixels)
    }

    override fun calculateFramingRect(container: Rect?, surface: Rect?): Rect {
        // Cálculo do padding de 26dp
        val paddingDp = 26
        val paddingPx = dpToPx(paddingDp)
        val paddingDpTop = 65
        val paddingTop =dpToPx(paddingDpTop)

        // Cria um novo retângulo baseado no container
        val intersection = Rect(container)

        // Define o padding de 26dp em cada lado
        intersection.left += paddingPx
        intersection.top += paddingTop
        intersection.right -= paddingPx
        intersection.bottom -= paddingPx

        return intersection
    }

    private fun dpToPx(dp: Int): Int {
        return (TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            Resources.getSystem().displayMetrics
        ) + 0.5f).toInt()
    }
}