package lib.sRAD.gui.component

import lib.sRAD.gui.sComponent.SFrame
import java.awt.Color
import lib.sRAD.gui.sComponent.SLabel
import javax.swing.ImageIcon
import java.awt.Image
import javax.swing.SwingConstants
import lib.sRAD.gui.sComponent.SButton
import lib.sRAD.gui.sComponent.SPanel
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.JOptionPane
import java.awt.event.MouseMotionListener
import javax.swing.JFrame
import kotlin.system.exitProcess

class MainBar (
    frame: SFrame,
    private var frameWidth: Int = 1280,
    move: Boolean = true,
    backgroundColor: Color? = Theme.bg2,
    borderColor: Color? = DTII5
) : SPanel() {
    private val mainPanel: SPanel
    private val lLogo: SLabel = SLabel()
    private val lTitle: SLabel = SLabel()
    private var x0 = 0
    private var y0 = 0

    /**
     * Establece logo al main bar
     * @param icon logo
     */
    fun setLogo(icon: ImageIcon) {
        val iLogo = ImageIcon(icon.image.getScaledInstance(16, 16, Image.SCALE_DEFAULT))
        lLogo.setProperties(5, 5, iLogo)
    }

    fun setTitle(title: String?) {
        lTitle.setProperties(26, 0, frameWidth-106, 28, title, fontTitleMini, Theme.mbFg, SwingConstants.CENTER)
    }

    companion object {
        private val iBtExitOn = ImageIcon("src/main/resources/sRAD/mainBar/btExitOn.png")
        private val iBtExitOff = ImageIcon("src/main/resources/sRAD/mainBar/btExitOff.png")
        private val iBtMinOff = ImageIcon("src/main/resources/sRAD/mainBar/btMinOff.png")
        private val iBtMinOn = ImageIcon("src/main/resources/sRAD/mainBar/btMinOn.png")
        private var btExit: SButton? = null
        private var btMin: SButton? = null
    }

    init {
        mainPanel = SPanel(0, 0, frameWidth, 27, backgroundColor, null, null)
        if (move) {
            mainPanel.addMouseMotionListener(object : MouseMotionListener {
                override fun mouseDragged(e: MouseEvent) {
                    if (e.source === mainPanel) {
                        frame.setLocation(e.xOnScreen - x0, e.yOnScreen - y0)
                    }
                }

                override fun mouseMoved(e: MouseEvent) {
                    if (e.source === mainPanel) {
                        x0 = e.x
                        y0 = e.y
                    }
                }
            })
        }
        add(mainPanel)
        mainPanel.add(getBtMin(frame))
        mainPanel.add(getBtExit())
        mainPanel.add(lLogo)
        mainPanel.add(lTitle)
        setProperties(0, 0, frameWidth, 29, borderColor, null)
    }

    /**
     * button para TERMINAR EJECUCIÓN
     * @return botón decorado e implementado
     */
    fun getBtExit(): SButton? {
        if (btExit == null) {
            btExit = SButton(frameWidth - 48, 0, iBtExitOff, defaultCursor)
            btExit!!.addMouseListener(object : MouseListener {
                override fun mouseExited(e: MouseEvent) {
                    if (e.source === btExit) {
                        btExit!!.icon = iBtExitOff
                    }
                }

                override fun mouseClicked(e: MouseEvent) {
                    if (e.source === btExit) {
                        if (JOptionPane.showConfirmDialog(null, "Desea salir?") == 0) {
                            exitProcess(0)
                        }
                    }
                }

                override fun mousePressed(e: MouseEvent) {}
                override fun mouseReleased(e: MouseEvent) {}
                override fun mouseEntered(e: MouseEvent) {
                    if (e.source === btExit) btExit!!.icon = iBtExitOn
                }
            })
        }
        return btExit
    }

    /**
     * botón decorado para minimizar ventanas
     * @param frame ventana que se minimizará
     * @return botón para minimizar frame
     */
    fun getBtMin(frame: SFrame): SButton? {
        if (btMin == null) {
            btMin = SButton(frameWidth - 75, 0, iBtMinOff, defaultCursor)
            btMin!!.addMouseListener(object : MouseListener {
                override fun mouseClicked(e: MouseEvent) {
                    frame.extendedState = JFrame.ICONIFIED
                }

                override fun mousePressed(e: MouseEvent) {}
                override fun mouseReleased(e: MouseEvent) {}
                override fun mouseEntered(e: MouseEvent) {
                    btMin!!.icon = iBtMinOn
                }

                override fun mouseExited(e: MouseEvent) {
                    btMin!!.icon = iBtMinOff
                }
            })
        }
        return btMin
    }
}