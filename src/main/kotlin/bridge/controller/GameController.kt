package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

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
            OutputView().printMap(game.get())
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