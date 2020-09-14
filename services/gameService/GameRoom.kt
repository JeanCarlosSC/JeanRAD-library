package services.gameService

import java.util.*
import javax.swing.JPanel

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
abstract class GameRoom(x: Int, y: Int, width: Int, height: Int, title: String) : JPanel() {
    private val objects: ArrayList<GameObject>
    val title: String
    fun addGameObject(`object`: GameObject, height: Int) {
        objects.add(`object`)
        add(objects[objects.size - 1], height)
    }

    fun addGameObject(`object`: GameObject) {
        objects.add(`object`)
        add(objects[objects.size - 1])
    }

    fun addTiles(x: Int, y: Int, filas: Int, columnas: Int, tile: services.gameService.GameTile?) {
        for (i in 0 until filas) {
            for (j in 0 until columnas) {
                //Attempts
                //add(new Class<tile.getClass()>(x+j*64,y+i*64));
                //add(tile.getClass().newInstance().setLocation(x+j*64,y+i*64));
            }
        }
    }

    fun run() { //this method runs 60 times per second
        isVisible = false
        if (objects.size > 0) {
            for (i in objects.indices) {
                objects[i].run() //moves my JLabels with setLocation
            }
        }
        isVisible = true
        repaint()
    }

    init {
        objects = ArrayList()
        this.title = title
        ignoreRepaint = true
        setLocation(x * -1, y * -1)
        setSize(width, height)
        layout = null
    }
}