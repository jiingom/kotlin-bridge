package bridge.controller

import bridge.view.InputView

class GameController {
    fun run() {
        val size = validateBridgeSize()
    }

    private fun validateBridgeSize(): Int {
        while (true) {
            try {
                return InputView().readBridgeSize()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}