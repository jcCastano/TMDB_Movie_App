package com.example.movie.ui.component

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.painter.Painter

class PlayButton(
    private val width: Float,
    private val height: Float
) : Painter() {
    private val path = Path()

    override val intrinsicSize: Size
        get() = Size(width = width, height = height)

    override fun DrawScope.onDraw() {
        val width = size.width / 20
        val height = size.height / 22

        path.apply {
            reset() // Clear previous path data
            moveTo(width * 0f, height * 3.444f)
            cubicTo(
                width * 0f, height * 1.509f,
                width * 2.069f, height * 0.279f,
                width * 3.768f, height * 1.203f
            )
            lineTo(width * 17.779f, height * 8.826f)
            cubicTo(
                width * 19.553f, height * 9.793f,
                width * 19.553f, height * 12.34f,
                width * 17.779f, height * 13.306f
            )
            lineTo(width * 3.768f, height * 20.929f)
            cubicTo(
                width * 2.069f, height * 21.854f,
                width * 0f, height * 20.623f,
                width * 0f, height * 18.689f
            )
            close()
        }

        drawIntoCanvas {
            drawPath(
                path = path,
                color = Color.White
            )
        }
    }
}
