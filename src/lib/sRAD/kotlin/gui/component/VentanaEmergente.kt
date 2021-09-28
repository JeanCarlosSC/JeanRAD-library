package lib.sRAD.gui.component

import lib.sRAD.gui.sComponent.SFrame

open class VentanaEmergente(frame: SFrame, width: Int, height: Int): SFrame() {
    private val frame: SFrame

    init {
        this.frame = frame
        setProperties(width, height, Theme.veBg)
    }

    fun lanzar() {
        frame.isEnabled = false
        isVisible = true
    }

    fun cerrar() {
        frame.isEnabled = true
        this.isVisible = false
    }
}