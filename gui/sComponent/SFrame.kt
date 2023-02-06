package lib.sRAD.gui.sComponent

import lib.sRAD.gui.component.MainBar
import lib.sRAD.gui.component.Theme
import lib.sRAD.gui.component.blackBorderTransparent
import java.awt.Color
import java.awt.Component
import java.awt.LayoutManager
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.border.Border

open class SFrame(width: Int=1280, height: Int=720) : JFrame() {

    init  {
        setProperties(width, height)
    }

    fun setProperties(width: Int, height: Int, background: Color=Theme.fBg, undecorated: Boolean = true,
                      border: Border = blackBorderTransparent, relativeLocation: Component? = null,
                      visible: Boolean = false, defaultCloseOperation: Int = EXIT_ON_CLOSE, layout: LayoutManager? = null) {
        setSize(width, height)
        contentPane.background = background
        isUndecorated = undecorated
        rootPane.border = border
        setLocationRelativeTo(relativeLocation)
        setDefaultCloseOperation(defaultCloseOperation)
        setLayout(layout)
        isVisible = visible
    }

    fun setMainBar(title: String) {
        setMainBar(title, "src/main/resources/sRAD/exampleLogo.png", width)
    }

    fun setMainBar(title: String, pathLogo: String, width: Int) {
        val mainBar = if(width>100) {
            MainBar(this, width)
        }
        else {
            MainBar(this)
        }
        mainBar.setTitle(title)
        mainBar.setLogo(ImageIcon(pathLogo))
        add(mainBar)
        repaint()
    }

}