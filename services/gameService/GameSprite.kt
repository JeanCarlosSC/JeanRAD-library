package services.gameService

import java.awt.Image
import java.util.*
import javax.swing.Icon
import javax.swing.ImageIcon
import javax.swing.JLabel

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
abstract class GameSprite private constructor(x: Int, y: Int, icono: Icon) : JLabel() {
    private val index //the index is positive
            : ArrayList<Int>
    private var currentIndex = 0

    constructor(x: Int, y: Int, path: String?) : this(x, y, ImageIcon(Icon::class.java.getResource(path))) {}
    constructor(x: Int, y: Int, width: Int, height: Int, path: String?) : this(x, y, ImageIcon(ImageIcon(Icon::class.java.getResource(path)).image.getScaledInstance(width, height, Image.SCALE_DEFAULT))) {}
    constructor(x: Int, y: Int, scale: Int, path: String?) : this(x, y, ImageIcon(Icon::class.java.getResource(path)).iconWidth * scale,
            ImageIcon(Icon::class.java.getResource(path)).iconHeight * scale, path) {
    }

    fun nextIndex() {
        if (currentIndex < index.size / 2 && index.size / 2 > 1) setIndex(currentIndex + 1) else setIndex(0)
    }

    fun setIndex(index: Int) {
        var index = index
        currentIndex = index
        if (index != 0) {
            index *= 2
            setLocation(this.index[index - 1] * -1, this.index[index] * -1)
        } else setLocation(this.index[0], this.index[1])
    }

    fun addIndex(x: Int, y: Int) {
        index.add(x)
        index.add(y)
    }

    init {
        index = ArrayList()
        addIndex(x, y)
        setIndex(0)
        background = null
        icon = icono
        setSize(icono.iconWidth, icono.iconHeight)
    }
}