package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.view.InputView

class GameController {
    fun run() {
        val bridge = createBridge()
    }

    private fun createBridge(): List<String> {
        val size = validateBridgeSize()
        return BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
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