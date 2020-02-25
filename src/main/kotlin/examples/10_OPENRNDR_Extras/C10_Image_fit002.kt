
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadImage
import org.openrndr.extras.imageFit.FitMethod
import org.openrndr.extras.imageFit.imageFit
import org.openrndr.ffmpeg.ScreenRecorder
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun main(args: Array<String>) {
    application {
        program {
            val image = loadImage("data/images/cheeta.jpg")
            extend {
                // -- calculate dynamic margins
                val xm = cos(seconds * PI) * 50.0 + 50.0
                val ym = sin(seconds * PI) * 50.0 + 50.0
            
                drawer.imageFit(image, 20.0 + xm / 2.0, 20.0 + ym / 2, width - 40.0 - xm, height - 40.0 - ym)
            
                // -- illustrate the placement rectangle
                drawer.fill = null
                drawer.stroke = ColorRGBa.WHITE
                drawer.rectangle(20.0 + xm / 2.0, 20.0 + ym / 2.0, width - 40.0 - xm, height - 40.0 - ym)
            }
        }
    }
}
    