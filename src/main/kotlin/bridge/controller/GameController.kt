package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.BridgeGame
import bridge.view.InputView

class GameController {
    fun run() {
        val bridge = createBridge()
        progressGame(bridge)
    }

    private fun progressGame(bridge: List<String>) {
        val game = BridgeGame(bridge)
        while (!game.isClear()) {
            val move = validateMove()
            game.move(move)
        }
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

    private fun validateMove(): String {
        while (true) {
            try {
                return InputView().readMoving()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}