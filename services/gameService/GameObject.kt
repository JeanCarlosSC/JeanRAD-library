package services.gameService

import java.awt.Color
import javax.swing.JPanel

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
abstract class GameObject(x: Int, y: Int, width: Int, height: Int, sprite: services.gameService.GameSprite?) : JPanel() {
    private val sprite: services.gameService.GameSprite?
    fun nextIndex() {
        if (sprite != null) {
            sprite.nextIndex()
        }
    }

    fun run() {
        nextIndex()
    }

    init {
        this.sprite = sprite
        if (sprite != null) add(this.sprite)
        setLocation(x, y)
        setSize(width, height)
        layout = null
        background = Color(0, 0, 0, 1)
    }
}