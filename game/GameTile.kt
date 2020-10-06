package services.gameService

import java.awt.Image
import javax.swing.Icon
import javax.swing.ImageIcon
import javax.swing.JLabel

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
abstract class GameTile(x: Int, y: Int, path: String?, width: Int, height: Int, val title: String) : JLabel() {

    init {
        val iIcono = ImageIcon(Icon::class.java.getResource(path))
        val icono: Icon = ImageIcon(iIcono.image.getScaledInstance(width, height, Image.SCALE_DEFAULT))
        setSize(icono.iconWidth, icono.iconHeight)
        setLocation(x, y)
        icon = icono
    }
}