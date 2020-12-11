package swingRAD.sComponents

import swingRAD.*
import java.awt.Color
import java.awt.LayoutManager
import javax.swing.JPanel
import javax.swing.border.Border

open class SPanel(
    x: Int = 0,
    y: Int = 0,
    width: Int = 0,
    height: Int = 0,
    background: Color? = semiDarkGrayBlue,
    border: Border? = semiDarkGray2Border,
    layout: LayoutManager? = null
) : JPanel() {

    init {
        setProperties(x, y, width, height, background, border, layout)
    }

    fun setProperties(x: Int=0, y: Int=0, width: Int=0, height: Int=0, background: Color? = semiDarkGrayBlue, border: Border? = semiDarkGray2Border,
                             layout: LayoutManager? = null) {
        this.setBounds(x, y, width, height)
        this.background = background
        this.border = border
        this.layout = layout
    }
}